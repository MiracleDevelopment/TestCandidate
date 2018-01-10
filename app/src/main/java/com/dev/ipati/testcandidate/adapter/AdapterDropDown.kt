package com.dev.ipati.testcandidate.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.ipati.testcandidate.R
import kotlinx.android.synthetic.main.item_list_main.view.*


class AdapterDropDown : RecyclerView.Adapter<AdapterDropDown.ViewHolder>() {
    private val listItem: List<Int> = listOf(1, 2, 3, 4, 5)
    var onClickListener: ((position: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBind()
    }

    override fun getItemCount(): Int {
        return listItem.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_list_main, parent, false))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(p0: View?) {
            onClickListener?.invoke(adapterPosition)
        }

        fun onBind() {
            itemView.list_item_tv_menu.text = listItem[adapterPosition].toString()
            itemView.list_item_tv_menu.setOnClickListener(this)
        }
    }
}