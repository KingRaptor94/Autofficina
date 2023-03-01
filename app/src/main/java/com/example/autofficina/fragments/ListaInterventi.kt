package com.example.autofficina.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.adapter.AdapterInterventi
import com.example.autofficina.viewModel.ViewModelIntervento


class ListaInterventi : Fragment() {
    private lateinit var viewModel: ViewModelIntervento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Imposta il layout per questo fragment
        return inflater.inflate(R.layout.fragment_lista_interventi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera la RecyclerView dalla vista
        val interventiRecyclerView = view.findViewById<RecyclerView>(R.id.interventi_lista)
        interventiRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Crea un Adapter per la RecyclerView e lo imposta come adapter della RecyclerView
        val adapter = AdapterInterventi(requireContext())
        interventiRecyclerView.adapter = adapter

        // Inizializza il ViewModelInterventi
        viewModel = ViewModelProvider(this).get(ViewModelIntervento::class.java)

        // Ottieni i dati dal ViewModelInterventi e imposta l'adapter
        viewModel.tuttiInterventi().observe(viewLifecycleOwner) { interventi ->
            adapter.setData(interventi)
        }

        // Settaggio del listener per il pulsante
        view.findViewById<Button>(R.id.home).setOnClickListener {
            // Redirect alla home
            findNavController().navigate(R.id.action_listaInterventi_to_HomePageFragment)
        }
    }
}
