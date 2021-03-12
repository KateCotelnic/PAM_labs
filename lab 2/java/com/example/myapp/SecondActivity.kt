package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    companion object{
        const val USER = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val  database = Database("database")
        val arrayList = database.get()

        val myAdapter = MyAdapterAll(arrayList, this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }

    fun my_recipes(view: View) {
        val newIntent = Intent(this, MainActivity::class.java)
        startActivity(newIntent)
    }

    fun all_recipes(view: View) {
    }

    fun new_button(view: View) {
        val newIntent = Intent(this, ThirdActivity::class.java)
        startActivityForResult(newIntent, USER)
    }
}
