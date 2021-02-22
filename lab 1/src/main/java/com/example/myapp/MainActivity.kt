package com.example.myapp
//import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object{
        const val USER = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun change(view: View){
        val myToast = Toast.makeText(this, "changed!", Toast.LENGTH_SHORT)
        val textView: TextView = findViewById(R.id.textView) as TextView
        val string = textView.text.toString().substringBefore(" ") + " Marry!"
//        println("string = " + string)
        textView.setText(string)
        myToast.show()
    }

    fun send(view: View){
//        val myToast = Toast.makeText(this, "sent!", Toast.LENGTH_SHORT)
//        myToast.show();
        val textView: TextView = findViewById(R.id.textView) as TextView
        val string = textView.text.toString()
        val newIntent = Intent(this, SecondActivity::class.java)
        newIntent.putExtra(SecondActivity.GOT_DATA, string)
//        startActivity(newIntent)
        startActivityForResult(newIntent, USER)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val textView = findViewById<View>(R.id.textView) as TextView
        if (requestCode == USER) {
            if (resultCode == Activity.RESULT_OK) {
                val string = data?.getStringExtra(SecondActivity.USER)
                println(string)
                textView.text = string
            } else {
                textView.text = ""
            }
        }
    }
}