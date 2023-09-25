package com.donmykl.unisearch.universitylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.donmykl.unisearch.R
import com.donmykl.unisearch.adapter.UniversityAdapter

class UniversityListFragment : Fragment() {

    private lateinit var adapter: UniversityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_uni_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.list_item)
        recyclerView.setHasFixedSize(true)
        return view
    }


}