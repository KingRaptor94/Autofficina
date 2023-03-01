
package com.example.autofficina.fragments

import ViewModelCliente
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.autofficina.R
import com.example.autofficina.adapter.AdapterClienti
import com.example.autofficina.entities.Cliente


class ListaClienti : Fragment() {
    private lateinit var viewModel: ViewModelCliente


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Imposta il layout per questo fragment
        return inflater.inflate(R.layout.fragment_lista_clienti, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera la RecyclerView dalla vista
        val clientiRecyclerView = view.findViewById<RecyclerView>(R.id.clienti_lista)
        clientiRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Crea un Adapter per la RecyclerView e lo imposta come adapter della RecyclerView
        val adapter = AdapterClienti(requireContext())
        clientiRecyclerView.adapter = adapter

        // Inizializza il ViewModelCliente
        viewModel = ViewModelProvider(this).get(ViewModelCliente::class.java)

        // Ottieni i dati dal ViewModelCliente e imposta l'adapter
        viewModel.tuttiClienti().observe(viewLifecycleOwner) { clienti ->
            adapter.setData(clienti)
        }
        // Settaggio del listener per il pulsante
        view.findViewById<Button>(R.id.home).setOnClickListener {


            // Redirect alla home
            findNavController().navigate(R.id.action_listaClienti_to_HomePageFragment)

    }

}}

