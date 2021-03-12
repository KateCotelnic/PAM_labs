package com.example.myapp
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    companion object{
        const val USER = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  database = Database("database")
        val arrayList = database.get()
        val myAdapter = MyAdapterMy(arrayList, this)

        val  recyclerView: RecyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }

    fun my_recipes(view: View){

    }
    fun all_recipes(view: View){
        val newIntent = Intent(this, SecondActivity::class.java)
        startActivity(newIntent)
    }

    fun new_button(view: View){
        val newIntent = Intent(this, ThirdActivity::class.java)
        startActivityForResult(newIntent, USER)
    }
}
