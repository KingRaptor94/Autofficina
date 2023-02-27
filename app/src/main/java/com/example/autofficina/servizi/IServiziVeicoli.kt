package com.example.autofficina.servizi


import com.example.autofficina.dao.DaoClienti
import com.example.autofficina.dao.DaoVeicoli
import com.example.autofficina.entities.Cliente
import com.example.autofficina.entities.Veicolo


interface IServiziVeicoli {

    // imposta l'oggetto DaoVeicoli utilizzato per accedere al database
    fun setDao(dao: DaoVeicoli)

    //  aggiunge un nuovo veicolo al database
    fun aggiungiVeicolo(veicolo: Veicolo)

    //  restituisce una lista di tutti i veicoli presenti nel database
    fun tuttiVeicoli(): List<Veicolo>
}


