package com.example.giphytest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.RequestManager
import com.example.giphytest.R
import javax.inject.Inject

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment() {
    @Inject
    lateinit var glide: RequestManager
    private lateinit var transaction: FragmentTransaction
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.setCustomAnimations(
            android.R.anim.fade_in, android.R.anim.fade_out
        )
        return binding.root
    }

    protected fun replaceFragment(fragment: Fragment) {
        transaction.apply {
            replace(
                R.id.my_container, fragment,
            )
                .addToBackStack(null)
        }
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

