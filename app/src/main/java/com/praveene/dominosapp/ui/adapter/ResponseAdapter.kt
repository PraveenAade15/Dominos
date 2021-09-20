package com.praveene.dominosapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.praveene.dominosapp.R
import com.praveene.dominosapp.data.model.ResponseItem

class ResponseAdapter(
    private var responseList: MutableList<ResponseItem>,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.response_item_layout, parent, false)

        return ResponseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {

        val response = responseList[position]



        holder.apply {
            // Glide.with(responseImage).load(response.image).into(responseImage)

            responseTitle.text = response.crusts.toString()
            responseSubtitle.text = response.description


            responseItem.setOnClickListener {
                listener.onItemClicked(response)
            }
        }
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    fun setData(newData: MutableList<ResponseItem>) {
        responseList = newData
        notifyDataSetChanged()
    }


    fun filterList(filteredList: MutableList<ResponseItem>) {
        responseList = filteredList
        notifyDataSetChanged()
    }


    class ResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val responseImage: ImageView = itemView.findViewById(R.id.responseImage)
        val responseTitle: TextView = itemView.findViewById(R.id.responseTitle)
        val responseSubtitle: TextView = itemView.findViewById(R.id.responseSubtitle)
        val responseItem: ConstraintLayout = itemView.findViewById(R.id.responseItem)
    }
}