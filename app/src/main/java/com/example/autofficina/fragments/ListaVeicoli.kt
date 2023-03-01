


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
import com.example.autofficina.adapter.AdapterVeicoli
import com.example.autofficina.viewModel.ViewModelVeicolo

class ListaVeicoli : Fragment() {

    private lateinit var viewModel: ViewModelVeicolo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Imposta il layout per questo fragment
        return inflater.inflate(R.layout.fragment_lista_veicoli, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupera la RecyclerView dalla vista
        val veicoliRecyclerView = view.findViewById<RecyclerView>(R.id.veicoli_lista)
        veicoliRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Crea un Adapter per la RecyclerView e lo imposta come adapter della RecyclerView
        val adapter = AdapterVeicoli(requireContext())
        veicoliRecyclerView.adapter = adapter

        // Inizializza il ViewModelInterventi
        viewModel = ViewModelProvider(this).get(ViewModelVeicolo::class.java)

        // Ottieni i dati dal ViewModelInterventi e imposta l'adapter
        viewModel.tuttiVeicoli().observe(viewLifecycleOwner) { veicoli ->
            adapter.setData(veicoli)
        }
        // Settaggio del listener per il pulsante
        view.findViewById<Button>(R.id.home).setOnClickListener {


            // Redirect alla home
            findNavController().navigate(R.id.action_listaVeicoli_to_HomePageFragment)
    }}}

