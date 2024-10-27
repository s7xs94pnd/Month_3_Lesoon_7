package com.example.month_3_lesoon_7.cars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.month_3_lesoon_7.databinding.ItemCarCardsBinding

class CarsAdapter(var carArr:ArrayList<Car>, var onClick:(position:Int)->Unit): RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {


   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {

       val binding = ItemCarCardsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CarsViewHolder(binding)
       }



    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {

        holder.onBind(carArr[position])

        holder.itemView.setOnClickListener{

            onClick(position)
        }
    }


    override fun getItemCount(): Int {
        return carArr.size
    }


    inner class CarsViewHolder(val binding: ItemCarCardsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(car: Car){

            binding.apply {

                costOfCar.text="$"+car.cost.toString()

                modelOfCar.text=car.model

                Glide.with(imageOfCars).load(car.image).into(imageOfCars)
            }
        }
    }

}