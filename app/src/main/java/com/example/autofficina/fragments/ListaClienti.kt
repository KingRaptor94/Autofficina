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
import com.example.autofficina.dao.DaoClienti
import com.example.autofficina.servizi.ServiziClienti


class ListaClienti : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // imposta il layout per questo fragment
        return inflater.inflate(R.layout.fragment_lista_clienti, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupero la RecyclerView dalla vista
        view.findViewById<RecyclerView>(R.id.clientiRecyclerView).apply {
            // Imposto il layout manager della RecyclerView
            layoutManager =
                LinearLayoutManager(context).apply { orientation = RecyclerView.VERTICAL }
            // Creo un Adapter per la RecyclerView e lo imposto come adapter della RecyclerView
            adapter = AdapterClienti(requireContext(), ServiziClienti.tuttiClienti())
        }
    }
}