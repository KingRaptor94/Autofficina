package com.example.autofficina.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.entities.Intervento


class AdapterInterventi(private val ctx: Context, private val data: List<Intervento>) : RecyclerView.Adapter<AdapterInterventi.ViewHolder>() {

    // ViewHolder interno alla classe AdapterInterventi
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Dichiarazione degli elementi della view da popolare
        private val problemaView: TextView =v.findViewById(R.id.problemaIntervento)
        private val oreLavoroView: TextView =v.findViewById(R.id.oreLavoroIntervento)
        private val oraArrivoView: TextView =v.findViewById(R.id.oraArrivoIntervento)
        private val oraRitiroView: TextView =v.findViewById(R.id.oraRitiroIntervento)

        // Metodo per popolare la view con i dati dell'intervento
        fun mostraIntervento(intervento: Intervento){
            problemaView.text = intervento.problema
            oreLavoroView.text = intervento.oreLavoro
            oraArrivoView.text = intervento.oraArrivo
            oraRitiroView.text = intervento.oraRitiro
        }
    }

    // Metodo che viene chiamato per creare una nuova view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(ctx).inflate(R.layout.intervento_singolo, parent, false)
        )

    // Metodo che restituisce la dimensione della lista di interventi da visualizzare
    override fun getItemCount(): Int = data.size

    // Metodo chiamato per associare i dati ad una view holder specifica
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mostraIntervento(data[position])
    }
}