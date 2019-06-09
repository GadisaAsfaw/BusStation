package com.example.busstation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.busstation.data.User
import kotlinx.android.synthetic.main.fragment_user_profile.view.*


class UserProfile : Fragment() {
    private lateinit var  userNameTV:TextView
    private  lateinit var  buyTicketBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_user_profile, container, false)
        userNameTV = view.a_user_tv
        buyTicketBtn = view.buy_ticket_btn

        val activeU = arguments?.getSerializable("active") as String
        userNameTV.text = activeU
        return view
    }



    companion object{
        fun getInstance(user:String):UserProfile{
            val fragment = UserProfile()
            val bundle = Bundle()
            bundle.putSerializable("active",user)
            fragment.arguments = bundle
            return fragment
        }
    }







}
