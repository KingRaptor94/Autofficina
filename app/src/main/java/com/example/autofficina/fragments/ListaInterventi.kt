package com.example.autofficina.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.adapter.AdapterClienti
import com.example.autofficina.adapter.AdapterInterventi
import com.example.autofficina.adapter.AdapterVeicoli
import com.example.autofficina.servizi.ServiziClienti
import com.example.autofficina.servizi.ServiziIntervento
import com.example.autofficina.servizi.ServiziVeicoli


class ListaInterventi : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // imposta il layout per questo fragment
        return inflater.inflate(R.layout.fragment_lista_interventi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Recupera la RecyclerView dal layout
        view.findViewById<RecyclerView>(R.id.interventiRecyclerView).apply {
            // Imposta il LayoutManager della RecyclerView come LinearLayoutManager con orientamento verticale
            layoutManager = LinearLayoutManager(context).apply { orientation = RecyclerView.VERTICAL }
            // Imposta l'AdapterInterventi come adapter della RecyclerView,
            // e passa la lista di veicoli dal database tramite ServiziIntervento.tuttiInterventi()
            adapter = AdapterInterventi(requireContext(), ServiziIntervento.tuttiInterventi())
        }
    }
}