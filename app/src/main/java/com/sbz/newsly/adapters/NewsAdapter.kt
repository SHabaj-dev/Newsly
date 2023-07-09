package com.sbz.newsly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import com.sbz.newsly.R
import com.sbz.newsly.model.ArticleModel

class NewsAdapter(val context: Context, val articlesList: List<ArticleModel>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCoverImage = itemView.findViewById<ShapeableImageView>(R.id.iv_listImage)
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_newsTitle)
        val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNews = articlesList[position]
        holder.tvTitle.text = currentNews.title
        holder.tvDescription.text = currentNews.description
        Glide
            .with(context)
            .load(currentNews.urlToImage)
            .error(R.drawable.broken_image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.ivCoverImage)
    }
}