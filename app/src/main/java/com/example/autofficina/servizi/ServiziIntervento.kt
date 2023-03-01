/*
package com.example.autofficina.servizi

import com.example.autofficina.dao.DaoInterventi
import com.example.autofficina.entities.Intervento
import com.example.autofficina.entities.Veicolo
import java.util.concurrent.Executors


// Per eseguire il salvataggio e il recupero dei dati dal database,
// vengono utilizzati gli Executors, che creano un thread separato
// per eseguire il codice in modo asincrono rispetto al thread principale dell'applicazione.

object ServiziIntervento : IServiziIntervento {
    private lateinit var DaoInterventi: DaoInterventi

    // viene utilizzato per impostare il DAO per la gestione degli interventi.
    override fun setDao(dao: DaoInterventi) {
        DaoInterventi = dao
    }

    // viene utilizzato per aggiungere un nuovo intervento nel database.
    override fun aggiungiIntervento(intervento: Intervento) {
        Executors.newSingleThreadExecutor().execute {
            DaoInterventi.salva(intervento)
        }
    }

    // viene utilizzato per ottenere tutti gli interventi dal database e restituirli come una lista.
    override fun tuttiInterventi(): List<Intervento> {
        var data: List<Intervento>? = null
        Executors.newSingleThreadExecutor().execute {
            data = ServiziIntervento.tuttiInterventi()
        }
        return data ?: listOf(Intervento(0, "", "", "", "", 0))

    }
}
*/
