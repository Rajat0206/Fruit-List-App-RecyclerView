package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.item_view.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fruitsList = mutableListOf<Fruits>()
        fruitsList.add(Fruits("Apple","Kashmir"))
        fruitsList.add(Fruits("Banana","Lucknow"))
        fruitsList.add(Fruits("Orange","Nagpur"))
        fruitsList.add(Fruits("Kiwi","Srinagar"))
        fruitsList.add(Fruits("Lichi","Delhi"))
        fruitsList.add(Fruits("Grapes","Punjab"))
        fruitsList.add(Fruits("Guava","Haryana"))
        fruitsList.add(Fruits("Pineapple","Patna"))
        fruitsList.add(Fruits("Strawberry","Mysore"))
        fruitsList.add(Fruits("Mango","Maharashtra"))
        fruitsList.add(Fruits("Apple","Gujrat"))
        fruitsList.add(Fruits("Banana","Tamil Nadu"))
        fruitsList.add(Fruits("Lichi","Goa"))
        fruitsList.add(Fruits("Guava","Delhi"))
        fruitsList.add(Fruits("Pineapple","Kashmir"))

        recyclerView.layoutManager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        recyclerView.adapter = MyAdapter(this,fruitsList)
    }
}