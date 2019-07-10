package com.example.busstation


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
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
import com.example.busstation.viewmodel2.DriverViewModel
import com.example.busstation.viewmodel2.TransportInfoViewModel
import kotlinx.android.synthetic.main.fragment_traveller_buy_ticket.view.*
import kotlinx.coroutines.runBlocking


class TravellerBuyTicket : Fragment() {

    //Local
    private lateinit var transpInfoVM:TranspInfoviewmodel
    private lateinit var driverVM:DriverVM
    //Remote
    private lateinit var transportInfoViewModel:TransportInfoViewModel
    private lateinit var driverViewModel:DriverViewModel


    var conectionStatus:Boolean=false



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
        //Remote
        transportInfoViewModel=this.activity?.let { ViewModelProviders.of(it).get(TransportInfoViewModel::class.java) }!!
        driverViewModel=this.activity?.let { ViewModelProviders.of(it).get(DriverViewModel::class.java) }!!


        val transportInfoAdapter =TransPortInfoAdapter()

        view?.transport_info_rv?.adapter = transportInfoAdapter
        view?.transport_info_rv?.layoutManager =LinearLayoutManager(activity)
        //Remote
if (connected()) {
    transportInfoViewModel.let { tivm ->
        tivm.getAllInfos()
        tivm.gAllInfos.observe(this, Observer { response ->
            response.body().run {
                if (this != null) {
                    transportInfoAdapter.noOfItem = this.size
                    transportInfoAdapter.conectionState = true
                    transportInfoAdapter.setTransportInfo2(this)

                }
            }

        })
    }
    driverViewModel.let { dvm ->
        dvm.getAllDrivers()
        dvm.gAllDrivers.observe(this, Observer { response ->
            response.body().run {
                if (this != null) {
                    transportInfoAdapter.setCarInfo2(this)

                }
            }

        })
    }
}

       else{


        transpInfoVM.allTransInfo.observe(this, Observer {
            infos->infos?.let {
            transportInfoAdapter.noOfItem=infos.size
            transportInfoAdapter.conectionState=false
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
    private fun connected():Boolean {

        val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }


}






































