package com.example.busstation

import android.content.res.Configuration
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.busstation.data.User
import com.example.busstation.viewmodel.UserVM

class MainActivity : AppCompatActivity(),LoginFragment.OnSignupButtonClicked,
    UserRegistration.OnRegisterButtonClicked,
    NavigationView.OnNavigationItemSelectedListener {
    private  lateinit var  userVM:UserVM



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        ///-------------------------------/////////
        userVM = ViewModelProviders.of(this).get(UserVM::class.java)
        val loginFragment = LoginFragment()
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame,loginFragment)
                .commit()
       }

         ///////--------------------------------/////////////
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> { }
            R.id.nav_gallery -> { }
            R.id.nav_slideshow -> { }
            R.id.nav_tools -> { }
            R.id.nav_share -> { }
            R.id.nav_send -> { }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }



    override fun onRegisterButtonClicked(user:User) {
        userVM.insertUser(user)
        // back to login
        val backtologin = LoginFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, backtologin)
            .commit()

    }

    override fun onSignupButtonClicked() {
        val register = UserRegistration()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, register)
                .commit()
        }

    }

   override fun onLogninButtonClicked(activUser:String,userType:String) {
       if (userType == "driver"){
           val driverPro =  DriverProfile.getInstance(activUser)
           if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
               supportFragmentManager.beginTransaction()
                   .replace(R.id.main_frame, driverPro)
                   .addToBackStack(null)
                   .commit()

           }

   }
       else {
           val travellerPro = UserProfile.getInstance(activUser)
           if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
               supportFragmentManager.beginTransaction()
                   .replace(R.id.main_frame, travellerPro)
                   .addToBackStack(null)
                   .commit()

           }

       }



    }





}
