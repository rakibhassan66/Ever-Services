package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter
    lateinit var datalist: ArrayList<ModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the custom Action Bar layout
        supportActionBar?.let {
            it.setDisplayShowCustomEnabled(true)
            it.setCustomView(R.layout.action_bar_layout)
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