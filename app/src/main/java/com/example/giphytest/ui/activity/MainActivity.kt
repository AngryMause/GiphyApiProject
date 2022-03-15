package com.example.giphytest.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giphytest.MyModel
import com.example.giphytest.R
import com.example.giphytest.RestClient
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.ActivityMainBinding
import com.example.giphytest.ui.fragment.FullScreenFragment
import com.example.giphytest.ui.fragment.MainFragment
import com.giphy.sdk.ui.Giphy
import com.giphy.sdk.ui.views.GiphyDialogFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainFragment: MainFragment

    //    private lateinit var adapter: MyAdapter
    private lateinit var fullScreenFragment: FullScreenFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(binding.myContainer.id, mainFragment)
            .commit()
//        supportFragmentManager.beginTransaction().addToBackStack(mainFragment.tag)

//        val dialog = GiphyDialogFragment.newInstance(settings.copy(selectedContentType = contentType), YOUR_ANDROID_SDK_KEY)
//        Giphy.configure(this, RestClient.API_KEY)
//        GiphyDialogFragment.newInstance().show(supportFragmentManager, "giphy_dialog")


//        adapter.setOnItemClickListener { click ->
////            Toast.makeText(this, "position ${click.text}",Toast.LENGTH_SHORT).show()
//
//            supportFragmentManager.beginTransaction()
//                .replace(binding.myContainer.id, fullScreenFragment)
//                .commit()
////            bundle.putSerializable("myText", imageList)
//        }

    }


    override fun onDestroy() {
        super.onDestroy()

    }
}



