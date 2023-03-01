
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


@Database(
    entities = [Cliente::class, Veicolo::class, Intervento::class],
    version = 1,
    exportSchema = false
)

abstract class DatabaseOfficina : RoomDatabase() {
    abstract fun clienteDao(): DaoClienti
    abstract fun veicoloDao(): DaoVeicoli
    abstract fun interventoDao(): DaoInterventi

    companion object {
        @Volatile
        private var INSTANCE: DatabaseOfficina? = null

        fun getDatabase(context: Context): DatabaseOfficina {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseOfficina::class.java,
                    "database_officina"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}