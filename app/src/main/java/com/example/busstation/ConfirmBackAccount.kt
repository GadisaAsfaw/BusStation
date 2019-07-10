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
import com.example.busstation.data.BankAccount
import com.example.busstation.data.Driver
import com.example.busstation.databinding.FragmentConfirmBackAccountBinding
import com.example.busstation.viewmodel.AccountVM
import com.example.busstation.viewmodel.DriverVM
import com.example.busstation.viewmodel2.AccountViewModel
import com.example.busstation.viewmodel2.DriverViewModel

import kotlinx.android.synthetic.main.fragment_confirm_back_account.view.*
import kotlinx.android.synthetic.main.fragment_confirm_back_account.view.acc_confirm_btn
import kotlinx.android.synthetic.main.fragment_confirm_back_account.view.acc_password_et


class ConfirmBackAccount : Fragment() {
    private lateinit var mYdriver:Driver
    private lateinit var mYDriver2:com.example.busstation.data2.Driver
    //local
    private lateinit var  accountVM:AccountVM
    private lateinit var driverVM:DriverVM
    //remote
    private lateinit var accountViewModel:AccountViewModel
    private lateinit var driverViewModel:DriverViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentConfirmBackAccountBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_confirm_back_account,container,false)

        accountVM =this.activity?.let { ViewModelProviders.of(it).get(AccountVM::class.java) }!!
        driverVM =this.activity?.let { ViewModelProviders.of(it).get(DriverVM::class.java) }!!
        ///
        accountViewModel =this.activity?.let { ViewModelProviders.of(it).get(AccountViewModel::class.java) }!!
        driverViewModel=this.activity?.let { ViewModelProviders.of(it).get(DriverViewModel::class.java) }!!
        mYdriver = Driver(
                arguments?.getString("a") as String,
                arguments?.getString("b") as String,
                arguments?.getString("c") as String,
                arguments?.getString("d") as String,
                arguments?.getString("e") as String,
                arguments?.getInt("i1") as Int,
                arguments?.getInt("i2") as Int,
                arguments?.getString("f") as String
        )
        ////This going to be modified
        mYDriver2=com.example.busstation.data2.Driver(
            arguments?.getString("a") as String,
            arguments?.getString("b") as String,
            arguments?.getString("c") as String,
            arguments?.getString("d") as String,
            arguments?.getString("e") as String,
            arguments?.getInt("i1") as Int,
            arguments?.getInt("i2") as Int,
            arguments?.getString("f") as String
        )

        //binding.accConfirmBtn.setOnClickListener {
           // authenticateAcountAndUpdateDriver(binding.accConfNoEt.text.toString(),binding.accPasswordEt.text.toString()) }
        binding.accConfirmBtn.setOnClickListener {
            authenticateAcountAndUpdateDriver2(binding.accConfNoEt.text.toString(),binding.accPasswordEt.text.toString()) }


        return binding.root
    }


    fun authenticateAcountAndUpdateDriver(accNo: String,accPassword: String){

        accountVM.allAccount.observe(this, Observer {
                a->a?.let {
            for(i: BankAccount in a){
                if(i.acc_number == accNo && i.password == accPassword){
                    driverVM.insertDriver(mYdriver)
                   Toast.makeText(activity,"Still working hm>>>!!!!!!"+i.balance+mYdriver.carSideNo,Toast.LENGTH_LONG).show()
                }


            }
        }
        })
    }

    //remote
    fun authenticateAcountAndUpdateDriver2(accNo: String,accPassword: String){


        accountViewModel.let {
            avm->avm.getAllAccounts()
            avm.gAllAccounts.observe(this, Observer { response->
                response.body().run {
                    if(this!=null){
                        for(account:com.example.busstation.data2.BankAccount in this){
                            if(account.acc_number==accNo && account.password==accPassword){
                                driverViewModel.let { dvm->dvm.insertDriver(mYDriver2) }
                                Toast.makeText(activity,"Still working NETWORK>>>!!!!!!",Toast.LENGTH_LONG).show()


                            }

                        }
                    }

                }
            })

        }
        accountVM.allAccount.observe(this, Observer {
                a->a?.let {
            for(i: BankAccount in a){
                if(i.acc_number == accNo && i.password == accPassword){
                    driverVM.insertDriver(mYdriver)
                    Toast.makeText(activity,"Still working hm>>>!!!!!!"+i.balance+mYdriver.carSideNo,Toast.LENGTH_LONG).show()

                }


            }
        }
        })
    }


}
