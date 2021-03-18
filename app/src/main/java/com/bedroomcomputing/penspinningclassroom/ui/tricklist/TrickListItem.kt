package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import android.view.View
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickListBinding
import com.bedroomcomputing.penspinningclassroom.databinding.ItemTrickBinding
import com.xwray.groupie.viewbinding.BindableItem

class TrickListItem(val trickLit:TrickList): BindableItem<ItemTrickBinding>(){
    override fun getLayout(): Int {
        return R.layout.item_trick
    }

    override fun bind(binding: ItemTrickBinding, position: Int) {
        binding.textViewTrickListName.setText("aaaa")
    }

    override fun initializeViewBinding(view: View): ItemTrickBinding {
        return ItemTrickBinding.bind(view)
    }

}
