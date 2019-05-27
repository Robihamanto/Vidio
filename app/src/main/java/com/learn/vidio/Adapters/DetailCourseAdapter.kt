package com.learn.vidio.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.vidio.Model.Course
import com.learn.vidio.Model.Video
import com.learn.vidio.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_detail_row.view.*

class DetailCourseAdapter(val courses: Array<Course>): RecyclerView.Adapter<DetailCourseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.course_detail_row, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses.get(position)
        holder.bindView(course)
    }

    inner class ViewHolder(itemView: View, video: Video? = null): RecyclerView.ViewHolder(itemView){

        val imageCourseImageView = itemView.detailCourseImageView
        val titleCourseTextView = itemView.titleCourseTextView
        val episodeCourseTextView = itemView.episodeCourseTextView
        val videoLengthCourseTextView = itemView.videoLengthCourseTextView

        fun bindView(course: Course) {

            Picasso.get()
                .load(course.imageUrl)
                .into(imageCourseImageView)

            titleCourseTextView.text = course.name
            episodeCourseTextView.text = course.number.toString()
            videoLengthCourseTextView.text = course.duration
        }

    }

}