package com.example.playground.carousel.customview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.playground.databinding.CarouselItemViewBinding

class CarouselAdapter(private val list: List<String>) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val binding = CarouselItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarouselViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = list[position]
        holder.carouselView.message.text = item
    }

    override fun getItemCount(): Int = list.size

    class CarouselViewHolder(val carouselView: CarouselItemViewBinding) : RecyclerView.ViewHolder(carouselView.root)
}