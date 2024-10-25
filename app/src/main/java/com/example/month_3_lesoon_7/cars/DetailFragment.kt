package com.example.month_3_lesoon_7.cars

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.month_3_lesoon_7.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    private val REQUEST_CALL_PHONE = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val car = arguments?.getSerializable("car") as Car
            car?.let { car ->
                modelOfCar.text = car.model
                costOfCar.text = "$" + car.cost
                Glide.with(imageOfCars).load(car.image).into(imageOfCars)
                descOfCar.text = car.desc
                numb.text = "+996 "+car.numb.toString()

                call.setOnClickListener {
                    if (ContextCompat.checkSelfPermission(
                            requireContext(),
                            Manifest.permission.CALL_PHONE
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            requireActivity(),
                            arrayOf(Manifest.permission.CALL_PHONE),
                            REQUEST_CALL_PHONE
                        )
                    } else {
                        makePhoneCall(car.numb.toString())
                    }
                }


                WA.setOnClickListener {
                    var numb = "+996"+car.numb.toString()
                    val url = "https://api.whatsapp.com/send?phone=${numb}&text= я за интересован в ${car.model}${car.desc}"
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(url)
                        setPackage("com.whatsapp")
                    }
                    try {
                        startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(requireContext(), "WhatsApp не установлен или произошла ошибка", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun makePhoneCall(number: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:+996$number")
        startActivity(intent)
    }

    // Handle the permission request result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CALL_PHONE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permission granted, make the phone call
                makePhoneCall(binding.numb.text.toString())
            } else {
                // Permission denied, show a message or handle the error
                Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}