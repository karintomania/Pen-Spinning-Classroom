package com.bedroomcomputing.penspinningclassroom.ui.trick

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bedroomcomputing.penspinningclassroom.R

class TrickFragment : Fragment() {

    companion object {
        fun newInstance() = TrickFragment()
    }

    private lateinit var viewModel: TrickViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trick, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrickViewModel::class.java)
        // TODO: Use the ViewModel
    }

}