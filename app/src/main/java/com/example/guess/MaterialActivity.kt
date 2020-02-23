package com.example.guess

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    val secretNumber = SecretNumber()
    val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay game")
                .setMessage("Are you sure?")
                .setPositiveButton(getString(R.string.ok),{dialog, which ->
                    secretNumber.reset()
                    tv_counter.setText(secretNumber.count.toString())
                    ed_number.setText("")
                })
                .setNeutralButton("Cancel",null)
                .show()
        }
        tv_counter.setText(secretNumber.count.toString())
        Log.d(TAG, "onCreate:: "+secretNumber.secret);
    }
    fun check(view: View){
        var n = ed_number.text.toString().toInt()
        println("number${n}")
        Log.d(TAG,"number"+n)
        val diff = secretNumber.validate(n)
        var message = getString(R.string.yes_you_got_it)
        if (diff<0){
            message = getString(R.string.bigger)
        } else if (diff>0){
            message = getString(R.string.smaller)
        }
        tv_counter.setText(secretNumber.count.toString())
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        AlertDialog.Builder(this).
            setTitle(getString(R.string.message)).
            setMessage(message).
            setPositiveButton(getString(R.string.ok),{dialog, which ->
                if (diff == 0){
                    val intent= Intent(this,Record2Activity::class.java)
                    intent.putExtra("COUNTER",secretNumber.count)
                    startActivity(intent)
                }
            }).
            show()
    }


}
