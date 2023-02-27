package com.example.autofficina.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.SET_NULL
import androidx.room.PrimaryKey

// Indica che la classe rappresenta una tabella nel database con nome "Intervento"
@Entity(
    tableName = "Intervento",
    foreignKeys = [ForeignKey(
        entity = Veicolo::class,
        parentColumns = ["id"],
        childColumns = ["id_veicolo"],
        onDelete = SET_NULL
    )]
)


data class Intervento(
// Indica che l'id è una chiave primaria generata automaticamente
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val problema: String,
    val oreLavoro: String,
    val oraArrivo: String,
    val oraRitiro: String,
    @ColumnInfo(name = "id_veicolo")
    val idMacchina: Long?,
)