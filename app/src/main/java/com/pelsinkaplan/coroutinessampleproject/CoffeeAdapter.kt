package com.pelsinkaplan.coroutinessampleproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pelsinkaplan.coroutinessampleproject.data.Coffee
import com.pelsinkaplan.coroutinessampleproject.databinding.ItemCoffeeBinding

/**
 * Created by Pelşin KAPLAN on 8.07.2022.
 */
class CoffeeAdapter(var coffees: List<Coffee>) :
    RecyclerView.Adapter<CoffeeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCoffeeBinding.inflate(inflater, parent, false)
        return CoffeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        val coffee = coffees[position]


        holder.binding.apply {
            coffeeTitleTextView.text = coffee.coffeeName
            coffeeDescTextView.text = coffee.coffeeDescription

        }

    }

    override fun getItemCount(): Int {
        return coffees.size
    }

}

class CoffeeViewHolder(val binding: ItemCoffeeBinding) :
    RecyclerView.ViewHolder(binding.root)

