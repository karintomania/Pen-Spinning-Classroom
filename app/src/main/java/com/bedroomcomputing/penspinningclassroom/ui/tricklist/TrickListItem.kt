package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import android.view.View
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.Trick
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickListBinding
import com.bedroomcomputing.penspinningclassroom.databinding.ItemTrickBinding
import com.bedroomcomputing.penspinningclassroom.ui.trick.ResourceGetter
import com.xwray.groupie.viewbinding.BindableItem

class TrickListItem(val trick: TrickList): BindableItem<ItemTrickBinding>(){
    override fun getLayout(): Int {
        return R.layout.item_trick
    }

    override fun bind(binding: ItemTrickBinding, position: Int) {
        binding.textViewTrickListName.setText(trick.trickName)
    }

    override fun initializeViewBinding(view: View): ItemTrickBinding {
        return ItemTrickBinding.bind(view)
    }

}
