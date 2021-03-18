package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import android.content.DialogInterface
import android.view.View
import java.time.LocalDate
import java.util.*

data class TrickList(
        val trickName: String,
        val isMasterd: Boolean,
        val masterdDate: LocalDate,
        val isSaved: Boolean,
        val level: Int
)
