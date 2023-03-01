
package com.example.autofficina.adapter

import ViewModelCliente
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.dao.DaoClienti
import com.example.autofficina.entities.Intervento
import com.example.autofficina.entities.Veicolo
import com.example.autofficina.viewModel.ViewModelVeicolo

class AdapterVeicoli(private val ctx: Context) : RecyclerView.Adapter<AdapterVeicoli.ViewHolder>() {

    private var data: List<Veicolo> = mutableListOf()


    // ViewHolder interno alla classe AdapterVeicoli
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Dichiarazione degli elementi della view da popolare
        private val numeroTelaioView: TextView = itemView.findViewById(R.id.numeroTelaioVeicolo)
        private val marcaView: TextView = itemView.findViewById(R.id.marcaVeicolo)
        private val modelloView: TextView = itemView.findViewById(R.id.modelloVeicolo)
        private val targaView: TextView = itemView.findViewById(R.id.targaVeicolo)
        val clienteIdView: TextView = itemView.findViewById(R.id.id_cliente)


        // Metodo per popolare la view con i dati del veicolo
        fun mostraVeicolo(veicolo: Veicolo) {
            numeroTelaioView.text = veicolo.numeroTelaio
            marcaView.text = veicolo.marca
            modelloView.text = veicolo.modello
            targaView.text = veicolo.targa
        }
    }

    // Metodo che viene chiamato per creare una nuova view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.veicolo_singolo, parent, false))


    // Metodo che restituisce la dimensione della lista di veicoli da visualizzare
   // override fun getItemCount(): Int = viewModel.tuttiVeicoli().value?.size ?: 0
    override fun getItemCount(): Int = data.size

    // Metodo chiamato per associare i dati ad una view holder specifica
   // override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   //     viewModel.tuttiVeicoli().value?.get(position)?.let { holder.mostraVeicolo(it) }
 //   } }
    override fun onBindViewHolder(holder: AdapterVeicoli.ViewHolder, position: Int) {
        val veicoloCorrente = data[position]
        holder.mostraVeicolo(veicoloCorrente)
        holder.clienteIdView.text = "ID Cliente: ${veicoloCorrente.id_cliente}"
        val cliente = veicoloCorrente.id_cliente.let{


        }
    }    fun setData(data: List<Veicolo>) {
        this.data = data
        notifyDataSetChanged()
    }
}

/*
override fun onBindViewHolder(holder: AdapterVeicoli.ViewHolder, position: Int) {
    val veicoloCorrente = data[position]
    holder.mostraVeicolo(veicoloCorrente)
    holder.clienteIdView.text = "ID Cliente: ${veicoloCorrente.id_cliente ?: "N/A"}"
    veicoloCorrente.id_cliente?.let { clienteId ->
        val cliente = viewModelCliente.ottieniCliente(clienteId)
        // utilizzare il cliente ottenuto
    }
}
 */