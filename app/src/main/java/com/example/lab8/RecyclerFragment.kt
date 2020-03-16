package com.example.lab8

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lab8.databinding.FragmentRecyclerBinding


class RecyclerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentRecyclerBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_recycler , container, false
        )







        return binding.root
    }
}
