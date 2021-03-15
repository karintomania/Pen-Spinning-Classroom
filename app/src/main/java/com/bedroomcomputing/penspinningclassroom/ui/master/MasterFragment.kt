package com.bedroomcomputing.penspinningclassroom.ui.master

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bedroomcomputing.penspinningclassroom.R

class MasterFragment : Fragment() {

    private lateinit var masterViewModel: MasterViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        masterViewModel =
                ViewModelProvider(this).get(MasterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_master, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        masterViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}