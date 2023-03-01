package com.example.autofficina.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.autofficina.entities.Cliente


//Definizione interfaccia DAO
@Dao
interface DaoClienti {

    @Query ("SELECT * FROM cliente WHERE id = :id")
    fun ottieniCliente(id: Long): Cliente

    // Il metodo salva()  viene utilizzato per inserire un nuovo oggetto Cliente nel database
    @Insert
    suspend fun salva(cliente: Cliente)

    //ottenere tutti gli oggetti Cliente presenti nel database
    @Query("SELECT * FROM cliente ")
    //LiveData garantisce un aggiornamento reattivo dell'interfaccia utente
    fun tuttiClienti(): LiveData<List<Cliente>>

}