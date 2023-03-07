package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivities
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(val context: Context, val fruits:MutableList<Fruits>):RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tvName.text = fruits[position].name
        holder.itemView.tvPlace.text = fruits[position].place

        var color = "#ADD8E6"

        if(position%2 == 0)
            color = "#CBC3E3"

        holder.itemView.itemView.setBackgroundColor(Color.parseColor(color))
        holder.itemView.share.setOnClickListener {
            val sendintent = Intent(Intent.ACTION_SEND)
            sendintent.type = "text/plain"
            sendintent.putExtra(Intent.EXTRA_TEXT,"Name: " + holder.itemView.tvName.text.toString() + "\n" + "Place: " + holder.itemView.tvPlace.text.toString())

            val chooser = Intent.createChooser(sendintent,"Share this Info with")

            if(sendintent.resolveActivity(context.packageManager) != null)
                context.startActivity(chooser)
            else
                Toast.makeText(context,"No App Installed on Device to Share this Info",Toast.LENGTH_SHORT).show()

        }

        holder.itemView.itemView.setOnClickListener {
            Toast.makeText(context,"${it.tvName.text} from ${it.tvPlace.text}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    class MyViewHolder(item_view: View): RecyclerView.ViewHolder(item_view)
    {
    }

}


