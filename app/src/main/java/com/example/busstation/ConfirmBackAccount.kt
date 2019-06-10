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
import com.example.busstation.data.Driver
import kotlinx.android.synthetic.main.fragment_bank_account_confirm.view.*
import kotlinx.android.synthetic.main.fragment_confirm_back_account.view.*
import kotlinx.android.synthetic.main.fragment_confirm_back_account.view.acc_confirm_btn
import kotlinx.android.synthetic.main.fragment_confirm_back_account.view.acc_password_et


class ConfirmBackAccount : Fragment() {
   private lateinit var   confirmAccountNoET:EditText
    private lateinit var  confirmAccountPwET:EditText
    private lateinit var  confirmAcountBtn:Button
    private lateinit var listner:OnConfirmAccountBtnClicked

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnConfirmAccountBtnClicked){listner = context}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view =inflater.inflate(R.layout.fragment_confirm_back_account, container, false)
        confirmAccountNoET = view.acc_conf_no_et
        confirmAccountPwET = view.acc_password_et
        confirmAcountBtn = view.acc_confirm_btn

        confirmAcountBtn.setOnClickListener {
            listner.onConfirmBtnClicked(confirmAccountNoET.text.toString(),confirmAccountPwET.text.toString())
        }


        return view
    }

    interface OnConfirmAccountBtnClicked{
        fun onConfirmBtnClicked(accNo:String,accPassword:String)
    }


}
