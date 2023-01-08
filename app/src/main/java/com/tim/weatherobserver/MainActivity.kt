package com.tim.weatherobserver

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tim.weatherobserver.Fragments.DetailsFragment
import com.tim.weatherobserver.Fragments.HomeFragment
import com.tim.weatherobserver.Fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsFragment = SettingsFragment()
        val homeFragment = HomeFragment()
        val detailsFragment = DetailsFragment()

        makeCurrentFragment(settingsFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.selectedItemId = R.id.ic_settings

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.ic_settings -> {
                    makeCurrentFragment(settingsFragment)
                    val window = this.window
                    window.statusBarColor = this.resources.getColor(R.color.teal_800)
                    bottomNavigation.setBackgroundResource(R.color.teal_800)
                }
                R.id.ic_home -> {
                    makeCurrentFragment(homeFragment)
                    val window = this.window
                    window.statusBarColor = this.resources.getColor(R.color.blue_dark)
                    bottomNavigation.setBackgroundResource(R.color.blue_dark)
                }
                R.id.ic_detail -> {
                    makeCurrentFragment(detailsFragment)
                    val window = this.window
                    window.statusBarColor = this.resources.getColor(R.color.red_dark)
                    bottomNavigation.setBackgroundResource(R.color.red_dark)
                }
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}