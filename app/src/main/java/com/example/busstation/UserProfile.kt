package com.example.busstation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.busstation.data.User
import com.example.busstation.databinding.FragmentUserProfileBinding
import kotlinx.android.synthetic.main.fragment_user_profile.view.*


class UserProfile : Fragment() {

    private lateinit var activeUid:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentUserProfileBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_user_profile,container,false)

        binding.aUserTv.text   = arguments?.getString("username") as String
        activeUid = arguments?.getString("userid") as String


      binding.buyTicketBtn.setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_userProfile_to_selectDestination,null)
            val selectDest = UserProfileDirections.actionUserProfileToSelectDestination(activeUid)
            Navigation.findNavController(binding.root).navigate(selectDest)
        }
        return binding.root
    }


}
