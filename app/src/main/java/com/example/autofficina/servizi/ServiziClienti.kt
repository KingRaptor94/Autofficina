/*
package com.example.autofficina.servizi


import com.example.autofficina.entities.Cliente
import com.example.autofficina.dao.DaoClienti
import java.util.concurrent.Executors

//ServiziClienti  implementa l'interfaccia IServiziClienti
object ServiziClienti : IServiziClienti {
    private lateinit var DaoClienti: DaoClienti

    //Il metodo setDao() viene chiamato per impostare l'oggetto DaoClienti,
    // che è utilizzato per interagire con il database.
    override fun setDao(dao: DaoClienti) {
        DaoClienti = dao
    }

    //Il metodo aggiungiCliente() viene chiamato per aggiungere un nuovo cliente al database.
    // Viene utilizzato un Executor per eseguire l'operazione su un thread separato
    // e non bloccare il thread principale.
    override fun aggiungiCliente(cliente: Cliente) {
        Executors.newSingleThreadExecutor().execute {
            DaoClienti.salva(cliente)
        }
    }
    //Il metodo tuttiClienti() viene chiamato per ottenere tutti i clienti presenti nel database.
    // Viene utilizzato un Executor per eseguire l'operazione su un thread separato
    // e non bloccare il thread principale. Se non ci sono dati presenti nel database,
    // viene restituita una lista vuota di Clienti.
    override fun tuttiClienti(): List<Cliente> {
        var data: List<Cliente>? = null
        Executors.newSingleThreadExecutor().execute {
            data = DaoClienti.tuttiClienti()
        }
        return data ?: listOf(Cliente(0, "", "", ""))
    }
*/
/*
    override fun ottieniCLiente(id: Long): Cliente? {
        var data: Cliente? = null
        Executors.newSingleThreadExecutor().execute {
            data = DaoClienti.ottieniCLiente(id)
        }
    }
*//*



    }*/
