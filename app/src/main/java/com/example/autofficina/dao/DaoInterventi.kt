package com.example.autofficina.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.entities.Intervento


/**
 * Interfaccia DaoInterventi, necessaria per l'applicazione per funzionare.
 * È annotata con @Dao perché Room la utilizzerà per generare automaticamente il codice necessario.
 */
@Dao
interface DaoInterventi {

    /**
     * Recupera tutti gli interventi.
     * @return l'elenco degli interventi desiderati.
     * È annotato con @Query perché verrà utilizzato per effettuare una query al database tramite Room.
     * La query specificata seleziona tutti gli elementi dalla tabella "Intervento".
     * È dichiarato "suspend" perché questa funzione deve essere eseguita in un thread separato per evitare di bloccare il thread principale dell'app.
     */
    @Query("SELECT * FROM Intervento")
    suspend fun tuttiInterventi(): List<Intervento>

    /**
     * Salva un intervento nel database.
     * @param intervento i dati dell'intervento da salvare.
     * @return il valore della chiave dell'elemento inserito.
     * È annotato con @Insert perché verrà utilizzato per inserire un nuovo intervento nella tabella "Intervento".
     */
    @Insert
    fun salva(intervento: Intervento)
}