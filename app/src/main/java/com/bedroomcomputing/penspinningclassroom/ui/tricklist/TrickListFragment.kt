package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bedroomcomputing.penspinningclassroom.R

class TrickListFragment : Fragment() {

    companion object {
        fun newInstance() = TrickListFragment()
    }

    private lateinit var viewModel: TrickListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.trick_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrickListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}