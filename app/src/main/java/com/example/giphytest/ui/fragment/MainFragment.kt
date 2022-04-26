package com.example.giphytest.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.BundleCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.MyModel
import com.example.giphytest.R
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.FragmentMainBinding

class MainFragment : BaseFragment() {
    protected lateinit var myBundle: Bundle

    private lateinit var adapter: MyAdapter
    private lateinit var imageList: ArrayList<MyModel>
    private lateinit var fullScreenFragment: FullScreenFragment
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageList = ArrayList()
        initAdapter()
        addImageToList()
        adapter.setOnItemClickListener { myModel ->
            activity?.apply {
                supportFragmentManager
                    .beginTransaction().replace(
                        R.id.my_container, FullScreenFragment.getNewInstance(myModel)
                    )
                    .addToBackStack(null)
                    .commit()
            }


        }
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


    private fun initAdapter() {
        adapter = MyAdapter(imageList, requireContext())
        binding.myRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.myRv.adapter = adapter

    }

    private fun addImageToList() {
        imageList.add(MyModel(R.drawable.ic_tatto))
        imageList.add(MyModel(R.drawable.ic_tatto2))
        imageList.add(MyModel(R.drawable.ic_tatto3))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


