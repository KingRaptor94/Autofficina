package com.example.autofficina.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.entities.Intervento

class AdapterInterventi(private val ctx: Context) : RecyclerView.Adapter<AdapterInterventi.ViewHolder>() {

    private var data: List<Intervento> = mutableListOf()

    // ViewHolder interno alla classe AdapterVeicoli
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Dichiarazione degli elementi della view da popolare

        // Inizializzazione delle TextView del layout intervento_singolo
        private val problemaView: TextView = itemView.findViewById(R.id.problemaIntervento)
        private val oreLovoroView: TextView = itemView.findViewById(R.id.oreLavoroIntervento)
        private val oraArrivo: TextView = itemView.findViewById(R.id.oraArrivoIntervento)
        private val oraRitiro: TextView = itemView.findViewById(R.id.oraRitiroIntervento)
        val veicoloIdView: TextView = itemView.findViewById(R.id.id_veicolo)

        // Metodo che popola le TextView con i dati dell'intervento passato come parametro
        fun mostraIntervento(intervento: Intervento) {
            problemaView.text = intervento.problema
            oreLovoroView.text = intervento.oreLavoro
            oraArrivo.text = intervento.oraArrivo
            oraRitiro.text = intervento.oraRitiro
        }
    }

    // Metodo che viene chiamato per creare una nuova view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.intervento_singolo, parent, false))

    // Metodo che restituisce la dimensione della lista di interventi da visualizzare
    override fun getItemCount(): Int = data.size

    // Metodo chiamato per associare i dati ad una view holder specifica
    override fun onBindViewHolder(holder: AdapterInterventi.ViewHolder, position: Int) {
        val interventoCorrente = data[position]
        holder.mostraIntervento(interventoCorrente)
        holder.veicoloIdView.text = "ID Veicolo: ${interventoCorrente.idVeicolo}"
    }

    // Metodo che aggiorna i dati dell'adapter con la nuova lista di interventi
    fun setData(data: List<Intervento>) {
        this.data = data
        notifyDataSetChanged()
    }
}
