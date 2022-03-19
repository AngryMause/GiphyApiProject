package com.example.giphytest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphytest.GiphyApiImp
import com.example.giphytest.Data
import kotlinx.coroutines.launch

class GiphyViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Data>>()
    val items: LiveData<List<Data>> get() = _items

    init {
        viewModelScope.launch {
            _items.value=GiphyApiImp.getListOfGif()
        }
    }

} 