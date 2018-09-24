package com.example.jaychen.fragmentlifecycle

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_text_view.view.*

class NumberAdapter(private val listener: View.OnClickListener) : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_text_view, parent, false)
        itemView.setOnClickListener(listener)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = position.toString()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.textView
    }
}