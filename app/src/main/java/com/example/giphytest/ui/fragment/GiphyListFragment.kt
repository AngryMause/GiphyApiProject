package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.R
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.FragmentGiphyListBinding
import com.example.giphytest.utill.launchWhenStarted
import com.example.giphytest.viewmodel.GyphyiViewModelWithFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class GiphyListFragment :
    BaseFragment<FragmentGiphyListBinding>(FragmentGiphyListBinding::inflate) {
    @Inject
    lateinit var myAdapter: MyAdapter
    private val giphyViewModelWithFlow: GyphyiViewModelWithFlow by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        myAdapter.setOnItemClickListener { giphy ->
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.my_container, FullScreenFragment.getNewInstance(giphy))
                addToBackStack(null)
            }
                ?.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giphyViewModelWithFlow.items.onEach { giphyList ->
            myAdapter.addItems(giphyList)
        }.launchWhenStarted(lifecycleScope)
    }

    private fun initAdapter() = binding.myRv.apply {
        adapter = myAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
    }


}


