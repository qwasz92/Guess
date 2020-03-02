package com.example.guess

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guess.data.Record
import kotlinx.android.synthetic.main.row_record.view.*

class RecordAdapter (var records:List<Record>):RecyclerView.Adapter<RecordViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_record,parent,false))
    }

    override fun getItemCount(): Int {
    return records.size
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.nicknameText.text = records.get(position).nickname
        holder.counterText.text = records.get(position).counter.toString()
    }

}
class RecordViewHolder(view: View):RecyclerView.ViewHolder(view){
    var nicknameText = view.record_nickname
    var counterText = view.record_counter
}