package com.example.redpill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.redpill.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.bottomNav?.setOnNavigationItemSelectedListener(this)
        binding?.bottomNav?.selectedItemId = R.id.homeItemBN
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.homeItemBN -> supportFragmentManager.beginTransaction().replace(R.id.content, HomeFragment()).commit()
            R.id.accountItemBN -> supportFragmentManager.beginTransaction().replace(R.id.content, AccountFragment()).commit()
            R.id.settingsItemBN -> supportFragmentManager.beginTransaction().replace(R.id.content, SettingsFragment()).commit()
        }
        return true
    }
}