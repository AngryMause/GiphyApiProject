package com.example.giphytest.ui.activity

import android.app.VoiceInteractor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.giphytest.databinding.ActivityMainBinding
import com.example.giphytest.ui.fragment.GiphListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var glide:RequestManager

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




