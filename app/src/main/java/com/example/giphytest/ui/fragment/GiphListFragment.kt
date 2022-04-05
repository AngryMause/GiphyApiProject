package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytest.R
import com.example.giphytest.adapter.MyAdapter
import com.example.giphytest.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GiphListFragment : BaseFragment() {
    @Inject
    lateinit var adapter: MyAdapter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun getNewInstance(str: String): GiphListFragment {
            val mainFragment = GiphListFragment()
            val arg = Bundle()
            arg.putString("key", str)
            mainFragment.arguments = arg
            return mainFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        subscribeToObserver()
        adapter.setOnItemClickListener { giph ->
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.my_container, FullScreenFragment.getNewInstance(giph))
                addToBackStack(null)
            }

            ?.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
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
            adapter.addItems(data)
        }
    }

    private fun initAdapter() = binding.myRv.apply {
        binding.myRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.myRv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


