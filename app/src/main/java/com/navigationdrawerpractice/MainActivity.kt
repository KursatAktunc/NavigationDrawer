package com.navigationdrawerpractice

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import com.google.android.material.elevation.SurfaceColors
import com.navigationdrawerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val color = SurfaceColors.SURFACE_2.getColor(this)
        window.statusBarColor = color   //Status Bar Rengini Material3 tema rengi ile eşitleme
        window.navigationBarColor = color   //Alt Kısımdaki Navigaston Nutonlarının Rengini Material3 tema rengi ile eşitleme

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupNavigationDrawer()
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_item -> Toast.makeText(
                    applicationContext,
                    "Clicked Search",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            menuItem.isChecked = true
            binding.drawerLayout.close()
            true
        }
    }

    private fun setupNavigationDrawer() {
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // Add menu items without overriding methods in the Activity
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                if (actionBarDrawerToggle.onOptionsItemSelected(menuItem))
                    return true
                return true
            }
        })
    }
}