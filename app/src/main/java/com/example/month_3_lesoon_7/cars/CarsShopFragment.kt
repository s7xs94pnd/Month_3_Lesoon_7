package com.example.month_3_lesoon_7.cars

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.month_3_lesoon_7.R
import com.example.month_3_lesoon_7.databinding.FragmentCarsShopBinding
import com.google.android.material.carousel.CarouselLayoutManager


class CarsShopFragment : Fragment() {

    private var carArr = arrayListOf<Car>()

    private lateinit var adapter: CarsAdapter

    private lateinit var binding: FragmentCarsShopBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        binding = FragmentCarsShopBinding.inflate(layoutInflater)
       return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("xxxxxxxxxxxxx", "onViewCreated: ")
        load()
        initAdapter()
    }



    private fun initAdapter() {
        adapter = CarsAdapter(carArr)


        //came from onclick item and give position = index
        { position-> requireActivity().supportFragmentManager.beginTransaction().replace(R.id.conFrgCars,
                DetailFragment().apply { val bundle =Bundle().apply { putSerializable("car", carArr[position]) }
                    arguments = bundle }).addToBackStack(null).commit()
        }


        binding.apply {
            val carulm = CarouselLayoutManager().apply {
                orientation = CarouselLayoutManager.VERTICAL
            }
            rvCars.layoutManager =carulm
            rvCars.adapter = adapter
        }
    }



    private fun load() {
        carArr.add(Car(707020705, "V8 e92", "BMW", 30000, "https://static.mk.ru/upload/entities/2019/08/28/13/articles/facebookPicture/cf/1e/8f/87/47f9c764bffd663585ef6db36934b760.jpg"))
        carArr.add(Car(707020706, "A8", "Audi", 45000, "https://top-tuning.ru/upload/images/catalog/11114/zaschitnaya_plenka_es_dlya_audi_a8_d5_2017_01.jpg"))
        carArr.add(Car(707020707, "Model S", "Tesla", 80000, "https://avatars.mds.yandex.net/get-vertis-journal/4465444/2021-05-14-47b27525b5174474b8ed087f91504cc7.jpg_1622737460443/orig"))
        carArr.add(Car(707020708, "C-Class", "Mercedes", 35000, "https://i.pinimg.com/736x/7b/5f/86/7b5f86f167de236e88703886bc671fa7.jpg"))
        carArr.add(Car(707020709, "Mustang GT", "Ford", 55000, "https://i.pinimg.com/originals/2c/ea/ab/2ceaabc9f21fd80b4322f8ef47a86508.jpg"))
        carArr.add(Car(707020710, "Camaro SS", "Chevrolet", 52000, "https://avatars.dzeninfra.ru/get-zen_doc/9703143/pub_647c6f20a29d5f26c40c911c_647c715269caf1277bea751b/scale_1200"))
        carArr.add(Car(707020711, "911 Carrera", "Porsche", 100000, "https://a.d-cd.net/9QAAAgNQV-A-1920.jpg"))
        carArr.add(Car(707020712, "Challenger", "Dodge", 60000, "https://avatars.mds.yandex.net/i?id=933d63be5d0d828930a5b58d4eaac724_l-5247794-images-thumbs&n=13"))
        carArr.add(Car(707020713, "RX-7", "Mazda", 35000, "https://a.d-cd.net/e0b83b4s-960.jpg"))
        carArr.add(Car(707020715, "488 GTB", "Ferrari", 250000, "https://vehicle.img.symfio.de/1600x,q90/vehicle/H6UK4b/5d1df8557585cd34322d9a61/5f460687dcd740.73760401.jpeg"))
        carArr.add(Car(707020716, "Huracan", "Lamborghini", 220000, "https://autogen.pl/cars/LamboHurPer/78.jpg"))
        carArr.add(Car(707020717, "GTR R35", "Nissan", 100000, "https://i.pinimg.com/originals/8b/61/5a/8b615a3ba026dcb16d31bda1283072f6.jpg"))
        carArr.add(Car(707020718, "M3csl", "BMW", 70000, "https://www.classicdriver.com/sites/default/files/users/33362/cars_images/feed_957542/4cb7b5c47ef8100bc1b771d7503b1dab.jpeg"))
        carArr.add(Car(707020719, "Panamera", "Porsche", 150000, "https://i.pinimg.com/736x/b4/8d/17/b48d17b5a781c8c6de9f962a939a90d7.jpg"))
        carArr.add(Car(707020720, "Aventador", "Lamborghini", 400000, "https://static.tildacdn.com/tild3130-3565-4436-a262-373265303566/254120130919_8Ghdkia.jpg"))
        carArr.add(Car(707020721, "Continental GT", "Bentley", 200000, "https://avatars.mds.yandex.net/i?id=7ee0f9b2e44a711988d95eedceb345df_l-5634817-images-thumbs&n=13"))
        carArr.add(Car(707020722, "Phantom", "Rolls-Royce", 450000, "https://cdn.motor1.com/images/mgl/QE1q1/s1/rolls-royce-phantom-by-spofec.jpg"))
    }

}