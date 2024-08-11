package com.example.recyclerviewproject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.User
import com.example.myapplication.UserAdapter
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.example.recyclerviewproject.ui.theme.RecyclerViewProjectTheme
import com.google.android.material.snackbar.Snackbar
import java.util.stream.IntStream.range

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)



        //binding.name="Hiii"


        val users = mutableListOf<User>(
            User("Ahmed Mohamed","Ahmed@gmail.com"),
            User("Mahmoud Mohamed","Mahmoud@gmail.com"),
            User("Mona Ahmed","Mona@gmail.com"),
            User("Menna Ali","Menna@gmail.com"),
            User("Youssef Mohamed","Youssef@gmail.com"),
            User("Ahmed Mohamed","Ahmed@gmail.com"),
            User("Mahmoud Ahmed","Mahmoud@gmail.com"),
            User("Yasmine Ahmed","Mona@gmail.com"),
            User("Mohamed Ali","Menna@gmail.com"),
            User("Farida Mohamed","Youssef@gmail.com")
        )



       val userAdapter = UserAdapter(users)
        binding.rvUsers.layoutManager=LinearLayoutManager(this)
        binding.rvUsers.adapter=userAdapter

        binding.toolbar.materialToolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.search -> {
                    Toast.makeText(this,R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this,R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this,R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }


        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }


        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    Toast.makeText(this, R.string.home_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.gallery -> {
                    Toast.makeText(this, R.string.gallery_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.slideshow -> {
                    Toast.makeText(this, R.string.slideshow_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(this, R.string.home_clicked, Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.profile -> {
                    Toast.makeText(this, R.string.profile_clicked, Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.settings -> {
                    Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }


        binding.floatingActionButton.setOnClickListener {
            // showCustomDialog()

            Snackbar.make(binding.coordinatorLayout, R.string.user_added, Snackbar.LENGTH_LONG)
                .setAction(R.string.dismiss) {
                    // Responds to click on the action
                }
                .show()

        }
    }


}