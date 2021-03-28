package com.bedroomcomputing.penspinningclassroom.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.AppDatabase
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentSavedBinding
import com.bedroomcomputing.penspinningclassroom.ui.tricklist.TrickListItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class SavedFragment : Fragment() {

    private lateinit var viewModel: SavedViewModel
    private lateinit var binding: FragmentSavedBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val trickDao = AppDatabase.getDatabase(requireContext()).trickDao()
        viewModel = SavedViewModelFactory(trickDao).create(SavedViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saved, container, false)

        val adapter = GroupAdapter<GroupieViewHolder>()

        viewModel.trickList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.addAll(TrickListItem.trickListListTotrickListItemList(requireContext(), it))
        })

        binding.rvSaved.apply{
            setAdapter(adapter)
            setLayoutManager(LinearLayoutManager(requireContext()))
        }

        return binding.root
    }
}