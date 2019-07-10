package com.example.busstation


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
//import com.example.busstation.data.User
import com.example.busstation.data2.User

import com.example.busstation.databinding.FragmentUserRegistrationBinding
import com.example.busstation.viewmodel.UserVM
import com.example.busstation.viewmodel2.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_registration.view.*


class UserRegistration : Fragment() {

    private  lateinit var  selectedRB:RadioButton


    private lateinit var  userVM: UserVM
    private lateinit var  userViewModel:UserViewModel
    private lateinit var name:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentUserRegistrationBinding =
                 DataBindingUtil.inflate(inflater,R.layout.fragment_user_registration,container,false)
       // val view =inflater.inflate(R.layout.fragment_user_registration, container, false)
         userVM = this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
        userViewModel  = this.activity?.let { ViewModelProviders.of(it).get(UserViewModel::class.java) }!!

             binding.submitBtn.setOnClickListener {



          //  userVM.let { a->a.insertUser(readFields(binding))}
            //Toast.makeText(activity,"user added",Toast.LENGTH_LONG).show()
                 if(connected()) {
                     Toast.makeText(activity, "ConnectionCreated", Toast.LENGTH_LONG).show()
                     userViewModel.let { a -> a.insertUser(readFields2(binding)) }
                    /* userViewModel.iUser.observe(this, Observer {
                         a->a.body()?.let {
                         name =it.userName
                         binding.textView4.text=it.userName
                        }
                     })*/
                    // Toast.makeText(activity, "user added"+name, Toast.LENGTH_LONG).show()

                 }
                 else{ Toast.makeText(activity, "No connection", Toast.LENGTH_LONG).show()

                 }
        }

        return binding.root
    }

    fun readFields(binding: FragmentUserRegistrationBinding):User{

        if(binding.driverRb.isChecked){
            selectedRB =binding.driverRb
        }
        else{selectedRB =binding.travellerRb }
          //selectedRB.text.toString()
        return User(binding.uNameEt.text.toString(),
                    binding.userPasswordEt.text.toString(),
                    binding.idNoEt.text.toString(),
                    selectedRB.text.toString()

            )

    }
    fun readFields2(binding: FragmentUserRegistrationBinding):User{

        if(binding.driverRb.isChecked){
            selectedRB =binding.driverRb
        }
        else{selectedRB =binding.travellerRb }
        //selectedRB.text.toString()
        return User(binding.idNoEt.text.toString(),
            binding.uNameEt.text.toString(),
            binding.userPasswordEt.text.toString(),
            selectedRB.text.toString()

        )

    }
    private fun connected():Boolean {

        val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }



}
