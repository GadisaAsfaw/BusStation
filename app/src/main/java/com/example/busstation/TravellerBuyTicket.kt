package com.example.busstation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busstation.data.TransportInfo
import com.example.busstation.databinding.FragmentTravellerBuyTicketBinding
import com.example.busstation.viewmodel.DriverVM
import com.example.busstation.viewmodel.TranspInfoviewmodel
import kotlinx.android.synthetic.main.fragment_traveller_buy_ticket.view.*


class TravellerBuyTicket : Fragment() {
    private lateinit var transpInfoVM:TranspInfoviewmodel
    private lateinit var driverVM:DriverVM



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val binding:FragmentLoginBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        val binding:FragmentTravellerBuyTicketBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_traveller_buy_ticket,container,false)
        //val view = inflater.inflate(R.layout.fragment_traveller_buy_ticket, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        transpInfoVM= this.activity?.let { ViewModelProviders.of(it).get(TranspInfoviewmodel::class.java) }!!
        driverVM =this.activity?.let { ViewModelProviders.of(it).get(DriverVM::class.java) }!!


        val transportInfoAdapter =TransPortInfoAdapter()


        view?.transport_info_rv?.adapter = transportInfoAdapter
        view?.transport_info_rv?.layoutManager =LinearLayoutManager(activity)

       transpInfoVM.allTransInfo.observe(this, Observer {
            infos->infos?.let {
            transportInfoAdapter.setTransportInfo(infos)
        }
        })
        driverVM.allUsers.observe(this, Observer {
                carInfos->carInfos?.let {
            transportInfoAdapter.setCarInfo(carInfos)
        }
        })


    }


}






































