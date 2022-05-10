package com.example.ui_test_sample.fragmentExample.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ui_test_sample.databinding.FragmentCountryListItemBinding
import com.example.ui_test_sample.fragmentExample.data.Country

class CountriesListAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var binding:FragmentCountryListItemBinding?=null
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Country>() {

        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      binding= FragmentCountryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CountryViewHolder(binding!!, interaction)


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CountryViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Country>) {
        differ.submitList(list)
    }

    class CountryViewHolder(
        private val binding: FragmentCountryListItemBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Country) {

            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            binding.countryName.text = item.name
            Glide.with(itemView)
                .load(item.image)
                .into(binding.countryImage)
            item.small_cities?.let {
                for (index in 0 until it.size) {
                    var appendValue: String = it[index]
                    if (index < (it.size - 1)) {
                        appendValue += ", "
                    }
                    binding.countrySmallCities
                        .append(appendValue)
                }
            }
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Country)
    }
}