package com.shady.room

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.shady.room.Database.HomeRepostry
import com.shady.room.Database.HomeRoomDatabase

class NweApp : AppCompatActivity() {
    class homsApplication : Application() {

        val database by lazy { HomeRoomDatabase.getDatabase(this) }
        val repository by lazy { HomeRepostry(database.homeDao()) }


    }

        private lateinit var editWordView: EditText

        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_new_word)
            editWordView = findViewById(R.id.edit_word)

            val button = findViewById<Button>(R.id.button_save)
            button.setOnClickListener {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(editWordView.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val word = editWordView.text.toString()
                    replyIntent.putExtra(EXTRA_REPLY, word)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }
        }

        companion object {
            const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
        }

    }
