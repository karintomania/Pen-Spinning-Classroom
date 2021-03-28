package com.bedroomcomputing.penspinningclassroom.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bedroomcomputing.penspinningclassroom.database.TrickDao

class SavedViewModel(trickDao: TrickDao) : ViewModel() {

    val trickList = trickDao.getSaved();

}

class SavedViewModelFactory(val trickDao: TrickDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SavedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SavedViewModel(trickDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
