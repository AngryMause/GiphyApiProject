package com.example.giphytest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestManager
import com.example.giphytest.databinding.ActivityMainBinding
import com.example.giphytest.ui.fragment.GiphyListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var glide: RequestManager

    private lateinit var binding: ActivityMainBinding
    private lateinit var giphyListFragment: GiphyListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        giphyListFragment = GiphyListFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(binding.myContainer.id, giphyListFragment)
        }.commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null!!

    }


}






