package com.example.month_3_lesoon_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.month_3_lesoon_7.databinding.ActivityMainBinding
import com.example.month_3_lesoon_7.cars.CarsShopFragment

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.conFrgCars, CarsShopFragment()).commit()

    }
}