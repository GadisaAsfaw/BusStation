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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.busstation.data.Driver
import com.example.busstation.data.User
import com.example.busstation.viewmodel.DriverVM
import com.example.busstation.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_driver_basic_info.view.*


class DriverBasicInfo : Fragment() {
    private lateinit var addInfoBtn:Button
    private lateinit var licenseNoET:EditText
    private lateinit var carVinET:EditText
    private lateinit var carSideNoET:EditText
    private lateinit var seatNoET:EditText
    private lateinit var accNoET:EditText
    private lateinit var activeUserName:String
    private lateinit var user:User
    private lateinit var userVM: UserVM
    private lateinit var driveVM:DriverVM

    private lateinit var listner:OnDriverBasicInfoClicked
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnDriverBasicInfoClicked){listner = context}
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_driver_basic_info, container, false)
        addInfoBtn = view.add_info_btn
        licenseNoET = view.license_no_et
        carVinET = view.car_vin_et
        carSideNoET = view.car_side_no_et
        seatNoET = view.seat_no_et
        accNoET = view.acc_no_et
        /////
        userVM =  this.activity?.let { ViewModelProviders.of(it).get(UserVM::class.java) }!!
        driveVM = this.activity?.let { ViewModelProviders.of(it).get(DriverVM::class.java) }!!
        /////
        activeUserName = arguments?.getString("active") as String
        Toast.makeText(activity,"name:"+activeUserName,Toast.LENGTH_LONG).show()

        addInfoBtn.setOnClickListener {
            updateDriver(activeUserName)
            //listner.OnAddBasicInfoBtnClicked()
             }
        return view
    }

    fun updateDriver(name:String){
        userVM.allUsers.observe(this, Observer {
                a->a?.let {
            for(i: User in a){
                if(i.userName == name ){
                    user = i
                    Toast.makeText(activity,"user exist"+i.userName+i.password+i.userType, Toast.LENGTH_LONG).show()
                   // listener.onLogninButtonClicked(i.userName,i.userType)
                    listner.OnAddBasicInfoBtnClicked(
                        Driver(i.userName,i.password,i.idNo,
                            licenseNoET.text.toString(),carVinET.text.toString(),
                            carSideNoET.text.toString().toInt(),seatNoET.text.toString().toInt(),accNoET.text.toString())
                    )

                }


            }
        }
        })
    }


    companion object{
        fun getInstance(username:String):DriverBasicInfo{
            val fragment = DriverBasicInfo()
            val bundle = Bundle()
            bundle.putString("active",username)
            fragment.arguments = bundle
            return  fragment
        }
    }

    interface OnDriverBasicInfoClicked{
        fun OnAddBasicInfoBtnClicked(driver:Driver)

    }


}
