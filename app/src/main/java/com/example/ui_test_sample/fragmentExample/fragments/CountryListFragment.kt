package com.example.ui_test_sample.fragmentExample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_test_sample.R
import com.example.ui_test_sample.databinding.FragmentBigCitiesBinding
import com.example.ui_test_sample.databinding.FragmentCountryListBinding
import com.example.ui_test_sample.fragmentExample.Adapters.CountriesListAdapter
import com.example.ui_test_sample.fragmentExample.data.Country
import com.example.ui_test_sample.fragmentExample.data.CountryDatasource


class CountryListFragment(   val countryDatasource: CountryDatasource) : Fragment(),
    CountriesListAdapter.Interaction

{

     private var binding:FragmentCountryListBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    lateinit var listAdapter: CountriesListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCountryListBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getData()
    }

    private fun getData(){
        countryDatasource.getCountries()?.let { listAdapter.submitList(it) }
    }

    private fun initRecyclerView() {
        binding?.recyclerView
            ?.apply {
                layoutManager = LinearLayoutManager(activity)
                listAdapter = CountriesListAdapter(this@CountryListFragment)
                adapter = listAdapter
            }


}

    override fun onItemSelected(position: Int, item: Country) {
        activity?.run {
            val bundle = Bundle()
            bundle.putInt("country_id", item.id)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CountryDetailFragment::class.java, bundle)
                .addToBackStack("CountryDetailFragment")
                .commit()
        }
    }
}