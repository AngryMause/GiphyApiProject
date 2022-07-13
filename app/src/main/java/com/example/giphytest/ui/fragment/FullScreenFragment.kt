package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.ViewCompat
import com.example.giphytest.databinding.FragmentFullScreenBinding
import com.example.giphytest.model.ImageModel
import com.example.giphytest.utill.Const.GIPHY_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FullScreenFragment :
    BaseFragment<FragmentFullScreenBinding>(FragmentFullScreenBinding::inflate) {
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
        glide.load(myModel.imageURL).into(binding.fullIm)
        onBack()
    }

    private fun onBack() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    replaceFragment(GiphyListFragment.getNewInstance())
                }
            })
    }
}


