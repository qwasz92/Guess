package com.example.guess

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.guess.data.GameDatabase
import com.example.guess.data.Record
import kotlinx.android.synthetic.main.activity_record2.*
import kotlinx.android.synthetic.main.content_material.*
import kotlinx.android.synthetic.main.content_material.tv_counter

class Record2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record2)
        val count = intent.getIntExtra("COUNTER",-1)
        tv_counter.setText(count.toString())

        //OnClickListener
        bt_save.setOnClickListener { view ->
            val nick=ed_nickname.text.toString()
            getSharedPreferences("guess", Context.MODE_PRIVATE)
                .edit()
                .putInt("REC_COUNTER",count)
                .putString("REC_NICKNAME",nick)
                .apply()
            //inesert to Room
            //Room test
            GameDatabase.getInstance(this)
            Thread(){GameDatabase.getInstance(this)?.recordDao()?.
                insert(Record(nick,count))
            }.start()

            val intent = Intent()
            intent.putExtra("NICK",nick)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
