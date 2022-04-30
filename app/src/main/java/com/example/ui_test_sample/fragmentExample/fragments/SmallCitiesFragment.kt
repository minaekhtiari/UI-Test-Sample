package com.example.ui_test_sample.fragmentExample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui_test_sample.R
import com.example.ui_test_sample.databinding.FragmentCountryDetailBinding
import com.example.ui_test_sample.databinding.FragmentSmallCitiesBinding


class SmallCitiesFragment : Fragment() {

    private var _binding: FragmentSmallCitiesBinding? = null
    private val binding get() = _binding!!
    private val smallCities: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {it->
            smallCities.addAll(it.get("args_SmallCities")as List<String>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSmallCitiesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setsmallCities()
    }

    private fun setsmallCities(){
        binding.smallCitiesText
            .text = stringBuilderForSmallCities(smallCities)
    }
    companion object{
        fun stringBuilderForSmallCities(smallCities: ArrayList<String>): String{
            val sb = StringBuilder()
            for(city in smallCities){
                sb.append(city + "\n")
            }
            return sb.toString()
        }
    }
}