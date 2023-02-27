package com.example.autofficina.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.SET_NULL
import androidx.room.PrimaryKey

// Indica che la classe rappresenta una tabella nel database con nome "Intervento"
@Entity(
    tableName = "Veicolo",
    foreignKeys = [ForeignKey(
        entity = Cliente::class,
        parentColumns = ["id"],
        childColumns=["id_cliente"],
        onDelete = SET_NULL
    )]
)
data class Veicolo(
    // Indica che l'id è una chiave primaria generata automaticamente
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val numeroTelaio: String,
    val marca:String,
    val modello:String,
    val targa:String,
    @ColumnInfo(name = "id_cliente")
    val idCliente: Long?

)