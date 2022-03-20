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
import com.example.giphytest.ui.fragment.GiphListFragment
import com.example.giphytest.viewmodel.GiphyViewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var giphListFragment: GiphListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        giphListFragment = GiphListFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(binding.myContainer.id, giphListFragment)
        }.commit()


    }
}




