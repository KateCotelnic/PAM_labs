package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
//    companion object {
//        const val GOT_DATA = "got_data"
//        const val USER = "Marry"
//    }
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
//        newIntent.putExtra(SecondActivity.GOT_DATA, string)
        startActivityForResult(newIntent, USER)
    }
}
//        showGotText()
//    }
//
//    fun showGotText() {
//        val text = intent.getStringExtra(GOT_DATA)
//        val textView: TextView = findViewById(R.id.textView) as TextView
//        textView.setText(text)
//    }
//
//    fun change(view: View){
//        val myToast = Toast.makeText(this, "changed!", Toast.LENGTH_SHORT)
//        val textView: TextView = findViewById(R.id.textView) as TextView
//        val string = textView.text.toString().substringBefore(" ") + " Tom!"
////        println("string = " + string)
//        textView.setText(string)
//        myToast.show()
//    }
//
//    fun send(view: View){
////        val myToast = Toast.makeText(this, "sent!", Toast.LENGTH_SHORT)
////        myToast.show();
//        val textView: TextView = findViewById(R.id.textView) as TextView
//        val string = textView.text.toString()
//        println("str to send = " + string)
//        val answerIntent = Intent(this, MainActivity::class.java)
//        answerIntent.putExtra(USER, string)
//        setResult(Activity.RESULT_OK, answerIntent)
//        finish()
////        startActivity(newIntent)
//    }
//}