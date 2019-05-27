package com.learn.vidio.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.GsonBuilder
import com.learn.vidio.Adapters.DetailCourseAdapter
import com.learn.vidio.Adapters.MainAdapter
import com.learn.vidio.Model.Course
import com.learn.vidio.Model.DetailCourses
import com.learn.vidio.Model.HomeFeed
import com.learn.vidio.R
import com.learn.vidio.Utilities.URL_COURSE_DETAIL
import com.learn.vidio.Utilities.URL_HOME_FEED
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        val VIDEO_TITLE_KEY = "VideoTitleKey"
        val VIDEO_ID_KEY = "VideoIdKey"
    }

    lateinit var detailCourseAdapter: DetailCourseAdapter
    var videoId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)
        setupRecycleView()
        setupNavTitle()
    }

    fun setupNavTitle() {
        val navBarTitle = intent.getStringExtra(VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle
    }

    fun setupRecycleView() {
        videoId = intent.getIntExtra(VIDEO_ID_KEY, -1)
        val url = "${URL_COURSE_DETAIL}?id=$videoId"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val courses = gson.fromJson(body, Array<Course>::class.java)

                detailCourseAdapter = DetailCourseAdapter(courses)
                runOnUiThread {
                    detail_course_list.adapter = detailCourseAdapter
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("Error", "Cannot do a request")
            }
        })

        detail_course_list.layoutManager = LinearLayoutManager(this)
    }
}
