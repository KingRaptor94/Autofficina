package com.example.autofficina.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

// Indica che la classe rappresenta una tabella nel database con nome "Cliente"
@Entity(
    tableName = "Cliente"
)

data class Cliente(

    // Indica che l'id è una chiave primaria generata automaticamente
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val nome: String,

    val cognome: String,

    val email: String
)