package com.learn.vidio.Adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.vidio.Model.HomeFeed
import com.learn.vidio.Model.Video
import com.learn.vidio.R
import com.learn.vidio.Views.DetailCourseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return  ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.bindView(video)
        holder.video = video
    }

    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }


    inner class ViewHolder(itemView: View, var video: Video? = null): RecyclerView.ViewHolder(itemView) {

        val thumbnailVideoImageView = itemView.thumbnailImageView
        val channelProfileImageImageView = itemView.channelProfileImageView
        val titleTextView = itemView.videoTitleTextView
        val channelNameTextView = itemView.channelNameTextView

        fun bindView(video: Video) {
            Picasso.get()
                .load(video.imageUrl)
                .into(thumbnailVideoImageView)

            Picasso.get()
                .load(video.channel.profileImageUrl)
                .into(channelProfileImageImageView)

            titleTextView.text = video.name
            channelNameTextView.text = "${video.channel.name} • 20K Views \n4 days ago"
        }

        init {
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                intent.putExtra(DetailCourseActivity.VIDEO_TITLE_KEY, video?.name)
                intent.putExtra(DetailCourseActivity.VIDEO_ID_KEY, video?.id)
                itemView.context.startActivity(intent)
            }
        }
    }

}