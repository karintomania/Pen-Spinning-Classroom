package com.bedroomcomputing.penspinningclassroom.ui.trick

import android.graphics.DiscretePathEffect
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bedroomcomputing.penspinningclassroom.database.Trick
import com.bedroomcomputing.penspinningclassroom.database.TrickDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate

class TrickViewModel(val trickDao: TrickDao, val trickId: Int) : ViewModel() {
    val trick = trickDao.selectByUid(trickId)

    fun saveTrick(){
        trick.value?.let{
            it.isSaved = !it.isSaved
            viewModelScope.launch {
                updateTrick(it)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun masterTrick(){
        trick.value?.let{
            it.isMastered = !it.isMastered
            it.mastered = LocalDate.now()
            viewModelScope.launch {
                updateTrick(it)
            }
        }
    }

    suspend fun updateTrick(trick: Trick){
        withContext(Dispatchers.IO){
            trickDao.updateTrick(trick)
        }
    }
}

class TrickViewModelFactory(val trickDao: TrickDao, val trickId:Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrickViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TrickViewModel(trickDao, trickId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}