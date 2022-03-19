package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.giphytest.ImageModel
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.FragmentMainBinding

class MainFragment : BaseFragment() {
//    private lateinit var adapter: MyAdapter
    private lateinit var imageList: ArrayList<ImageModel>

    //    private lateinit var  fragmentManager:FragmentManager
    private lateinit var fullScreenFragment: FullScreenFragment
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var MY_TAG = "MainFragment"


    companion object {
        fun getNewInstance(str: String): MainFragment {
            val mainFragment = MainFragment()
            val arg = Bundle()
            arg.putString("key", str)
            mainFragment.arguments = arg
            return mainFragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageList = ArrayList()
    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
//    private fun initAdapter() {
//        adapter = MyAdapter()
//        binding.myRv.layoutManager = GridLayoutManager(requireContext(), 2)
//        binding.myRv.adapter = adapter
//
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


