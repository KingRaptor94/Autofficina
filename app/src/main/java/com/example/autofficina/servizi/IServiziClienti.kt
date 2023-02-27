package com.example.autofficina.servizi

import com.example.autofficina.dao.DaoClienti
import com.example.autofficina.entities.Cliente


interface IServiziClienti {

    // imposta l'oggetto DaoClienti utilizzato per accedere al database
    fun setDao(dao: DaoClienti)

    //  aggiunge un nuovo cliente al database
    fun aggiungiCliente(cliente: Cliente)

    //  restituisce una lista di tutti i clienti presenti nel database
    fun tuttiClienti(): List<Cliente>
}