package com.ltts.ecommerce

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(val context: Activity,val datalist:List<MyDataItem>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.my_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentInfo = datalist[position]

        holder.productName.text = currentInfo.title
        Picasso.get().load(currentInfo.image).into(holder.productImage)
        holder.productPrice.text = currentInfo.price.toString()



    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       val productImage : ImageView
       val productName : TextView
       val productPrice: TextView


        init {
            productName = itemView.findViewById(R.id.productTitle)
            productImage = itemView.findViewById(R.id.productImage)
            productPrice = itemView.findViewById(R.id.productPrice)
        }


    }
}