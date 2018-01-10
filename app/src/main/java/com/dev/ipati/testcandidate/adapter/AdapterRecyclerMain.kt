package com.dev.ipati.testcandidate.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.ipati.testcandidate.R
import kotlinx.android.synthetic.main.item_list_main.view.*


class AdapterRecyclerMain : RecyclerView.Adapter<AdapterRecyclerMain.ViewHolder>() {
    private var listItem: List<String> = listOf("Permission", "Dropdown", "TreeView", "Camera")
    var clickListener: ((position: Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_list_main, parent, false))
    }

    override fun getItemCount(): Int {
        return listItem.count()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBind()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(p0: View?) {
            clickListener?.invoke(adapterPosition)
        }

        fun onBind() {
            itemView.list_item_tv_menu.text = listItem[adapterPosition]
            itemView.list_item_tv_menu.setOnClickListener(this)
        }
    }
}