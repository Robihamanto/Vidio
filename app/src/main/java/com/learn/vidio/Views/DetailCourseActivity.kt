package com.learn.vidio.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.learn.vidio.Adapters.DetailCourseAdapter
import com.learn.vidio.R
import kotlinx.android.synthetic.main.activity_course_detail.*

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        val VIDEO_TITLE_KEY = "DetailCourseActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)
        setupRecycleView()
        val navBarTitle = intent.getStringExtra(VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle
    }

    fun setupRecycleView() {
        detail_course_list.layoutManager = LinearLayoutManager(this)
        detail_course_list.adapter = DetailCourseAdapter()
    }
}
