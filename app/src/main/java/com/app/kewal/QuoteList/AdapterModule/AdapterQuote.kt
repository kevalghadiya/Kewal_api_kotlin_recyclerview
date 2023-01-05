package com.app.kewal.QuoteList.AdapterModule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.app.kewal.QuoteList.ModelModule.QuoteList
import com.app.kewal.QuoteList.ModelModule.ResultsItem
import com.app.kewal.R

class AdapterQuote(private val mList: ArrayList<ResultsItem>) :RecyclerView.Adapter<AdapterQuote.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.quote_adapter,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.tvAuthor.text = item.author
        holder.tvContent.text = item.content
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView:View) :RecyclerView.ViewHolder(ItemView) {
        val tvAuthor :TextView = itemView.findViewById(R.id.tvAuthor)
        val tvContent :TextView = itemView.findViewById(R.id.tvContent)
    }

}