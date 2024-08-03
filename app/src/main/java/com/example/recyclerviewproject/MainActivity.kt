package com.example.recyclerviewproject

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
class MainActivity : ComponentActivity() {

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
            User("Mahmoud Mohamed","Mahmoud@gmail.com"),
            User("Mona Ahmed","Mona@gmail.com"),
            User("Menna Ali","Menna@gmail.com"),
            User("Youssef Mohamed","Youssef@gmail.com")
        )

        val userAdapter = UserAdapter(users)
        binding.rvUsers.layoutManager= LinearLayoutManager(this)
        binding.rvUsers.adapter=userAdapter

    }
}