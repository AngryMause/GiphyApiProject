package com.example.giphytest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphytest.GiphyModel
import com.example.giphytest.GiphyApiImp
import kotlinx.coroutines.launch

class GiphyViewModel : ViewModel() {
    private val _items = MutableLiveData<List<GiphyModel>>()
    val items: LiveData<List<GiphyModel>> get() = _items



    init {
        viewModelScope.launch {
            _items.value=GiphyApiImp.getListOfGif()
        }
    }
}