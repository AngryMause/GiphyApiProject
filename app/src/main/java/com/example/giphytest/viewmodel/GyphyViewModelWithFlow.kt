package com.example.giphytest.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphytest.MainRepository
import com.example.giphytest.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GyphyViewModelWithFlow @Inject constructor(val mainRepository: MainRepository) :
    ViewModel() {

    private val _items = MutableStateFlow(emptyList<ImageModel>())
    val items: StateFlow<List<ImageModel>> = _items

    init {
        viewModelScope.launch {
            _items.value = mainRepository.getListOfGif()
        }
    }


}