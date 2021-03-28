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
import androidx.navigation.fragment.findNavController
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
        val categoryList = listOf(
                Category(resources.getString(R.string.category_normal), R.drawable.ic_category_normal, "normal"),
                Category(resources.getString(R.string.category_sonic), R.drawable.ic_category_sonic, "sonic"),
                Category(resources.getString(R.string.category_gunman), R.drawable.ic_category_gunman, "gunman"),
                Category(resources.getString(R.string.category_infinity), R.drawable.ic_category_infinity, "infinity")
        )

        homeViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false)

        val adapter = GroupAdapter<GroupieViewHolder<ItemCategoryBinding>>()
        adapter.addAll(categoryListToCategoryItemList(categoryList))
        val rv = binding.rvCategory
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    private fun categoryListToCategoryItemList(list: List<Category>) : List<CategoryItem>{
        return list.map {category ->
            CategoryItem(category, View.OnClickListener {goToTrickList(category.categoryId)})
        }
    }

    private fun goToTrickList(categoryId:String){
        val action = CategoryFragmentDirections.actionNavigationCategoryToTrickListFragment(categoryId)
        findNavController().navigate(action)
    }
}