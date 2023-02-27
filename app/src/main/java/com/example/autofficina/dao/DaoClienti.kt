package com.example.autofficina.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.entities.Cliente

/**

DAO per l'entità Cliente, necessario all'applicazione per funzionare.

@Dao indica che questa è un'interfaccia DAO (Data Access Object).
 */
@Dao
interface DaoClienti {

    /**

    Recupera tutti i clienti presenti nella tabella "Cliente".
    @return una lista contenente tutti i clienti presenti nella tabella "Cliente".
     */
    @Query("SELECT * FROM Cliente ")
    fun tuttiClienti(): List<Cliente>
    /**

    Salva un nuovo cliente nella tabella "Cliente".
    @param cliente i dati del nuovo cliente da salvare.
    @return il valore della chiave primaria dell'elemento inserito.
     */
    @Insert
    fun salva(cliente : Cliente)

  /*  fun ottieniCliente(id: Long): Cliente*/


}