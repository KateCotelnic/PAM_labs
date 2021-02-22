package com.example.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    companion object{
        const val GOT_DATA = "got_data"
        const val USER = "Marry"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showGotText()
    }

    fun showGotText() {
        val text = intent.getStringExtra(GOT_DATA)
        val textView: TextView = findViewById(R.id.textView) as TextView
        textView.setText(text)
    }

    fun change(view: View){
        val myToast = Toast.makeText(this, "changed!", Toast.LENGTH_SHORT)
        val textView: TextView = findViewById(R.id.textView) as TextView
        val string = textView.text.toString().substringBefore(" ") + " Tom!"
//        println("string = " + string)
        textView.setText(string)
        myToast.show()
    }

    fun send(view: View){
//        val myToast = Toast.makeText(this, "sent!", Toast.LENGTH_SHORT)
//        myToast.show();
        val textView: TextView = findViewById(R.id.textView) as TextView
        val string = textView.text.toString()
        println("str to send = " + string)
        val answerIntent = Intent(this, MainActivity::class.java)
        answerIntent.putExtra(USER, string)
        setResult(Activity.RESULT_OK, answerIntent)
        finish()
//        startActivity(newIntent)
    }
}