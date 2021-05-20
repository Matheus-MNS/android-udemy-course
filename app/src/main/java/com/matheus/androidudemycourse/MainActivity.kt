package com.matheus.androidudemycourse

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.snackbar.Snackbar
import com.matheus.androidudemycourse.databinding.ActivityMainBinding
import com.matheus.androidudemycourse.feature.atm_consultancy.AtmConsultancyActivity
import com.matheus.androidudemycourse.feature.media_player.activities.MediaPlayerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.appBarMain.toolbar)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home), binding.drawerLayout)

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_atm_consultancy -> {
                    val intent = Intent(this, AtmConsultancyActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_media_player -> {
                    val intent = Intent(this, MediaPlayerActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    NavigationUI.onNavDestinationSelected(menuItem, navController);
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}