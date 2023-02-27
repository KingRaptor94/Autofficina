package com.example.autofficina.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.autofficina.dao.DaoClienti
import com.example.autofficina.dao.DaoInterventi
import com.example.autofficina.dao.DaoVeicoli
import com.example.autofficina.entities.Cliente
import com.example.autofficina.entities.Intervento
import com.example.autofficina.entities.Veicolo

// Definizione della classe DatabaseOfficina che estende la classe RoomDatabase
@Database(entities = [Cliente::class, Veicolo::class, Intervento::class], version = 1)
abstract class DatabaseOfficina : RoomDatabase() {

    // Dichiarazione dei metodi astratti che ritornano le istanze delle DAO
    abstract fun DaoClienti(): DaoClienti
    abstract fun DaoVeicoli(): DaoVeicoli
    abstract fun DaoInterventi(): DaoInterventi

    // Definizione dell'oggetto companion per la creazione del database
    companion object {
        // Dichiarazione della variabile volatile INSTANCE che rappresenta l'istanza del database
        @Volatile
        private var INSTANCE: DatabaseOfficina? = null

        // Metodo per ottenere l'istanza del database. Se l'istanza esiste già, viene restituita quella,
        // altrimenti viene creata una nuova istanza.
        fun getDatabase(context: Context): DatabaseOfficina {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseOfficina::class.java,
                    "officina_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}