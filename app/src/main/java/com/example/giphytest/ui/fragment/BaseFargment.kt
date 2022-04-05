package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.giphytest.databinding.FragmentMainBinding
import com.example.giphytest.viewmodel.GiphyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    @Inject
    lateinit var glide: RequestManager
    protected lateinit var giphyViewModel: GiphyViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        giphyViewModel = ViewModelProvider(requireActivity()).get(GiphyViewModel::class.java)
    }


}