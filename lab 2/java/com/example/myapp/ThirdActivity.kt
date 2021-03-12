package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.myapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var option: Spinner
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var options = arrayOf("main cource", "first course", "second course", "dessert", "drinks")
        var type = "main course"

        binding.include2.spOption.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, options)

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