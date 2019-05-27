package com.learn.vidio.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.vidio.Model.Video
import com.learn.vidio.R

class DetailCourseAdapter: RecyclerView.Adapter<DetailCourseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.course_detail_row, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(parent: ViewHolder, p1: Int) {

    }


    inner class ViewHolder(itemView: View, video: Video? = null): RecyclerView.ViewHolder(itemView){

    }


}