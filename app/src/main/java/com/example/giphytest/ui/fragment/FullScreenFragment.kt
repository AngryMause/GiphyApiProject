package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.giphytest.MyModel
import com.example.giphytest.R
import com.example.giphytest.databinding.FragmentFullScreenBinding
class FullScreenFragment : BaseFragment() {


    companion object {
        fun getNewInstance(arg: MyModel?): FullScreenFragment {
            val fullScreenFragment = FullScreenFragment()
            val bundle=Bundle()
            bundle.putParcelable("list",arg)
            fullScreenFragment.arguments = bundle
            return fullScreenFragment
        }
    }

     var _binding: FragmentFullScreenBinding? = null
     val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image:MyModel=arguments?.getParcelable("list")!!
//        image.image.let { binding.fullIm.setImageResource(it) }
        binding.fullIm.setImageResource(image.image)
    }

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



