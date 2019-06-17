package com.example.busstation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.busstation.data.User
import com.example.busstation.databinding.FragmentLoginBinding
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

   /* private lateinit var userNameET:EditText
    private lateinit var userPasswordET:EditText
    private lateinit var signupTV:TextView
    private lateinit var loginBtn:Button
    */
    private lateinit var userVM:UserVM



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding:FragmentLoginBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
          binding.username =""
          binding.pw =""

        //val view = inflater.inflate(R.layout.fragment_login, container, false)
        userVM =  this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
       /* userNameET = view.user_name_et
        userPasswordET =view.user_password_et
        signupTV = view.signup_tv
        loginBtn = view.login_btn
        */


        binding.signupTv.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_userRegistration,null)
        }

        binding.loginBtn.setOnClickListener {
            // userLogin(view,userNameET.text.toString(),userPasswordET.text.toString())
            userLogin(binding.root,binding.userNameEt.text.toString(),binding.userPasswordEt.text.toString())
        }

        return binding.root
    }


    fun userLogin(view:View,name:String,pw:String){

        userVM.allUsers.observe(this, Observer {
                a->a?.let {
            for(i: User in a){
                if(i.userName == name && i.password == pw){

                    if(i.userType =="driver"){
                        val a =LoginFragmentDirections.actionLoginFragmentToDriverProfile(name,i.idNo)
                        Navigation.findNavController(view).navigate(a)
                    }
                    else {
                        val b = LoginFragmentDirections.actionLoginFragmentToUserProfile(name,i.idNo)
                        Navigation.findNavController(view).navigate(b)
                    }
                }


            }
        }
        })
    }




}
