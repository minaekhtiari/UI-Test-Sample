package com.example.ui_test_sample.fragmetExample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui_test_sample.databinding.FragmentBigCitiesBinding



class BigCitiesFragment : Fragment() {
    private var _binding: FragmentBigCitiesBinding? = null
    private val binding get() = _binding!!

    private val bigCities: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { it->
            bigCities.addAll(it.get("args_bigCities") as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBigCitiesBinding.inflate(inflater, container, false)
       return binding.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBigCities()
    }

    private fun setBigCities(){
        binding.bigCitiesText
            .text = stringBuilderForBigCities(bigCities)
    }
    companion object{
        fun stringBuilderForBigCities(bigCities: ArrayList<String>): String{
            val sb = StringBuilder()
            for(city in bigCities){
                sb.append(city + "\n")
            }
            return sb.toString()
        }
    }
}