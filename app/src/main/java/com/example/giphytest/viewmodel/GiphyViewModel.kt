package com.example.giphytest.viewmodel

import androidx.lifecycle.*
import com.example.giphytest.MainRepository
import com.example.giphytest.model.ImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiphyViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel() {
    private val _items = MutableLiveData<List<ImageModel>>()
    val items: LiveData<List<ImageModel>> get() = _items

    init {
        viewModelScope.launch {
            _items.value=mainRepository.getListOfGif()

        }
    }

//    suspend fun getGiphyList (url:ImageModel): LiveData<List<ImageModel>>{
//        return liveData {
//            val data=api.getList()
//        }
//    }





}

