package com.example.busstation


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.busstation.data.TransportInfo
import com.example.busstation.databinding.FragmentDriverBuyTicketBinding
import com.example.busstation.viewmodel.TranspInfoviewmodel
import com.example.busstation.viewmodel2.TransportInfoViewModel
import kotlinx.android.synthetic.main.fragment_driver_buy_ticket.view.*
import java.text.SimpleDateFormat
import java.util.*


class DriverBuyTicket : Fragment() {
    private lateinit var dateValue:String
    private lateinit var timeValue:String

    private lateinit var transpInfoVM: TranspInfoviewmodel
    private lateinit var transportInfoViewModel:TransportInfoViewModel

    private lateinit var activeUid:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentDriverBuyTicketBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_driver_buy_ticket,container,false)
        transpInfoVM = this.activity?.let { ViewModelProviders.of(it).get(TranspInfoviewmodel::class.java) }!!
        transportInfoViewModel= this.activity?.let { ViewModelProviders.of(it).get(TransportInfoViewModel::class.java) }!!

        activeUid = arguments?.getString("userid") as String
        Toast.makeText(activity,"UID"+activeUid,Toast.LENGTH_LONG).show()

        binding.datePickerBtn.setOnClickListener {  setDate()
           // Toast.makeText(activity,"date"+dateValue,Toast.LENGTH_LONG).show()
        }
        binding.timePickerBtn.setOnClickListener {
            //  Toast.makeText(activity,"date"+dateValue,Toast.LENGTH_LONG).show()
            setTime()
        }

       // binding.buyBtn.setOnClickListener { buyTicket(binding) }
        binding.buyBtn.setOnClickListener { buyTicket2(binding) }
        
        return binding.root
    }

    fun buyTicket(binding: FragmentDriverBuyTicketBinding){
        // for now i used driver id statically
        val transportInfo = TransportInfo(binding.startEt.text.toString(),
                                          binding.destinationEt.text.toString(),
                                           dateValue,timeValue,activeUid)
        transpInfoVM.insertInfo(transportInfo)
        Toast.makeText(activity,"TransportInfo added"+dateValue+"----"+timeValue,Toast.LENGTH_LONG).show()
        clearFields(binding)
    }
    //Remote
    fun buyTicket2(binding: FragmentDriverBuyTicketBinding){
        // for now i used driver id statically
        val transportInfo = com.example.busstation.data2.TransportInfo(binding.startEt.text.toString(),
            binding.destinationEt.text.toString(),
            dateValue,timeValue,activeUid)
        transportInfoViewModel.let { tivm->tivm.insertInfo(transportInfo) }
        Toast.makeText(activity,"TransportInfo addedRemotly",Toast.LENGTH_LONG).show()
        clearFields(binding)
    }



    fun setDate(){
   // val formate = SimpleDateFormat("dd MM YYYY",Locale.US)//Month in number
    val formate = SimpleDateFormat("dd MMM YYYY",Locale.US)

   val now = Calendar.getInstance()
    val datePicker = DatePickerDialog(activity,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        val selectedDate = Calendar.getInstance()
        selectedDate.set(Calendar.YEAR,year)
        selectedDate.set(Calendar.MONTH,month)
        selectedDate.set(Calendar.DAY_OF_YEAR,dayOfMonth)
        dateValue = formate.format(selectedDate.time).toString()
        //Toast.makeText(activity,"date"+dateValue,Toast.LENGTH_LONG).show()


    }, now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_YEAR)

        )
    datePicker.show()

    
}
    fun setTime(){
     val now = Calendar.getInstance()
        val formate =  SimpleDateFormat("hh:MM a",Locale.US)
        val selectedTime = Calendar.getInstance()
        val timePicker = TimePickerDialog(activity,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
            selectedTime.set(Calendar.MINUTE,minute)
            timeValue = formate.format(selectedTime.time).toString()
           // Toast.makeText(activity,"time"+timeValue,Toast.LENGTH_LONG).show()

        },
            now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),false

            )
        timePicker.show()


    }
    fun clearFields(binding: FragmentDriverBuyTicketBinding){
        binding.startEt.setText("")
        binding.destinationEt.setText("")

    }







}

