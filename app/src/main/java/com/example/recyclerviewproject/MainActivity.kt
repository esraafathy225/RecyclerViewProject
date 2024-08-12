package com.example.recyclerviewproject

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
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
import java.util.Locale
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
            User("Group1","",1),
            User("Ahmed Mohamed","Ahmed@gmail.com",2),
            User("Mahmoud Mohamed","Mahmoud@gmail.com",2),
            User("Mona Ahmed","Mona@gmail.com",2),
            User("Group2","",1),
            User("Menna Ali","Menna@gmail.com",2),
            User("Youssef Mohamed","Youssef@gmail.com",2),
            User("Ahmed Mohamed","Ahmed@gmail.com",2),
            User("Group3","",1),
            User("Mahmoud Ahmed","Mahmoud@gmail.com",2),
            User("Yasmine Ahmed","Mona@gmail.com",2),
            User("Mohamed Ali","Menna@gmail.com",2),
            User("Farida Mohamed","Youssef@gmail.com",2)
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
                R.id.change_language -> {
                    updateLocale(this,"ar")
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

            Snackbar.make(binding.coordinatorLayout, R.string.user_added, Snackbar.LENGTH_LONG)
                .setAction(R.string.dismiss) {
                    // Responds to click on the action
                }
                .show()

        }
    }


    fun updateLocale(context: Context, languageCode: String) {

        // locale  ar  direction

        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
            context.createConfigurationContext(config)
        } else {
            config.locale = locale
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }

        // Update layout direction
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale)
        }

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        //restart activity

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}