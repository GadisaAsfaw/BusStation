package com.example.busstation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.example.busstation.data.User
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_user_registration.view.*


class UserRegistration : Fragment() {
    private  lateinit var userNameET:EditText
    private lateinit var  passwordET:EditText
    private lateinit var  confirmPET:EditText
    private lateinit var  idNoET:EditText
    private lateinit var  submitBtn:Button
    private lateinit var  selectedUserType:RadioGroup
    private lateinit var  driverRB:RadioButton
    private lateinit var  travellerRB:RadioButton
    private lateinit var  userVM: UserVM
    private lateinit var  listner:OnRegisterButtonClicked
    private  lateinit var  selectedRB:RadioButton

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnRegisterButtonClicked){listner = context}

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_user_registration, container, false)
        // userVM = this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!

        driverRB = view.driver_rb
        travellerRB = view.traveller_rb
        selectedUserType = view.user_type_rg
        userNameET =view.u_name_et
        passwordET = view.user_password_et
        confirmPET = view.confirm_p_et
        idNoET = view.id_no_et
        submitBtn = view.submit_btn
        submitBtn.setOnClickListener {


           // Toast.makeText(activity,"selected",Toast.LENGTH_LONG).show()
            //userVM.insertUser(readFields())
            listner.onRegisterButtonClicked(readFields())
        }

        return view
    }

    fun readFields():User{

        if(driverRB.isChecked){
            selectedRB = driverRB
        }
        else{selectedRB = travellerRB}
          //selectedRB.text.toString()
        return User(userNameET.text.toString(),
                    passwordET.text.toString(),
                    idNoET.text.toString(),
                    selectedRB.text.toString()

            )

    }
    fun clearFields(){
        userNameET.setText("")
        passwordET.setText("")
        idNoET.setText("")
    }
    interface  OnRegisterButtonClicked{
        fun onRegisterButtonClicked(user :User)


    }

}
