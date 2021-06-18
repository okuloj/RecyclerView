package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var list: ArrayList<String>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.recycler_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val string = list[position]
        holder.bind(string)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        var textView: TextView = itemView.findViewById(R.id.textView)
        fun bind(string: String) {
            var textView: TextView = itemView.findViewById(R.id.textView)
            textView.text = string

            textView.setOnClickListener {
                textView.text = "Clicked! ${textView.text}"
            }
        }
    }


}