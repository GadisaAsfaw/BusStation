package com.example.busstation


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_driver_basic_info.view.*


class DriverBasicInfo : Fragment() {
    private lateinit var addInfoBtn:Button

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


        addInfoBtn.setOnClickListener {  listner.OnAddBasicInfoBtnClicked()}
        return view
    }

    interface OnDriverBasicInfoClicked{
        fun OnAddBasicInfoBtnClicked()

    }


}
