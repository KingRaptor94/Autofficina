package com.example.autofficina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.autofficina.database.DatabaseOfficina

class MainActivity : AppCompatActivity() {
    private lateinit var nav: NavController

    // Override del metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Imposta il layout dell'activity
        setContentView(R.layout.activity_main)

        val db = DatabaseOfficina.getDatabase(applicationContext)
        val clientiDao = db.DaoClienti()
        val veicoliDao = db.DaoVeicoli()
        val interventiDao = db.DaoInterventi()

        // Ottiene il NavHostFragment dal FragmentManager
        val host =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        // Ottiene il NavController dal NavHostFragment
        nav = host.navController
    }


}


