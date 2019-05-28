package com.learn.vidio.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.learn.vidio.R
import kotlinx.android.synthetic.main.activity_course_lesson.*

class CourseLessonActivity : AppCompatActivity() {

    companion object {
        val COURSE_URL_KEY = "CourseUrlKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)
        getUrl()
    }

    fun getUrl() {
        val url = intent.getStringExtra(COURSE_URL_KEY)
        webview_course_lesson.settings.javaScriptEnabled = true
        webview_course_lesson.settings.loadWithOverviewMode = true
        webview_course_lesson.settings.useWideViewPort = true
        webview_course_lesson.loadUrl(url)
    }
}
