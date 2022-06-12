package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.giphytest.databinding.FragmentFullScreenBinding
import com.example.giphytest.model.ImageModel
import com.example.giphytest.utill.Const.GIPHY_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullScreenFragment : BaseFragment<FragmentFullScreenBinding>(FragmentFullScreenBinding::inflate) {

    companion object {
        fun getNewInstance(str: ImageModel?): FullScreenFragment {
            val fullScreenFragment = FullScreenFragment()
            val bundle = Bundle()
            bundle.putParcelable(GIPHY_KEY, str)
            fullScreenFragment.arguments = bundle
            return fullScreenFragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myModel: ImageModel = arguments?.getParcelable(GIPHY_KEY)!!
        glide.load(myModel.url).into(binding.fullIm)
    }



}


