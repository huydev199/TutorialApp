package com.example.tutorialapp.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tutorialapp.R
import com.example.tutorialapp.fragment.HomeFragment
import com.example.tutorialapp.fragment.ProfileFragment
import com.example.tutorialapp.fragment.ShopFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val firstFragment = HomeFragment()
        val shopFragment = ShopFragment()
        val profileFragment = ProfileFragment()
        setCurrentFragment(firstFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.shop -> setCurrentFragment(shopFragment)
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }

//        when(it.itemId){
//            R.id.home->setCurrentFragment(firstFragment)
//            R.id.person->setCurrentFragment(secondFragment)
//            R.id.settings->setCurrentFragment(thirdFragment)
//
//        }
//        true

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}