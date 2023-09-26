package com.donmykl.unisearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.donmykl.unisearch.R
import com.donmykl.unisearch.model.University

class UniversityAdapter(private val unis: List<University>) :
    RecyclerView.Adapter<UniversityAdapter.UniversityViewholder>() {

    inner class UniversityViewholder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(university: University) {
            val uniName: TextView = itemView.findViewById(R.id.tvUniName)
            val uniCountry: TextView = itemView.findViewById(R.id.tvUniCountry)
            val uniWebsite: TextView = itemView.findViewById(R.id.tvUniWebsite)

            uniName.text= university.name
            uniCountry.text=university.country
            uniWebsite.text=university.website.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_uni_list, parent, false)
        return UniversityViewholder(view)
    }

    override fun onBindViewHolder(holder: UniversityViewholder, position: Int) {
        holder.bind(unis[position])
    }

    override fun getItemCount(): Int {
        return unis.size
    }

}