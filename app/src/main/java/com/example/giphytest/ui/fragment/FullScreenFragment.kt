package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.giphytest.ImageModel

import com.example.giphytest.databinding.FragmentFullScreenBinding


class FullScreenFragment : BaseFragment() {
    var _binding: FragmentFullScreenBinding? = null
    val binding get() = _binding!!

    companion object {
        fun getNewInstance(str: ImageModel?): FullScreenFragment {
            val fullScreenFragment = FullScreenFragment()
            val bundle = Bundle()
            bundle.putParcelable("imageUrl", str)
            fullScreenFragment.arguments = bundle
            return fullScreenFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myModel: ImageModel = arguments?.getParcelable("imageUrl")!!
        Glide.with(requireContext()).load(myModel.url).into(binding.fullIm)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFullScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}


