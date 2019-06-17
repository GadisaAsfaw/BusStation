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
import com.example.busstation.data.User
import com.example.busstation.viewmodel.AccountVM
import com.example.busstation.viewmodel.DriverVM
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_driver_basic_info.view.*
import com.example.busstation.databinding.FragmentDriverBasicInfoBinding


class DriverBasicInfo : Fragment() {
    private lateinit var activeUserName:String
    private lateinit var user:User
    private lateinit var userVM: UserVM
    private lateinit var driveVM:DriverVM
    private lateinit var accVM:AccountVM



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentDriverBasicInfoBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_driver_basic_info,container,false)

        /////
        userVM =  this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
        driveVM = this.activity?.let { ViewModelProviders.of(it).get(DriverVM::class.java) }!!
        accVM = this.activity?.let { ViewModelProviders.of(it).get(AccountVM::class.java) }!!
        /////
        activeUserName = arguments?.getString("username") as String
        Toast.makeText(activity,"name:"+activeUserName,Toast.LENGTH_LONG).show()

        binding.addInfoBtn.setOnClickListener {
            updateDriver(binding,binding.root,activeUserName)

             }
        return binding.root
    }

    fun updateDriver(binding: FragmentDriverBasicInfoBinding,view: View,name:String){
        //to simulate account transaction
        //we are using as if user pw and bank
        //acount pw is the same
        userVM.allUsers.observe(this, Observer {
                a->a?.let {
            for(i: User in a){
                if(i.userName == name ){
                    user = i
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




}
