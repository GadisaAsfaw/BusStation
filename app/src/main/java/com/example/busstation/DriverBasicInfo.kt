package com.example.busstation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.busstation.data.BankAccount
import com.example.busstation.data.Driver
import com.example.busstation.data2.User

import com.example.busstation.viewmodel.AccountVM
import com.example.busstation.viewmodel.DriverVM
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_driver_basic_info.view.*
import com.example.busstation.databinding.FragmentDriverBasicInfoBinding
import com.example.busstation.viewmodel2.AccountViewModel
import com.example.busstation.viewmodel2.DriverViewModel
import com.example.busstation.viewmodel2.UserViewModel
//import com.example.busstation.data.User




class DriverBasicInfo : Fragment() {
    private lateinit var activeUserName:String

    //local

    private lateinit var userVM: UserVM
    private lateinit var accVM:AccountVM
    //remote

    private lateinit var userViewModel:UserViewModel
    private lateinit var  accountViewModel:AccountViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentDriverBasicInfoBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_driver_basic_info,container,false)

        /////

        userVM =  this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
        accVM = this.activity?.let { ViewModelProviders.of(it).get(AccountVM::class.java) }!!
        //remote
        userViewModel=this.activity?.let { ViewModelProviders.of(it).get(UserViewModel::class.java) }!!
        accountViewModel=this.activity?.let { ViewModelProviders.of(it).get(AccountViewModel::class.java) }!!
        /////
        activeUserName = arguments?.getString("username") as String
        Toast.makeText(activity,"name:"+activeUserName,Toast.LENGTH_LONG).show()

        //binding.addInfoBtn.setOnClickListener { updateDriver(binding,binding.root,activeUserName) }//local
        binding.addInfoBtn.setOnClickListener { updateDriver2(binding,binding.root,activeUserName) }//remote
        return binding.root
    }

    //local
   /* fun updateDriver(binding: FragmentDriverBasicInfoBinding,view: View,name:String){
        //to simulate account transaction
        //we are using as if user pw and bank
        //acount pw is the same
        userVM.allUsers.observe(this, Observer {
                a->a?.let {
            for(i: User in a){
                if(i.userName == name ){

                    //Toast.makeText(activity,"user exist"+i.userName+i.password+i.userType, Toast.LENGTH_LONG).show()

                    accVM.let {b->b.insertAccount(BankAccount(binding.accNoEt.text.toString(),i.password,500.toFloat())) }
                    Toast.makeText(activity,"User updated",Toast.LENGTH_LONG).show()
                    //Navigation.findNavController(view).navigate(R.id.action_driverBasicInfo_to_confirmBackAccount,null)
                    val confirmAccount =
                        DriverBasicInfoDirections.actionDriverBasicInfoToConfirmBackAccount(
                            i.userName,i.password,i.idNo,
                            binding.licenseNoEt.text.toString(),binding.carVinEt.text.toString(),
                            binding.carSideNoEt.text.toString().toInt(),binding.seatNoEt.text.toString().toInt(),binding.accNoEt.text.toString())
                    Navigation.findNavController(view).navigate(confirmAccount)
                }


            }
        }
        })
    }
    */
    //remote
    fun updateDriver2(binding: FragmentDriverBasicInfoBinding,view: View,name:String){
        //to simulate account transaction
        //we are using as if user pw and bank
        //acount pw is the same
        userViewModel.let {
            b->b.getAllUsers()
            b.gAllUsers.observe(this, Observer {response->
                response.body().run {
                    if(this !=null){

                        for(user:User in this){
                            if(user.userName==name){
                                accountViewModel.let { av->av.updateAccount(com.example.busstation.data2.BankAccount(
                                    binding.accNoEt.text.toString(),user.password,500.toFloat()) ) }

                                val confirmAccount =
                                    DriverBasicInfoDirections.actionDriverBasicInfoToConfirmBackAccount(
                                        user.userName,user.password,user.idNo,
                                        binding.licenseNoEt.text.toString(),binding.carVinEt.text.toString(),
                                        binding.carSideNoEt.text.toString().toInt(),binding.seatNoEt.text.toString().toInt(),binding.accNoEt.text.toString())
                                Navigation.findNavController(view).navigate(confirmAccount)

                            }
                        }

                    }

                }
            })
        }
       //userViewModel.let { b->b.getUserByName(name) }
       // userViewModel.let { b->b.getAllUsers() }

    }





}
