package com.bedroomcomputing.penspinningclassroom.ui.trick

import com.bedroomcomputing.penspinningclassroom.R

class ResourceGetter {
    companion object{
        fun getTrickNameFromTrickKey(trickKey:String): Int{
            return when(trickKey){
                "n0001" -> R.string.trick_n0001
                else -> R.string.trick_n0001
            }
        }

        fun getTrickDescriptionFromTrickKey(trickKey:String): Int{
            return when(trickKey){
                "n0001" -> R.string.trickDescription_n0001
                else -> R.string.trickDescription_n0001
            }
        }
    }
}