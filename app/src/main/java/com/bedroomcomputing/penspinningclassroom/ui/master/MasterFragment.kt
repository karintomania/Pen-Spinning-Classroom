package com.bedroomcomputing.penspinningclassroom.ui.master

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.AppDatabase
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentMasterBinding
import com.bedroomcomputing.penspinningclassroom.ui.tricklist.TrickListItem
import com.bedroomcomputing.penspinningclassroom.ui.tricklist.TrickListItemListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MasterFragment : Fragment() {

    private lateinit var viewModel: MasterViewModel
    private lateinit var binding: FragmentMasterBinding
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val trickDao = AppDatabase.getDatabase(requireContext()).trickDao()
        viewModel = MasterViewModelFactory(trickDao).create(MasterViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_master, container, false)

        val adapter = GroupAdapter<GroupieViewHolder>()

        val trickListItemListener = TrickListItemListener{
            val action = MasterFragmentDirections.actionNavigationMasterToTrickFragment(it)
            findNavController().navigate(action)
        }

        viewModel.trickList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.addAll(TrickListItem.trickListListTotrickListItemList(requireContext(), it, trickListItemListener))
        })

        binding.rvMaster.apply{
            setAdapter(adapter)
            setLayoutManager(LinearLayoutManager(requireContext()))
        }

        return binding.root
    }
}