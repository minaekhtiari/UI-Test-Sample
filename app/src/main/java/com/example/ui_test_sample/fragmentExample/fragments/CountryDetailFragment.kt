package com.example.ui_test_sample.fragmentExample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.ui_test_sample.R
import com.example.ui_test_sample.databinding.FragmentCountryDetailBinding
import com.example.ui_test_sample.fragmentExample.data.Country
import com.example.ui_test_sample.fragmentExample.data.CountryRemoteDataSource
import java.lang.System.load


class CountryDetailFragment : Fragment() {

    private var _binding: FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            args.getInt("country_id").let { countryId ->
                CountryRemoteDataSource.getCountry(countryId)?.let { contryFromRemote ->
                    country = contryFromRemote

                }
            }
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMovieDetails()
        binding.bigCities.setOnClickListener {
            val bundle = Bundle()
            bundle.putStringArrayList("args_bigCities", country.big_cities)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, BigCitiesFragment::class.java, bundle)
                ?.addToBackStack("BigCitiesFragment")
                ?.commit()
        }

        binding.smallCities.setOnClickListener {
          val bundle=Bundle()
            bundle.putStringArrayList("args_SmallCities",country.small_cities)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, SmallCitiesFragment::class.java,bundle)
                ?.addToBackStack("SmallCitiesFragment")
                ?.commit()
        }
    }

    private fun setMovieDetails(){


        context?.let {
            Glide.with(it)
                .load(country.image.trim()+"?w=430&h=275")
                .into(binding.countryImage)
        }




           binding.countryTitle.text = country.name
            binding.countryDescription.text = country.description
        }
    }




