/*package com.example.autofficina.servizi

import com.example.autofficina.dao.DaoVeicoli

import com.example.autofficina.entities.Veicolo
import java.util.concurrent.Executors

// Per eseguire il salvataggio e il recupero dei dati dal database,
// vengono utilizzati gli Executors, che creano un thread separato
// per eseguire il codice in modo asincrono rispetto al thread principale dell'applicazione.

object ServiziVeicoli : IServiziVeicoli {
    private lateinit var DaoVeicoli: DaoVeicoli

    // viene utilizzato per impostare il DAO per la gestione dei veicoli.
    override fun setDao(dao: DaoVeicoli) {
        DaoVeicoli = dao
    }

    // viene utilizzato per aggiungere un nuovo veicolo nel database.
    override fun aggiungiVeicolo(veicolo: Veicolo) {
        Executors.newSingleThreadExecutor().execute {
            DaoVeicoli.salva(veicolo)
        }
    }

    // viene utilizzato per ottenere tutti i veicoli dal database e restituirli come una lista.
    override fun tuttiVeicoli(): List<Veicolo> {
        var data: List<Veicolo>? = null
        Executors.newSingleThreadExecutor().execute {
            data = ServiziVeicoli.tuttiVeicoli()
        }
        return data ?: listOf(Veicolo(0, "", "", "", "", 0))

    }
}
*/