package com.shady.room

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import java.util.*

//val WordListViewModel by lazy { ViewModelProvider(this).get(WordListViewModel::class.java) }

@SuppressLint("StaticFieldLeak")
private lateinit var addWordText: EditText
@SuppressLint("StaticFieldLeak")
private lateinit var saveBtn: Button

class addWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        addWordText = findViewById(R.id.enterText)
        saveBtn = findViewById(R.id.savebtn)
        // Get the Intent that started this activity and extract the string
         intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
//        val addWordText = addWordText.apply {
//            text = message
//        }



    }

//    override fun onStart() {
//        super.onStart()
//
//        val textWatcher = object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                // i will do nothing
//            }
//
//            override fun onTextChanged(sen: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Word(UUID.randomUUID(), sen as String)
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                // i will do nothing
//            }
//
//        }

 //   }
}