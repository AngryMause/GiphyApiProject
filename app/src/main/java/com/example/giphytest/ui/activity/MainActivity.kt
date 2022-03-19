package com.example.giphytest.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.ImageModel
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.ActivityMainBinding
import com.example.giphytest.viewmodel.GiphyViewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path



class MainActivity : AppCompatActivity() {

    private val giphyViewModel by viewModels<GiphyViewModel>()


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()



//        Log.d("REtrofit",service.toString())

        giphyViewModel.items.observe(this, Observer {
            it ?: return@Observer
            adapter.addItems(it)
        })
    }



    private fun initAdapter() {
        adapter = MyAdapter(this)
        binding.myRv.layoutManager = GridLayoutManager(this, 2)
        binding.myRv.adapter = adapter

    }
}




