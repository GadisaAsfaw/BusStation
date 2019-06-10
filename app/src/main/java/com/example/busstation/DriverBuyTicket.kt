package com.example.busstation


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_driver_buy_ticket.view.*
import java.text.SimpleDateFormat
import java.util.*


class DriverBuyTicket : Fragment() {
    private lateinit var startET:EditText
    private lateinit var destinationET:EditText
    private lateinit var dateBtn:Button
    private lateinit var timeBtn: Button
    private lateinit var buyBtn:Button
    private lateinit var dateValue:String
    private lateinit var timeValue:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =inflater.inflate(R.layout.fragment_driver_buy_ticket, container, false)
        startET = view.start_et
        destinationET = view.destination_et
        dateBtn = view.date_picker_btn
        timeBtn = view.time_picker_btn
        buyBtn = view.buy_btn
        
        dateBtn.setOnClickListener {  setDate()
           // Toast.makeText(activity,"date"+dateValue,Toast.LENGTH_LONG).show()
        }
        timeBtn.setOnClickListener {
            //  Toast.makeText(activity,"date"+dateValue,Toast.LENGTH_LONG).show()
            setTime()
        }
        
        return view
    }


fun setDate(){
    val formate = SimpleDateFormat("dd MMM, YYYY",Locale.US)

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





}

