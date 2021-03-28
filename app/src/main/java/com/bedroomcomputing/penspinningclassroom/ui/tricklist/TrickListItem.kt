package com.bedroomcomputing.penspinningclassroom.ui.tricklist

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.Trick
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickListBinding
import com.bedroomcomputing.penspinningclassroom.databinding.ItemTrickBinding
import com.bedroomcomputing.penspinningclassroom.ui.trick.ResourceGetter
import com.xwray.groupie.viewbinding.BindableItem
import java.time.format.DateTimeFormatter

class TrickListItem(val trick: TrickList): BindableItem<ItemTrickBinding>(){
    override fun getLayout(): Int {
        return R.layout.item_trick
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun bind(binding: ItemTrickBinding, position: Int) {
        binding.textViewTrickItemName.setText(trick.trickName)
        binding.imageViewEnter.setOnClickListener(trick.onClickListener)

        if(!trick.isSaved){
            binding.imageViewTrickItemSaved.visibility = View.INVISIBLE
        }
        if(trick.isMasterd){

            val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
            val masteredAtText = "Mastered at: " + trick.masterd?.format(formatter)
            binding.textViewTrickItemMasteredAt.setText("Masterd at: 2021/01/01")
            binding.imageViewTrickItemMastered.setImageResource(R.drawable.ic_master)

        }else{
            binding.textViewTrickItemMasteredAt .visibility = View.INVISIBLE
        }

        setStars(binding, trick.level)
    }

    private fun setStars(binding: ItemTrickBinding, level:Int){
            if(level >= 1) binding.imageViewStar1.setImageResource(R.drawable.ic_star)
            if(level >= 2) binding.imageViewStar2.setImageResource(R.drawable.ic_star)
            if(level >= 3) binding.imageViewStar3.setImageResource(R.drawable.ic_star)
            if(level >= 4) binding.imageViewStar4.setImageResource(R.drawable.ic_star)
            if(level >= 5) binding.imageViewStar5.setImageResource(R.drawable.ic_star)
    }

    override fun initializeViewBinding(view: View): ItemTrickBinding {
        return ItemTrickBinding.bind(view)
    }

    companion object{

        fun trickListListTotrickListItemList(context: Context, list: List<Trick>, trickListItemListener: TrickListItemListener) : List<TrickListItem>{
            return list.map { trick ->
                val trickList = TrickList(
                        trick.uid,
                        trick.category,
                        getTrickName(context, trick.trickKey),
                        getTrickDesc(context, trick.trickKey),
                        trick.level,
                        trick.isMastered,
                        trick.mastered,
                        trick.isSaved,
                        View.OnClickListener {  trickListItemListener.onClick(trick) }
                )
                TrickListItem(trickList)
            }
        }

        private  fun getTrickName(context: Context, trickKey:String): String{
            return context.resources.getString(ResourceGetter.getTrickNameFromTrickKey(trickKey))
        }

        private  fun getTrickDesc(context: Context, trickKey:String): String{
            return context.resources.getString(ResourceGetter.getTrickDescriptionFromTrickKey(trickKey))
        }
    }
}

class TrickListItemListener(val clickListener: (uid: Int) -> Unit){
    fun onClick(trick: Trick) = clickListener(trick.uid);
}