package com.learn.vidio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.GsonBuilder
import com.learn.vidio.Model.HomeFeed
import com.learn.vidio.Model.Video
import com.learn.vidio.Adapters.MainAdapter
import com.learn.vidio.Utilities.URL_HOME_FEED
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter
    var videos = ArrayList<Video>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycleView()
    }

    fun setupRecycleView() {
        val url = URL_HOME_FEED
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                mainAdapter = MainAdapter(homeFeed)
                runOnUiThread {
                    recycler_main.adapter = mainAdapter
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("Error", "Cannot do a request")
            }
        })
        recycler_main.layoutManager = LinearLayoutManager(this)
    }
}