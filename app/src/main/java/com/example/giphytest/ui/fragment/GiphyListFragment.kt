package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.R
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.FragmentMainBinding
import com.example.giphytest.viewmodel.GiphyViewModelWithLiveData
import com.example.giphytest.viewmodel.GyphViewModelWithFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class GiphyListFragment : BaseFragment() {
    @Inject
    lateinit var myAdapter: MyAdapter
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val giphyViewModelWithFlow: GyphViewModelWithFlow by viewModels()
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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            giphyViewModelWithFlow.items.onEach { giphyList ->
                myAdapter.addItems(giphyList)
            }.collect()
        }
    }

    private fun initAdapter() = _binding?.myRv?.apply {
        adapter = myAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


