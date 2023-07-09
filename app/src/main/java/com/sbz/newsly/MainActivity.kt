package com.sbz.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sbz.newsly.adapters.NewsAdapter
import com.sbz.newsly.databinding.ActivityMainBinding
import com.sbz.newsly.model.NewsModel
import com.sbz.newsly.services.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView(this@MainActivity, R.layout.activity_main)

        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("in", 1)
        news.enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                val news: NewsModel? = response.body()
                if (news != null) {
                    Log.d("SHABAJ", news.articles.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    binding.rvNewsList.adapter = adapter
                    binding.rvNewsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
//                t.printStackTrace()
                Log.d("RESPONSE_ERROR", t.message.toString())
            }

        })
    }
}