package com.tim.weatherobserver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tim.weatherobserver.Fragments.DetailsFragment
import com.tim.weatherobserver.Fragments.HomeFragment
import com.tim.weatherobserver.Fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsFragment = SettingsFragment()
        val homeFragment = HomeFragment()
        val detailsFragment = DetailsFragment()

        makeCurrentFragment(settingsFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.selectedItemId = R.id.ic_settings

        bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){

                R.id.ic_settings -> makeCurrentFragment(settingsFragment)
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_detail -> makeCurrentFragment(detailsFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}