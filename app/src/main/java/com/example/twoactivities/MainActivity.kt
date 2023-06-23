package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val LOG_TAG: String = MainActivity::class.java.simpleName
    private lateinit var mMessage : EditText

    lateinit var launcher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessage = findViewById(R.id.editText_main)

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


//        val intent = intent


//        val textReply = intent.getStringExtra("reply")

//        reply.text = textReply


        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val replyMessage = data?.getStringExtra("reply")
                // Use the reply message as needed
                val reply = findViewById<TextView>(R.id.reply_main)

                reply.text = replyMessage

            }
        }


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

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button Clicked!")

        val text = mMessage.text.toString()
        val intent = Intent(this, SecondActivity::class.java )
        intent.putExtra("msg", text)
//        startActivity(intent)

//        val requestCode = 123
//        startActivityForResult(intent, requestCode)



        launcher.launch(intent)


    }
}