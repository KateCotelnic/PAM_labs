package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class ThirdActivity : AppCompatActivity() {
    lateinit var option: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        option = findViewById(R.id.sp_option) as Spinner

        var options = arrayOf("main cource", "first course", "second course", "dessert", "drinks")
        var type = "main course"

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, options)

        option.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                type = options.get(position)
            }
        }
    }

    fun save(view: View){
        val newIntent = Intent(this, MainActivity::class.java)
        startActivity(newIntent)
    }
}