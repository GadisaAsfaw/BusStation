package com.example.busstation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.busstation.databinding.FragmentSelectDestinationBinding
import kotlinx.android.synthetic.main.fragment_select_destination.view.*


class SelectDestination : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val binding:FragmentSelectDestinationBinding =
                DataBindingUtil.inflate(inflater,R.layout.fragment_select_destination,container,false)

        binding.continueBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_selectDestination_to_travellerBuyTicket,null)

        }
        return binding.root
    }


}
