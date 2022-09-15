package com.example.room_test

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class MyAdapter constructor(input_data : List<RoomEntity>) : RecyclerView.Adapter<MyViewHolder>() {
     var data :List<RoomEntity> = input_data

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.e("onCreateViewHolder",data.size.toString())

        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.xml.item_myholder,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.setData(data[position].id,data[position].name)

    }

}