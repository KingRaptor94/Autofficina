package com.example.autofficina.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.entities.Cliente

class AdapterClienti(private val ctx: Context,private val data: List<Cliente>) : RecyclerView.Adapter<AdapterClienti.ViewHolder>() {

    /**
     * La classe che gestisce il pattern di ViewHolder.
     * Si tratta di una "inner" class perché deve accedere a membri della classe "outer".
     */
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Inizializzazione delle TextView del layout cliente_singolo
        private val nomeView: TextView=v.findViewById(R.id.nome_editText)
        private val cognomeView: TextView=v.findViewById(R.id.cognome_editText)
        private val emailView: TextView=v.findViewById(R.id.email_editText)

        // Metodo che popola le TextView con i dati del cliente passato come parametro
        fun mostraCliente(cliente: Cliente){
            nomeView.text = cliente.nome
            cognomeView.text = cliente.cognome
            emailView.text = cliente.email
        }
    }

    // Override della funzione onCreateViewHolder che crea una nuova istanza di ViewHolder
// e collega la vista associata ad ogni oggetto del dataset.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClienti.ViewHolder =
        ViewHolder(
            LayoutInflater.from(ctx).inflate(R.layout.cliente_singolo, parent, false)
        )

    // Override della funzione getItemCount che ritorna la dimensione del dataset.
    override fun getItemCount(): Int = data.size

    // Override della funzione onBindViewHolder che associa ogni oggetto del dataset con il relativo ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mostraCliente(data[position])
    }
}