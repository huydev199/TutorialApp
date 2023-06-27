package com.example.tutorialapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorialapp.R
import com.example.tutorialapp.fragment.AboveFragment
import com.example.tutorialapp.fragment.BellowFragment


class CommunicationActivity : AppCompatActivity(), AboveFragment.TextClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communication)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment1, AboveFragment())
            .commit()

        val bellowFragment = supportFragmentManager.beginTransaction()
            .add(R.id.fragment2, BellowFragment())
            .commit()
    }

    override fun sendText(text: String?) {

        val bellowFragment =
            getSupportFragmentManager().findFragmentById(R.id.fragment2) as? BellowFragment
        if (text != null) {
            bellowFragment?.updateBellowText(text)
        }
    }

}