package com.bedroomcomputing.penspinningclassroom.ui.category

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentCategoryBinding
import com.bedroomcomputing.penspinningclassroom.databinding.ItemCategoryBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.GroupieViewHolder

class CategoryFragment : Fragment() {

    private lateinit var homeViewModel: CategoryViewModel
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false)

        val adapter = GroupAdapter<GroupieViewHolder<ItemCategoryBinding>>()
        val list = listOf("Normal", "Sonic", "Gunman")
        adapter.addAll(categoryListToCategoryItemList(list))
        val rv = binding.rvCategory
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    private fun categoryListToCategoryItemList(list: List<String>) : List<CategoryItem>{
        return list.map {
            CategoryItem(it)
        }
    }
}