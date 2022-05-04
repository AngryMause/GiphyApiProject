package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.R
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.FragmentMainBinding
import com.example.giphytest.viewmodel.GiphyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GiphyListFragment : BaseFragment() {
    @Inject
    lateinit var myAdapter: MyAdapter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    //    private val viewModel by viewModels<GiphyViewModel>()
    private lateinit var giphyViewModel: GiphyViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        giphyViewModel = ViewModelProvider(requireActivity()).get(GiphyViewModel::class.java)
        initAdapter()
        subscribeToObserver()
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
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun subscribeToObserver() {
        giphyViewModel.items.observe(viewLifecycleOwner) { data ->
            myAdapter.addItems(data)
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


