package com.donmykl.unisearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.donmykl.unisearch.adapter.UniversityAdapter
import com.donmykl.unisearch.interfaces.ApiClient
import com.donmykl.unisearch.model.University
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , UniversityAdapter.UniversityListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UniversityAdapter
    var datalist = ArrayList<University>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list_item)
        recyclerView.adapter = UniversityAdapter(datalist,this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getUniData()
    }
    private fun getUniData(){
        val call: Call<List<University>> = ApiClient.getClient.getUniData()
        call.enqueue(object: Callback<List<University>>{

            override fun onResponse(
                call: Call<List<University>>?,
                response: Response<List<University>>?
            ) {
                datalist.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<University>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


    override fun onItemClick(websites: List<String>) {
        val intent = Intent(baseContext,WebViewActivity::class.java)
        intent.putExtra("url",websites[0])
        startActivity(intent)
    }
}