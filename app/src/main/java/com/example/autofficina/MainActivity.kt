package com.example.autofficina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.room.Room
import com.example.autofficina.database.DatabaseOfficina
import com.example.autofficina.fragments.ListaClienti


class MainActivity : AppCompatActivity() {
    private lateinit var nav: NavController

    // Override del metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Imposta il layout dell'activity
        setContentView(R.layout.activity_main)

        //database livedatatest

        val db = Room.databaseBuilder(applicationContext, DatabaseOfficina::class.java, "database_officina").build()

        val daoClienti = db.clienteDao()
        val daoVeicoli = db.veicoloDao()
        val daoInterventi = db.interventoDao()
            // Aggiorna la vista con i nuovi dati
     //   })
        // crea un'istanza del database
      //  val db = DatabaseOfficina.getDatabase(applicationContext)
      //  ServiziClienti.setDao(db.getClientDao())
      //  ServiziVeicoli.setDao(db.getJobDao())
      //  ServiziIntervento.setDao(db.getVehicleDao())

        // Ottiene il NavHostFragment dal FragmentManager
        val host =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        // Ottiene il NavController dal NavHostFragment
        nav = host.navController
    }


}


