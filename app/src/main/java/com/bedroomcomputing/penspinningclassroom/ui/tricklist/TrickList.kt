package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import android.content.DialogInterface
import android.view.View
import java.time.LocalDate
import java.util.*

data class TrickList(
        val uid: Int,
        val category: String,
        val trickName: String,
        val trickDescription: String,
        val level: Int,
        val isMasterd: Boolean,
        val masterd: LocalDate?,
        val isSaved: Boolean,
        val onClickListener: View.OnClickListener
)
