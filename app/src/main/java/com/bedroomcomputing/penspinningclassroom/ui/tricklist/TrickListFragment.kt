package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.AppDatabase
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickListBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class TrickListFragment : Fragment() {

    companion object {
        fun newInstance() = TrickListFragment()
    }

    private lateinit var viewModel: TrickListViewModel
    private lateinit var binding: FragmentTrickListBinding
    val args: TrickListFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val trickDao = AppDatabase.getDatabase(requireContext()).trickDao()
        viewModel = TrickListViewModelFactory(trickDao, args.category).create(TrickListViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trick_list, container, false)
        val adapter = GroupAdapter<GroupieViewHolder>()

        val trickListItemListener = TrickListItemListener{
            val action = TrickListFragmentDirections.actionTrickListFragmentToTrickFragment(it)
            findNavController().navigate(action)
        }

        viewModel.trickList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.addAll(TrickListItem.trickListListTotrickListItemList(requireContext(), it, trickListItemListener))
        })

        binding.rvTrickList.apply {
            setAdapter(adapter)
            setLayoutManager(LinearLayoutManager(requireContext()))
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}