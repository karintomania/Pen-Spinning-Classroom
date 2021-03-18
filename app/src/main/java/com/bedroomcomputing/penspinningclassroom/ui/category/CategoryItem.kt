package com.bedroomcomputing.penspinningclassroom.ui.category

import android.util.Log
import android.view.View
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.databinding.ItemCategoryBinding
import com.xwray.groupie.viewbinding.BindableItem

class CategoryItem(val category:Category, val onClickListener: View.OnClickListener): BindableItem<ItemCategoryBinding>(){
    override fun getLayout(): Int {
       return R.layout.item_category
    }

    override fun bind(binding: ItemCategoryBinding, position: Int) {
        binding.textViewCategoryName.setText(category.categoryName)
        binding.imageViewCategoryIcon.setImageResource(category.iconResourceId)
        binding.imageView.setOnClickListener(onClickListener)
    }

    override fun initializeViewBinding(view: View): ItemCategoryBinding {
        return ItemCategoryBinding.bind(view)
    }

}
