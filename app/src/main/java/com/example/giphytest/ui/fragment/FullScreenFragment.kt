package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.giphytest.databinding.FragmentFullScreenBinding


class FullScreenFragment : BaseFragment() {


    companion object {
        fun getNewInstance(arg: Bundle?): FullScreenFragment {
            val fullScreenFragment = FullScreenFragment()
            fullScreenFragment.arguments = arg
            return fullScreenFragment
        }
    }
     var _binding: FragmentFullScreenBinding? = null
     val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Tag2", " My arguments ${arguments.toString()}")
        val mytext = arguments?.getSerializable("list")
        if (mytext == null) {
            Toast.makeText(requireContext(), "arg == Null ", Toast.LENGTH_SHORT).show()
        } else {
            binding.fullIm.setImageResource(mytext as Int)
            binding.textView.text= mytext.toString()
        }
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


