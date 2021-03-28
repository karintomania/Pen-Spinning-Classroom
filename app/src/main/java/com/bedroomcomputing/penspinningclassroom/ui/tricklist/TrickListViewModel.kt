package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bedroomcomputing.penspinningclassroom.database.Trick
import com.bedroomcomputing.penspinningclassroom.database.TrickDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class TrickListViewModel(val trickDao: TrickDao, val categoryName:String) : ViewModel() {

    var trickList = trickDao.selectByCategory(categoryName)
    init{
//        insert()
    }

    fun insert(){
        val trick = Trick(4, "sonic", "s002", 2, true, LocalDate.now(), true)

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                trickDao.insertAll(trick)
            }
        }
    }


}
class TrickListViewModelFactory(val trickDao: TrickDao, val categoryName:String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrickListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TrickListViewModel(trickDao, categoryName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}