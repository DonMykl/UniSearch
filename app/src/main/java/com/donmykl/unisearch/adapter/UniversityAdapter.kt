package com.donmykl.unisearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.donmykl.unisearch.R
import com.donmykl.unisearch.model.University

class UniversityAdapter(
    var unis: List<University>
) : RecyclerView.Adapter<UniversityAdapter.UniversityViewholder>() {

    inner class UniversityViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uniName: TextView = itemView.findViewById(R.id.tvUniName)
        val uniLocation: TextView = itemView.findViewById(R.id.tvUniCountry)
        val uniWebsite: TextView = itemView.findViewById(R.id.tvUniWebsite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_uni_list, parent, false)
        return UniversityViewholder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewholder, position: Int) {
        holder.apply {
            uniName.text = unis[position].name
            uniLocation.text = unis[position].location
            uniWebsite.text = unis[position].website
        }
    }

    override fun getItemCount(): Int {
        return unis.size
    }
}