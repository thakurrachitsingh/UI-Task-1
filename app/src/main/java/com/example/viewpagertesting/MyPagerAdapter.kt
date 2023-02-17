package com.example.viewpagertesting

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyPagerAdapter(val list: List<Int>, val context: Context): RecyclerView.Adapter<MyPagerAdapter.ViewHolder>(){
    var screenWidth = 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pagger_adapter_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //getting screen width of user's phone
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.getDefaultDisplay().getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels


        //giving dynamic width to the images in recyclerView
        var newItemWidth = screenWidth/1.7
        val lp = holder.imageView.layoutParams
        lp.width = newItemWidth.toInt()
        holder.imageView.layoutParams = lp


        //setting image to the ImageView of holder
        val crrItem = list[position]
        Glide.with(context)
            .load(crrItem)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}