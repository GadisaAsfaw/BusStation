package com.example.busstation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_driver_profile.view.*
import com.example.busstation.databinding.FragmentDriverProfileBinding


class DriverProfile : Fragment() {
    private lateinit var activeUid:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentDriverProfileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_driver_profile,container,false)

        binding.activeUser = arguments?.getString("username") as String
        activeUid = arguments?.getString("userid") as String

        binding.basicInfoBtn.setOnClickListener {
            val basicInfo =
                DriverProfileDirections.actionDriverProfileToDriverBasicInfo(binding.dUserNameTv.text.toString())
            Navigation.findNavController(binding.root).navigate(basicInfo)
        }
        binding.dBuyTicketBtn.setOnClickListener {
            // Navigation.findNavController(binding.root).navigate(R.id.action_driverProfile_to_driverBuyTicket,null)
           val driverBuyTicket = DriverProfileDirections.actionDriverProfileToDriverBuyTicket(activeUid)
            Navigation.findNavController(binding.root).navigate(driverBuyTicket)
        }
        binding.availableSeatBtn.setOnClickListener {
            Toast.makeText(activity,"0 seats are available",Toast.LENGTH_LONG).show()
        }
        return binding.root
    }





}
