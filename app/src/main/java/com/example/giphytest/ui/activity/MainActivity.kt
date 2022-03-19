package com.example.giphytest.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.GiphyModel
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.ActivityMainBinding
import com.example.giphytest.viewmodel.GiphyViewModel


class MainActivity : AppCompatActivity() {

    private val giphyViewModel by viewModels<GiphyViewModel>()


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()

        Log.e(" MainAct",GiphyViewModel().items.toString())
        Log.e(" MainAct2",GiphyModel.toString())

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




