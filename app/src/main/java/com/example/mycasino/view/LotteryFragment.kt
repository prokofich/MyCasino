package com.example.mycasino.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.mycasino.MAIN
import com.example.mycasino.R
import kotlinx.android.synthetic.main.fragment_lottery.*
import java.time.LocalDate

class LotteryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lottery, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(!checkDay()){
            id_lot_image1.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image2.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image3.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image4.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image5.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image6.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image7.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image8.setBackgroundResource(R.drawable.emblema_zamok)
            id_lot_image9.setBackgroundResource(R.drawable.emblema_zamok)

            id_lot_message.text = "the feature will be available the next day"
            id_lot_title_cash.text = "your money:${MAIN.getMyCash()}$"
        }

        id_lot_title_cash.text = "your money:${MAIN.getMyCash()}$"

        id_lot_image1.setOnClickListener {
            if (checkDay()){
                id_lot_image1.text = randomCash().toString() + "$"
                id_lot_image1.setBackgroundResource(0)
            }
        }
        id_lot_image2.setOnClickListener {
            if (checkDay()){
                id_lot_image2.text = randomCash().toString() + "$"
                id_lot_image2.setBackgroundResource(0)
            }
        }
        id_lot_image3.setOnClickListener {
            if (checkDay()){
                id_lot_image3.text = randomCash().toString() + "$"
                id_lot_image3.setBackgroundResource(0)
            }
        }
        id_lot_image4.setOnClickListener {
            if (checkDay()){
                id_lot_image4.text = randomCash().toString() + "$"
                id_lot_image4.setBackgroundResource(0)
            }
        }
        id_lot_image5.setOnClickListener {
            if (checkDay()){
                id_lot_image5.text = randomCash().toString() + "$"
                id_lot_image5.setBackgroundResource(0)
            }
        }
        id_lot_image6.setOnClickListener {
            if (checkDay()){
                id_lot_image6.text = randomCash().toString() + "$"
                id_lot_image6.setBackgroundResource(0)
            }
        }
        id_lot_image7.setOnClickListener {
            if (checkDay()){
                id_lot_image7.text = randomCash().toString() + "$"
                id_lot_image7.setBackgroundResource(0)
            }
        }
        id_lot_image8.setOnClickListener {
            if (checkDay()){
                id_lot_image8.text = randomCash().toString() + "$"
                id_lot_image8.setBackgroundResource(0)
            }
        }
        id_lot_image9.setOnClickListener {
            if (checkDay()){
                id_lot_image9.text = randomCash().toString() + "$"
                id_lot_image9.setBackgroundResource(0)
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun randomCash():Int{
        var random_cash = listOf<Int>(10,20,30,40,50,100,150,300,500).shuffled()[1]
        MAIN.addCash(random_cash)
        Toast.makeText(requireContext(),"you have won:${random_cash}$",Toast.LENGTH_SHORT).show()
        id_lot_message.text = "the next attempt is possible in 1 day"
        id_lot_title_cash.text = "your money: ${MAIN.getMyCash()}$"
        MAIN.setCurrentDay(LocalDate.now().toString())
        return random_cash
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun checkDay():Boolean{
        return if (LocalDate.now().toString() != MAIN.getLastDay()){
            true
        }else{
            Toast.makeText(requireContext(),"try it the next day",Toast.LENGTH_SHORT).show()
            false
        }
    }


}