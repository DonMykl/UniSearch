package com.donmykl.unisearch.views


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.donmykl.unisearch.UpdateService
import com.donmykl.unisearch.adapter.UniversityAdapter
import com.donmykl.unisearch.databinding.ActivityMainBinding
import com.donmykl.unisearch.interfaces.ApiClient
import com.donmykl.unisearch.model.University
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), UniversityAdapter.UniversityListener {
    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding
    var datalist = ArrayList<University>()

    //TODO implement foreground service here
    fun launchService(context: Context) {
        val intent = Intent(this, UpdateService::class.java)
        context.startForegroundService(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.listItem
        recyclerView.adapter = UniversityAdapter(datalist, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getUniData()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getUniData() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = ApiClient.getClient.getUniData()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main){
                    datalist.addAll(response.body()!!)
                    recyclerView.adapter?.notifyDataSetChanged()
                }

            }
        }
    }

    override fun onItemClick(websites: List<String>) {
        val intent = Intent(baseContext, WebViewActivity::class.java)
        intent.putExtra("url", websites[0])
        startActivity(intent)
    }
}