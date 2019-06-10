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
import kotlinx.android.synthetic.main.fragment_driver_profile.view.*


class DriverProfile : Fragment() {
    private lateinit var dUserNameTV:TextView
    private lateinit var dBuyTicketBtn:Button
    private lateinit var availableSeatBtn:Button
    private lateinit var basicInfoBtn:Button

    private  lateinit var listner: OnDriverProfileButtonsClicked

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnDriverProfileButtonsClicked){
            listner = context
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_driver_profile, container, false)
        dUserNameTV = view.d_user_name_tv
        dBuyTicketBtn = view.d_buy_ticket_btn
        availableSeatBtn = view.available_seat_btn
        basicInfoBtn = view.basic_info_btn
        basicInfoBtn.setOnClickListener {
            listner.onBasicInfoBtnclicked()
        }
        dBuyTicketBtn.setOnClickListener {
            listner.onBuyTicketBtnClicked()
        }
        availableSeatBtn.setOnClickListener {
            Toast.makeText(activity,"0 seats are available",Toast.LENGTH_LONG).show()
        }

        //
        val activeU = arguments?.getString("active") as String
        dUserNameTV.text = activeU
        return view
    }


    companion object{
        fun getInstance(username:String):DriverProfile{
            val fragment = DriverProfile()
            val bundle = Bundle()
            bundle.putString("active",username)
            fragment.arguments = bundle
            return  fragment
        }
    }
    interface OnDriverProfileButtonsClicked{
        fun onBuyTicketBtnClicked()
        fun onBasicInfoBtnclicked()


    }


}
