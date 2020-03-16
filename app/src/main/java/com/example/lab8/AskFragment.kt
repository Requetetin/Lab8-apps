package com.example.lab8

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.lab8.Interface.GitHubApi
import com.example.lab8.Interface.Gitapi
import com.example.lab8.Model.User
import com.example.lab8.databinding.FragmentAskBinding
import kotlinx.android.synthetic.main.fragment_ask.*
import kotlinx.android.synthetic.main.fragment_ask.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AskFragment : Fragment() {

    private lateinit var binding: FragmentAskBinding
    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,
                              savedInstanceState: Bundle?):View? {
        val binding: FragmentAskBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_ask , container, false
        )



        binding.searchButton.setOnClickListener(){

            binding.userName = binding.nameEnter.text.toString()
            getUsers()
        }



        binding.nextButton.setOnClickListener(){
            view!!.findNavController().navigate(R.id.action_askFragment_to_recyclerFragment)
        }


        return binding.root
    }

    fun getUsers() {
        var input = nameEnter.getText().toString()
        Gitapi.retrofitService.getUser(input).enqueue(
            object : Callback<User> {
                override fun onFailure(call: Call<User>, t:Throwable){
                    Log.d("Error","Not found")
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    input = response.body()!!.login

                    Glide.with(context!!)
                        .load(response.body()?.avatar_url)
                        .into(binding.userProfile)
                }
            }
        )



    }
}
