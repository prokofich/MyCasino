package com.example.mycasino.view

import android.annotation.SuppressLint
import android.os.Bundle
import com.bumptech.glide.Glide
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.mycasino.*
import kotlinx.android.synthetic.main.fragment_guess_the_kard.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GuessTheKardFragment : Fragment() {

    private var hiddenCard = ""
    private var correctAnswer = 0
    private var currentLevel = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guess_the_kard, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadZnakQuestion()
        id_guess_title_record.text = "your record: ${MAIN.getRecordGuessCard()}"

        id_guess_button_start.setOnClickListener {
            id_guess_title_message.text = "level ${currentLevel}/10"
            loadObratnayaKarta()
            id_guess_title_record.isVisible = false
            loadPicturesMasti()
            hiddenCard = listMasti.shuffled()[1]
            id_guess_button_start.isVisible = false
            id_guess_correct_answers.isVisible = true
            id_guess_correct_answers.text = "correct:0 , my cash: ${MAIN.getMyCash()}"
            Toast.makeText(requireContext(),"The game has started",Toast.LENGTH_SHORT).show()
        }


        id_guess_image_piki.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                checkAnswer()
            }
            if(hiddenCard == PIKI){
                addCorrectAnswer()
            }else{
                Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
            }
            currentLevel+=1
            id_guess_title_message.text = "level ${currentLevel}/10"
            checkFinish()
        }

        id_guess_image_kresti.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                checkAnswer()
            }
            if(hiddenCard == KRESTI){
                addCorrectAnswer()
            }else{
                Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
            }
            currentLevel+=1
            id_guess_title_message.text = "level ${currentLevel}/10"
            checkFinish()
        }

        id_guess_image_bubni.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                checkAnswer()
            }
            if(hiddenCard == BUBNI){
                addCorrectAnswer()
            }else{
                Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
            }
            currentLevel+=1
            id_guess_title_message.text = "level ${currentLevel}/10"
            checkFinish()
        }

        id_guess_image_chervi.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
               checkAnswer()
            }
            if(hiddenCard == CHERVI){
                addCorrectAnswer()
            }else{
                Toast.makeText(requireContext(),"you didn't guess",Toast.LENGTH_SHORT).show()
            }
            currentLevel+=1
            id_guess_title_message.text = "level ${currentLevel}/10"
            checkFinish()
        }






    }

    private fun loadPicturesMasti(){
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/masti_bubi.png")
            .into(id_guess_image_bubni)
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/masti_chervi.png")
            .into(id_guess_image_chervi)
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/masti_kresti.png")
            .into(id_guess_image_kresti)
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/masti_piki.png")
            .into(id_guess_image_piki)
    }
    private fun loadZnakQuestion(){
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/znak_question1.png")
            .into(id_guess_image_card)
    }
    private fun loadObratnayaKarta(){
        Glide.with(requireContext())
            .load("http://37.27.9.28/8/obratnaya_storona.png")
            .into(id_guess_image_card)
    }

    private fun loadRandomCard(){
        when(hiddenCard){
            BUBNI -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/8/${listBubi.shuffled()[1]}")
                    .into(id_guess_image_card)
            }
            KRESTI -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/8/${listKresti.shuffled()[1]}")
                    .into(id_guess_image_card)
            }
            CHERVI -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/8/${listChervi.shuffled()[1]}")
                    .into(id_guess_image_card)
            }
            PIKI -> {
                Glide.with(requireContext())
                    .load("http://37.27.9.28/8/${listPiki.shuffled()[1]}")
                    .into(id_guess_image_card)
            }
        }
    }

    private fun checkRecord(){
        if(correctAnswer > MAIN.getRecordGuessCard()){
            MAIN.setRecordGuessCard(correctAnswer)
            Toast.makeText(requireContext(),"you have broken the previous record(${correctAnswer})",Toast.LENGTH_SHORT).show()
        }
    }


    private fun addCorrectAnswer(){
        MAIN.addCash(5)
        correctAnswer+=1
        id_guess_correct_answers.text = "correct: $correctAnswer, my cash: ${MAIN.getMyCash()}"
        Toast.makeText(requireContext(),"you guessed right",Toast.LENGTH_SHORT).show()
    }


    private fun checkFinish(){
        if (currentLevel==10){
            checkRecord()
            loadZnakQuestion()
            id_guess_image_chervi.setImageResource(0)
            id_guess_image_bubni.setImageResource(0)
            id_guess_image_kresti.setImageResource(0)
            id_guess_image_piki.setImageResource(0)
            currentLevel = 1
            hiddenCard = ""
            correctAnswer = 0
            id_guess_button_start.isVisible = true
            id_guess_correct_answers.isVisible = false
            id_guess_title_message.text = "choose the suit of the playing card"
        }
    }

    private  suspend fun checkAnswer(){
        loadRandomCard()
        delay(3000)
        loadObratnayaKarta()
        hiddenCard = listMasti.shuffled()[1]
    }


}