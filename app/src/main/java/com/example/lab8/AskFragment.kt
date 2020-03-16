package com.example.lab8

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lab8.databinding.FragmentAskBinding


class AskFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentAskBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_ask , container, false
        )



        binding.searchButton.setOnClickListener(){

        }


        
        binding.nextButton.setOnClickListener(){
            view!!.findNavController().navigate(R.id.action_askFragment_to_recyclerFragment)
        }


        return binding.root
    }
}
