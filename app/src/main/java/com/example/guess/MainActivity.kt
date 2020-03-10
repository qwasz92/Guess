package com.example.guess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
//        spinner
        val colors = arrayOf("Red","Green","Blue")
        val adapter= ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colors)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter =adapter
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d(TAG, "onItemSelected: ${colors[position]} ");
            }

        }
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
