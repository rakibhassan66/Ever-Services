package com.example.recyclerview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ItemAdapter(val datalist: ArrayList<ModelClass>, val context: Context): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image:ImageView = view.findViewById(R.id.image)
        val name:TextView = view.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_files, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = datalist[position]

        holder.image.setImageResource(module.image)
        holder.name.text = module.name
    }
}