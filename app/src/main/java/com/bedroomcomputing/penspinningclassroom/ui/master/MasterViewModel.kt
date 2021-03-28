package com.bedroomcomputing.penspinningclassroom.ui.master

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bedroomcomputing.penspinningclassroom.database.TrickDao

class MasterViewModel(trickDao: TrickDao) : ViewModel() {

    val trickList = trickDao.getMastered()
}

class MasterViewModelFactory(val trickDao: TrickDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MasterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MasterViewModel(trickDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
