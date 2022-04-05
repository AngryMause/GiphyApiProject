package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.giphytest.model.ImageModel

import com.example.giphytest.databinding.FragmentFullScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myModel: ImageModel = arguments?.getParcelable("imageUrl")!!
        glide.load(myModel.url).into(binding.fullIm)
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


