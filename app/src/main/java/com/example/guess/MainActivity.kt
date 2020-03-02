package com.example.guess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_function.view.*

class MainActivity : AppCompatActivity() {
    val TAG=MainActivity::class.java.simpleName

    val functions = listOf<String>(
        "Camera",
        "Guess game",
        "Record list",
        "Download coupons",
        "News",
        "Map")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RecyclerView
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = FunctionAdapter()
    }
    inner class FunctionAdapter():RecyclerView.Adapter<FunctionHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_function,parent,false)
          val holder = FunctionHolder(view)
            return holder
           }
        override fun getItemCount(): Int {
        return functions.size
        }
        override fun onBindViewHolder(holder: FunctionHolder, position: Int) {
            holder.tv_name.text = functions.get(position)
            holder.itemView.setOnClickListener {
                funtionClicked(position)
            }
        }
    }

    private fun funtionClicked(position: Int) {
            when(position){
                1 -> startActivity(Intent(this,MaterialActivity::class.java))
                2 -> startActivity(Intent(this,RecordListActivity::class.java))
                else -> return
            }
    }

    class FunctionHolder(view: View):RecyclerView.ViewHolder(view){
        var tv_name:TextView = view.tv_name
    }
}
