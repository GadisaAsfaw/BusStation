package com.example.busstation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.busstation.data.User
import com.example.busstation.databinding.FragmentUserRegistrationBinding
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_user_registration.view.*


class UserRegistration : Fragment() {

    private  lateinit var  selectedRB:RadioButton


    private lateinit var  userVM: UserVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentUserRegistrationBinding =
                 DataBindingUtil.inflate(inflater,R.layout.fragment_user_registration,container,false)
       // val view =inflater.inflate(R.layout.fragment_user_registration, container, false)
         userVM = this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!

             binding.submitBtn.setOnClickListener {



            userVM.let { a->a.insertUser(readFields(binding))}
            Toast.makeText(activity,"user added",Toast.LENGTH_LONG).show()
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


}
