package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bedroomcomputing.penspinningclassroom.database.TrickDao

class TrickListViewModel(val trickDao: TrickDao) : ViewModel() {


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