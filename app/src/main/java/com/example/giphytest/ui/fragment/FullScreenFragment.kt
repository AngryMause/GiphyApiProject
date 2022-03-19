package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.giphytest.ImageUrl

import com.example.giphytest.databinding.FragmentFullScreenBinding


class FullScreenFragment : BaseFragment() {
    var _binding: FragmentFullScreenBinding? = null
    val binding get() = _binding!!

    companion object {
        fun getNewInstance(str: String, arg: ImageUrl?): FullScreenFragment {
            val fullScreenFragment = FullScreenFragment()
            val bundle = Bundle()
            fullScreenFragment.arguments = bundle
            return fullScreenFragment
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myModel: ImageUrl = arguments?.getParcelable("list")!!
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val animation= TransitionInflater.from(requireContext()).inflateTransition(
//            android.R.transition.move
//        )
//        sharedElementEnterTransition=animation
//        sharedElementReturnTransition=animation
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFullScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}


