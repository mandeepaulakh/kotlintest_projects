package com.dupleit.demo.kotlintest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by mandeep on 8/11/17.
 */
class recyclerAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<recyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val user:User = userList[position]
        holder?.tvName?.text =user.name
        holder?.tvAddress?.text = user.address
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.textViewUsername
        val tvAddress = itemView.textViewAddress

    }

}