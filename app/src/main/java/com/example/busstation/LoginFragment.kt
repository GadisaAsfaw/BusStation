package com.example.busstation


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.busstation.data.User
import com.example.busstation.databinding.FragmentLoginBinding
import com.example.busstation.viewmodel.UserVM
import com.example.busstation.viewmodel2.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private lateinit var userVM:UserVM
    private lateinit var userViewModel: UserViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val binding:FragmentLoginBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
          binding.username =""
          binding.pw =""

        //val view = inflater.inflate(R.layout.fragment_login, container, false)
        userVM =  this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
        userViewModel = this.activity?.let { ViewModelProviders.of(it).get(UserViewModel::class.java) }!!



        binding.signupTv.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_userRegistration,null)
        }

        binding.loginBtn.setOnClickListener {
            // userLogin(view,userNameET.text.toString(),userPasswordET.text.toString())
           // userLogin(binding.root,binding.userNameEt.text.toString(),binding.userPasswordEt.text.toString())
            userLogin2(binding.root,binding.userNameEt.text.toString(),binding.userPasswordEt.text.toString())
        }

        return binding.root
    }


   /* fun userLogin(view:View,name:String,pw:String){

        /*userVM.allUsers.observe(this, Observer {
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
        })*/
        userVM.let {
                b -> b.getOneUser(name, pw)

            b.user.observe(this, Observer { a ->
                a?.let {

                    if (a.userType == "driver") {
                        val a = LoginFragmentDirections.actionLoginFragmentToDriverProfile(name, a.idNo)
                        Navigation.findNavController(view).navigate(a)

                    } else if (a.userType == "traveller") {
                        val b = LoginFragmentDirections.actionLoginFragmentToUserProfile(name, a.idNo)
                        Navigation.findNavController(view).navigate(b)

                    }
                } })
        }
    }*/
    fun userLogin2(view:View,name:String,pw:String){
        if(connected()){
            Toast.makeText(activity,"ConnectionCreated",Toast.LENGTH_LONG).show()
            userViewModel.let {
                    b->b.getUserByName(name)
                b.gUser.observe(this, Observer { response->
                    response.body().run {

                        // b = LoginFragmentDirections.actionLoginFragmentToUserProfile(this?.userName.toString(), this?.idNo.toString())
                      // Navigation.findNavController(view).navigate(b)
                        if (this?.password == pw) {
                            if (this?.userType == "driver") {
                                val a =
                                    LoginFragmentDirections.actionLoginFragmentToDriverProfile(this.userName, this.idNo)
                                Navigation.findNavController(view).navigate(a)

                            } else if (this?.userType == "traveller") {
                                val b =
                                    LoginFragmentDirections.actionLoginFragmentToUserProfile(this.userName, this.idNo)
                                Navigation.findNavController(view).navigate(b)

                            }
                        }

                    }


                })

            }

        }



    }
    private fun connected():Boolean {

        val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }
    





}
