package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickListBinding
import com.bedroomcomputing.penspinningclassroom.databinding.ItemTrickBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import java.time.LocalDate
import java.util.*

class TrickListFragment : Fragment() {

    companion object {
        fun newInstance() = TrickListFragment()
    }

    private lateinit var viewModel: TrickListViewModel
    private lateinit var binding: FragmentTrickListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val trickListList = listOf(
                TrickList("Thumb acound", true, LocalDate.now(), true, 1),
                TrickList("Thumb acound", true, LocalDate.now(), true, 1),
                TrickList("Thumb acound", true, LocalDate.now(), true, 1)
        )

        viewModel = ViewModelProvider(this).get(TrickListViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trick_list, container, false)

        val adapter = GroupAdapter<GroupieViewHolder>()
        adapter.addAll(trickListListTotrickListItemList(trickListList))
        val rv = binding.rvTrickList
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    private fun trickListListTotrickListItemList(list: List<TrickList>) : List<TrickListItem>{
        return list.map {
            TrickListItem(it)
        }
    }
    private fun goToTrick(){
    }
}