package com.bedroomcomputing.penspinningclassroom.ui.trick

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bedroomcomputing.penspinningclassroom.R
import com.bedroomcomputing.penspinningclassroom.database.AppDatabase
import com.bedroomcomputing.penspinningclassroom.databinding.FragmentTrickBinding
import java.time.format.DateTimeFormatter

class TrickFragment : Fragment() {

    companion object {
        fun newInstance() = TrickFragment()
    }

    private lateinit var viewModel: TrickViewModel
    private lateinit var binding: FragmentTrickBinding
    val args: TrickFragmentArgs by navArgs()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val trickDao = AppDatabase.getDatabase(requireContext()).trickDao()
        viewModel = TrickViewModelFactory(trickDao, args.uid).create(TrickViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trick, container, false)

        viewModel.trick.observe(viewLifecycleOwner, Observer {
            binding.textViewTrickTrickName.text = requireContext().resources.getText(ResourceGetter.getTrickName(it.trickKey))
            binding.textViewTrickDescription.text = requireContext().resources.getText(ResourceGetter.getTrickDescription(it.trickKey))
            setStars(it.level)

            // save
            if(it.isSaved){
                binding.imageViewTrickSave.setImageResource(R.drawable.ic_saved_blue)
            }else{
                binding.imageViewTrickSave.setImageResource(R.drawable.ic_saved)
            }

            // master
            if(it.isMastered){
                binding.imageViewTrickMaster.setImageResource(R.drawable.ic_master)
                binding.textViewTrickMasteredLabel.visibility = View.VISIBLE
                binding.textViewTrickMastered.visibility = View.VISIBLE
                val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
                binding.textViewTrickMastered.text = it.mastered?.format(formatter)
            }else{
                binding.imageViewTrickMaster.setImageResource(R.drawable.ic_not_master)
                binding.textViewTrickMastered.visibility = View.INVISIBLE
                binding.textViewTrickMasteredLabel.visibility = View.INVISIBLE
            }
        })

        binding.imageViewTrickSave.setOnClickListener{
            viewModel.saveTrick()
        }

        binding.imageViewTrickMaster.setOnClickListener{
            viewModel.masterTrick()
        }



        return binding.root
    }

    private fun setStars(level:Int){
        if(level >= 1) binding.imageViewTrickStar1.setImageResource(R.drawable.ic_star)
        if(level >= 2) binding.imageViewTrickStar2.setImageResource(R.drawable.ic_star)
        if(level >= 3) binding.imageViewTrickStar3.setImageResource(R.drawable.ic_star)
        if(level >= 4) binding.imageViewTrickStar4.setImageResource(R.drawable.ic_star)
        if(level >= 5) binding.imageViewTrickStar5.setImageResource(R.drawable.ic_star)
    }

}

