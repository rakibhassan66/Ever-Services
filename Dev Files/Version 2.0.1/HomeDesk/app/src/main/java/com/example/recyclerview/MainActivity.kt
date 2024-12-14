package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter
    lateinit var datalist: ArrayList<ModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove default title and set custom Action Bar
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false) // Disable default title
            setDisplayShowCustomEnabled(true) // Enable custom view
            setCustomView(R.layout.action_bar_layout) // Set your custom layout
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        datalist = ArrayList()
        datalist.add(ModelClass(R.drawable.edu, "Educational Services"))
        datalist.add(ModelClass(R.drawable.pt, "Public Transport"))
        datalist.add(ModelClass(R.drawable.admin, "Public Administration"))
        datalist.add(ModelClass(R.drawable.defence, "Defence Services"))
        datalist.add(ModelClass(R.drawable.health, "Health Services"))
        datalist.add(ModelClass(R.drawable.judicial, "Judicial Services"))
        datalist.add(ModelClass(R.drawable.sw, "Social Welfare"))
        datalist.add(ModelClass(R.drawable.tax, "TAX Services"))

        itemAdapter = ItemAdapter(datalist, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter
    }
}
