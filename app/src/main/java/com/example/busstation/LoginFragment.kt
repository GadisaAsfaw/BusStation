package com.example.busstation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.busstation.data.User
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    private lateinit var userNameET:EditText
    private lateinit var userPasswordET:EditText
    private lateinit var signupTV:TextView
    private lateinit var loginBtn:Button
    private  lateinit var  listener:OnLoginFragBtnsClicked
    private lateinit var userVM:UserVM



    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnLoginFragBtnsClicked){
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        userVM =  this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
        userNameET = view.user_name_et
        userPasswordET =view.user_password_et
        signupTV = view.signup_tv
        loginBtn = view.login_btn

        signupTV.setOnClickListener { listener.onSignupButtonClicked() }
        loginBtn.setOnClickListener {

             userLogin(userNameET.text.toString(),userPasswordET.text.toString())

        }
        return view
    }

    interface OnLoginFragBtnsClicked{
        fun onSignupButtonClicked()
        fun onLogninButtonClicked(activeUser:String,userType:String)
    }
    fun userLogin(name:String,pw:String){

        userVM.allUsers.observe(this, Observer {
                a->a?.let {
            for(i: User in a){
                if(i.userName == name && i.password == pw){

                    Toast.makeText(activity,"user exist"+i.userName+i.password+i.userType, Toast.LENGTH_LONG).show()
                    listener.onLogninButtonClicked(i.userName,i.userType)

                }


            }
        }
        })
    }


}
