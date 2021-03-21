package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.AppDatabase
import com.bedroomcomputing.penspinningclassroom.database.Trick
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickListBinding
import com.bedroomcomputing.penspinningclassroom.databinding.ItemTrickBinding
import com.bedroomcomputing.penspinningclassroom.ui.trick.ResourceGetter
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

        val trickDao = AppDatabase.getDatabase(requireContext()).trickDao()
        viewModel = TrickListViewModelFactory(trickDao).create(TrickListViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trick_list, container, false)
        val adapter = GroupAdapter<GroupieViewHolder>()

        viewModel.trickList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.addAll(trickListListTotrickListItemList(it))
        })

        val rv = binding.rvTrickList
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    private fun trickListListTotrickListItemList(list: List<Trick>) : List<TrickListItem>{
        return list.map {
            val trickList = TrickList(
                it.category,
                requireContext().resources.getString(ResourceGetter.getTrickNameFromTrickKey(it.trickKey)),
                requireContext().resources.getString(ResourceGetter.getTrickDescriptionFromTrickKey(it.trickKey)),
                it.level,
                it.isMastered,
                it.mastered,
                it.isSaved
            )
            TrickListItem(trickList)
        }
    }
}