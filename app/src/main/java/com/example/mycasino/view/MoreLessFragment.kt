package com.example.mycasino.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.mycasino.*
import kotlinx.android.synthetic.main.fragment_guess_the_kard.*
import kotlinx.android.synthetic.main.fragment_more_less.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MoreLessFragment : Fragment() {

    var currentLevel = 1
    var hiddenCard = ""
    var numberHiddenCard = 0

    var myCard = ""
    var myNumberCard = 0

    var correctAnswer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more_less, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadZnakQuestion()
        id_moreless_title_record.text = "your record: ${MAIN.getRecordMorelessCard()}"

        id_moreless_button_start.setOnClickListener {
            //игра началась
            id_moreless_title_record.isVisible = false
            id_moreless_button_bigger.isVisible = true
            id_moreless_button_smaller.isVisible = true
            id_moreless_button_start.isVisible = false
            id_moreless_correct_answers.isVisible = true
            id_moreless_correct_answers.text = "correct: 0,my cash: ${MAIN.getMyCash()}$"
            loadHiddenCard()
        }

        id_moreless_button_bigger.setOnClickListener {
            if(myNumberCard>numberHiddenCard){
                correctAnswer+=1
                CoroutineScope(Dispatchers.Main).launch {
                    correctAnswer()
                }
            }else{
                CoroutineScope(Dispatchers.Main).launch {
                    notCorrectAnswer()
                }
            }
            currentLevel+=1
            id_moreless_correct_answers.text = "correct: $correctAnswer, my cash: ${MAIN.getMyCash()}$"
        }


        id_moreless_button_smaller.setOnClickListener {
            if(myNumberCard<numberHiddenCard){
                correctAnswer+=1
                CoroutineScope(Dispatchers.Main).launch {
                    correctAnswer()
                }
            }else{
                CoroutineScope(Dispatchers.Main).launch {
                    notCorrectAnswer()
                }
            }
            currentLevel+=1
            id_moreless_correct_answers.text = "correct: $correctAnswer, my cash: ${MAIN.getMyCash()}$"
        }

        id_moreless_button_restart.setOnClickListener {
            if(MAIN.getMyCash()>50){
                MAIN.minusCash(50)
                id_moreless_correct_answers.text = "correct: $correctAnswer, my cash: ${MAIN.getMyCash()}$"
                ButtonOn()
                id_moreless_button_restart.isVisible = false
                loadHiddenCard()
            }
            Toast.makeText(requireContext(),"you don't have enough money",Toast.LENGTH_SHORT).show()
        }

    }

    private fun loadZnakQuestion(){
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/znak_question1.png")
            .into(id_moreless_image_card1)
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/znak_question1.png")
            .into(id_moreless_image_card2)
    }

    private fun loadHiddenCard(){
        hiddenCard = listAllCard.shuffled()[1]
        numberHiddenCard = mapAllCard[hiddenCard]!!

        myCard = listAllCard.shuffled()[1]
        myNumberCard = mapAllCard[myCard]!!

        Glide.with(requireContext())
            .load("http://37.27.9.28/8/${hiddenCard}")
            .into(id_moreless_image_card1)
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/obratnaya_storona.png")
            .into(id_moreless_image_card2)
    }

    private fun checkRecord(){
        if(correctAnswer > MAIN.getRecordMorelessCard()){
            Toast.makeText(requireContext(),"you have broken the record",Toast.LENGTH_SHORT).show()
            MAIN.setRecordMorelessCard(correctAnswer)
        }
    }

    private fun ButtonOff(){
        id_moreless_button_bigger.isClickable = false
        id_moreless_button_smaller.isClickable = false
    }

    private fun ButtonOn(){
        id_moreless_button_bigger.isClickable = true
        id_moreless_button_smaller.isClickable = true
    }

    private suspend fun correctAnswer(){
        Toast.makeText(requireContext(),"you guessed right",Toast.LENGTH_SHORT).show()
        MAIN.addCash(5)
        loadMyCard()
        delay(3000)
        loadHiddenCard()
    }

    private fun loadMyCard(){
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/${myCard}")
            .into(id_moreless_image_card2)
    }

    private suspend fun notCorrectAnswer(){
        loadMyCard()
        ButtonOff()
        Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
        id_moreless_button_restart.isVisible = true
        checkRecord()
        delay(3000)
    }

}