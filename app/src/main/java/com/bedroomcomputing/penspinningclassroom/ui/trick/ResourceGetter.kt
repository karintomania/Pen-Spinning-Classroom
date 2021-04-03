package com.bedroomcomputing.penspinningclassroom.ui.trick

import android.util.Log
import com.bedroomcomputing.penspinningclassroom.R

class ResourceGetter {
    companion object{
        fun getTrickName(trickKey:String): Int{
            Log.d("resource", trickKey)
            return when(trickKey){
                // normal
                "n001" -> R.string.trick_n0001
                "n002" -> R.string.trick_n0002
                // sonic
                "s001" -> R.string.trick_s0001
                else -> R.string.trick_n0001
            }
        }

        fun getTrickDescription(trickKey:String): Int{
            return when(trickKey){
                "n001" -> R.string.trickDescription_n0001
                else -> R.string.trickDescription_default
            }
        }
    }
}