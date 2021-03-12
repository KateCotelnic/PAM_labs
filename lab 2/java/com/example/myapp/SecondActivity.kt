package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val  database = Database("database")
        val arrayList = database.get()

        val myAdapter = MyAdapterAll(arrayList, this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }

    fun my_recipes(view: View) {
        val newIntent = Intent(this, MainActivity::class.java)
        startActivity(newIntent)
    }

    fun all_recipes(view: View) {
    }

    fun new_button(view: View) {
        val newIntent = Intent(this, ThirdActivity::class.java)
        startActivityForResult(newIntent, 0)
    }
}