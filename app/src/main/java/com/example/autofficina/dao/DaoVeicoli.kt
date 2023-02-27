package com.example.autofficina.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.entities.Veicolo

/**
 * Funzionalità necessarie all'applicazione per funzionare.
 */
@Dao
interface DaoVeicoli {



    /**
     * Recupera tutti i veicoli.
     * @return l'elenco dei veicoli desiderati.
     * È annotato con @Query perché verrà utilizzato per effettuare una query al database tramite Room.
     * La query specificata seleziona tutti gli elementi dalla tabella "Veicolo".
     * È dichiarato "suspend" perché questa funzione deve essere eseguita in un thread separato per evitare di bloccare il thread principale dell'app.
     */
    @Query("SELECT * FROM Veicolo ")
    suspend fun tuttiVeicoli(): List<Veicolo>

    /**
     * Salva una persona.
     * @param client i dati della persona da salvare.
     * @return il valore della chiave dell'elemento inserito.
     */
    @Insert
    fun salva(veicolo: Veicolo)



}