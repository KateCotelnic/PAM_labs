package com.example.myapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val  database = Database("database")
        val arrayList = database.get()
        val myAdapter = MyAdapterMy(arrayList, this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter

        binding.allRecipes.setOnClickListener {
            val newIntent = Intent(this, SecondActivity::class.java)
            startActivity(newIntent)
        }

        binding.add.setOnClickListener {
            val newIntent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(newIntent, 0)
        }
    }
}