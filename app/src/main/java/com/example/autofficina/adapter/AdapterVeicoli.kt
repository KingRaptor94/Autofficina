package com.example.autofficina.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.entities.Veicolo


class AdapterVeicoli(private val ctx: Context, private val data: List<Veicolo>) : RecyclerView.Adapter<AdapterVeicoli.ViewHolder>() {

    // ViewHolder interno alla classe AdapterVeicoli
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Dichiarazione degli elementi della view da popolare
        private val numeroTelaioView: TextView =v.findViewById(R.id.numeroTelaioVeicolo)
        private val marcaView: TextView =v.findViewById(R.id.marcaVeicolo)
        private val modelloView: TextView =v.findViewById(R.id.modelloVeicolo)
        private val targaView: TextView =v.findViewById(R.id.targaVeicolo)

        // Metodo per popolare la view con i dati del veicolo
        fun mostraVeicolo(veicolo: Veicolo){
            numeroTelaioView.text = veicolo.numeroTelaio
            marcaView.text = veicolo.marca
            modelloView.text = veicolo.modello
            targaView.text = veicolo.targa
        }
    }

    // Metodo che viene chiamato per creare una nuova view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(ctx).inflate(R.layout.veicolo_singolo, parent, false)
        )

    // Metodo che restituisce la dimensione della lista di veicoli da visualizzare
    override fun getItemCount(): Int = data.size

    // Metodo chiamato per associare i dati ad una view holder specifica
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mostraVeicolo(data[position])
    }
}