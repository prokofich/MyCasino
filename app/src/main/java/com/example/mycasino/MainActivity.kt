package com.example.mycasino

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.mycasino.view.GuessTheKardFragment
import com.example.mycasino.view.LotteryFragment
import com.example.mycasino.view.MoreLessFragment
import com.onesignal.OneSignal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lotteryFragment = LotteryFragment()
    private val guessCardFragment = GuessTheKardFragment()
    private val morelessFragment = MoreLessFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*if(intent.getStringExtra("url")=="nopush"){
            OneSignal.disablePush(true)
        }*/

        MAIN = this

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        replaceFragment(lotteryFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id_menu_lottery ->replaceFragment(lotteryFragment)
                R.id.id_menu_guess_card ->replaceFragment(guessCardFragment)
                R.id.id_menu_card_game ->replaceFragment(morelessFragment)
            }
            true
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

    fun getRecordGuessCard(): Int {
        return getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE).getInt(RECORD_GUESS_CARD, 0)
    }

    fun setRecordGuessCard(record:Int){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        preferences.edit()
            .putInt(RECORD_GUESS_CARD,record)
            .apply()
    }

    fun getRecordMorelessCard():Int{
        return getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE).getInt(RECORD_MORELESS_CARD,0)
    }

    fun setRecordMorelessCard(record:Int){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        preferences.edit()
            .putInt(RECORD_MORELESS_CARD,record)
            .apply()
    }

    fun getLastDay():String{
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE).getString(LAST_DAY,"")
        return preferences ?: ""
    }

    fun setCurrentDay(day:String){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        preferences.edit()
            .putString(LAST_DAY,day)
            .apply()
    }

    fun getMyCash(): Int {
        return getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE).getInt(MY_CASH, 0)
    }



    fun addCash(cash:Int){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE).getInt(MY_CASH,0) + cash
        val pref = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        pref.edit()
            .putInt(MY_CASH,preferences)
            .apply()
    }

    fun minusCash(cash: Int){
        val preferences = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE).getInt(MY_CASH,0) - cash
        val pref = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE)
        pref.edit()
            .putInt(MY_CASH,preferences)
            .apply()
    }

}