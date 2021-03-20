package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bedroomcomputing.penspinningclassroom.database.Trick
import com.bedroomcomputing.penspinningclassroom.database.TrickDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TrickListViewModel(val trickDao: TrickDao) : ViewModel() {

    val trickList = trickDao.getAll();
    init{
    }



}
class TrickListViewModelFactory(val trickDao: TrickDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrickListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TrickListViewModel(trickDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}