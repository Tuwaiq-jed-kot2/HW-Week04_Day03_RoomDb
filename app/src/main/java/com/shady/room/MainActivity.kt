package com.shady.room

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.math.log
const val EXTRA_CODE = 1
private lateinit var wordsReyclerView: RecyclerView
@SuppressLint("StaticFieldLeak")
private lateinit var addWord:ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val contactList = mutableListOf<Word>()
        for (i in 0 until 50){
            val contact =Word(UUID.randomUUID(),"Eman $i")
            contactList.add(contact)
        }

        addWord = findViewById(R.id.addWordImg)
        addWord.setOnClickListener {
            val intent = Intent(this,addWordActivity::class.java)
            startActivity(intent)

        }




        wordsReyclerView = findViewById(R.id.recyclerViewId)

        val linearLayoutManger = LinearLayoutManager(this)
        wordsReyclerView.layoutManager = linearLayoutManger

        val adapter = RycAdapter(contactList)
        wordsReyclerView.adapter = adapter
    }
}