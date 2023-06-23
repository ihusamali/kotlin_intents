package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val LOG_TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val intent = intent
        val message = intent.getStringExtra("msg")

        val textView = findViewById<TextView>(R.id.textMessage)

        textView.text = message



    }



    override fun onStart() {
        super.onStart()

        Log.d(LOG_TAG, "onStart");

    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause");

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart");

    }

    override fun onResume() {
        super.onResume()

        Log.d(LOG_TAG, "onResume");

    }

    override fun onStop() {
        super.onStop()

        Log.d(LOG_TAG, "onStop");

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy");

    }

    fun returnReply(view: View) {
        val reply = findViewById<EditText>(R.id.editText_second)
        val replyMsg = reply.text.toString()

//        val intent1 = Intent(this, MainActivity::class.java)
//        intent1.putExtra("reply", replyMsg)
//
//        startActivity(intent1)

        val replyIntent = Intent()
        replyIntent.putExtra("reply", replyMsg)
        setResult(Activity.RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity");

        finish()
    }
}