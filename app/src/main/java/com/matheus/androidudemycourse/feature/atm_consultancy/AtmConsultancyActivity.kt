package com.matheus.androidudemycourse.feature.atm_consultancy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.matheus.androidudemycourse.R
import com.matheus.androidudemycourse.databinding.ActivityAtmConsultancyBinding

class AtmConsultancyActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAtmConsultancyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtmConsultancyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.aapBarMainAtm.toolbarAtm)

        binding.aapBarMainAtm.fab.setOnClickListener {
            sendEmail()
        }

        val navController = findNavController(R.id.nav_host_atm_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_atm_main,
                R.id.nav_services_atm,
                R.id.nav_clients_atm,
                R.id.nav_contact_atm,
                R.id.nav_about_atm,
                R.id.nav_atm_exit
            ), binding.drawerLayoutAtm
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.navAtmView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.nav_atm_exit) {
                finish()
            } else {
                NavigationUI.onNavDestinationSelected(menuItem, navController)
            }
            binding.drawerLayoutAtm.closeDrawer(GravityCompat.START)
            true
        }

    }

    private fun sendEmail() {
        val email = "contact.matheus.mendes@gmail.com"
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem Automatica")
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, getString(R.string.share)))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.atm, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_atm_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}