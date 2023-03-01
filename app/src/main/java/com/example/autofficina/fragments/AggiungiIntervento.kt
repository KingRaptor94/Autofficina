/*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.autofficina.R
import com.example.autofficina.entities.Intervento
import android.widget.Toast



class AggiungiIntervento : Fragment() {
    // Dichiarazione di una variabile Spinner
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate della vista
        val view = inflater.inflate(R.layout.fragment_aggiungi_intervento, container, false)
        // Inizializzazione dello Spinner
        spinner = view.findViewById(R.id.spinner_veicolo)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupero della lista di tutti i veicoli
        val listaVeicoli = ServiziVeicoli.tuttiVeicoli()

        // Creazione di una lista di stringhe contenente le informazioni dei veicoli
        val listaDeiVeicoli = mutableListOf<String>()
        listaVeicoli.forEach {
            listaDeiVeicoli.add("${it.numeroTelaio}${it.marca}${it.modello}${it.targa}")
        }

        // Crea un ArrayAdapter per il spinner con la lista dei nomi dei clienti
        // Gli passiamo il layout, il context corrente e la lista dei veicoli
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listaDeiVeicoli)
        // Impostiamo anche il layout usato per la dropdown del menu, sempre fornito dal framework Android.
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Impostazione dell'ArrayAdapter per lo Spinner
        spinner.adapter = spinnerAdapter

        // Aggiunta del listener al bottone "Aggiungi intervento"
        view.findViewById<Button>(R.id.agg_intervento).setOnClickListener {
            // Recupero dei valori inseriti dall'utente
            val problema = view.findViewById<EditText>(R.id.problema_editText).text.toString()
            val oreLavoro = view.findViewById<EditText>(R.id.oreLavoro_editText).text.toString()
            val oraArrivo = view.findViewById<EditText>(R.id.oraArrivo_editText).text.toString()
            val oraRitiro = view.findViewById<EditText>(R.id.oraRitiro_editText).text.toString()
            // Recupero dell'indice dell'elemento selezionato nello Spinner
            val id_veicolo = spinner.selectedItemPosition
            // Recupero del veicolo corrispondente all'indice
            val veicolo = listaVeicoli[id_veicolo]
            // Aggiunta dell'intervento utilizzando i valori recuperati
            ServiziIntervento.aggiungiIntervento(Intervento(0, problema, oreLavoro, oraArrivo, oraRitiro, veicolo.id))

            // Navigazione alla lista degli interventi
            findNavController().navigate(R.id.action_aggiungiIntervento_to_listaInterventi)}
    }
}
*/

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.autofficina.R
import com.example.autofficina.entities.Intervento
import com.example.autofficina.viewModel.ViewModelIntervento
import com.example.autofficina.viewModel.ViewModelVeicolo

class AggiungiIntervento : Fragment() {
    private lateinit var spinner: Spinner
    private lateinit var mInterventoViewModel: ViewModelIntervento
    private lateinit var mVeicoliViewModel: ViewModelVeicolo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla il layout del fragment
        val view = inflater.inflate(R.layout.fragment_aggiungi_intervento, container, false)
        spinner = view.findViewById(R.id.spinner_veicolo) // Prende l'istanza del spinner dalla view
        return view    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mVeicoliViewModel = ViewModelProvider(this).get(ViewModelVeicolo::class.java)
        mInterventoViewModel = ViewModelProvider(this).get(ViewModelIntervento::class.java)

        mVeicoliViewModel.tuttiVeicoli().observe(viewLifecycleOwner) { veicoli ->
            val listaVeicolo = mutableListOf<String>()
            veicoli.forEach {
                listaVeicolo.add("${it.targa}${it.modello}")
            }

            // Crea un ArrayAdapter per il spinner con la lista delle macchine
            val spinnerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                listaVeicolo)

            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerAdapter // Imposta l'adapter per il spinner

        view.findViewById<Button>(R.id.bottoneAggIntervento).setOnClickListener {
            val problema = view.findViewById<EditText>(R.id.problema_editText).text.toString()
            val ore = view.findViewById<EditText>(R.id.oreLavoro_editText).text.toString()
            val arrivo = view.findViewById<EditText>(R.id.oraArrivo_editText).text.toString()
            val rilascio = view.findViewById<EditText>(R.id.oraRitiro_editText).text.toString()
            val veicoloIdSpinner = view.findViewById<Spinner>(R.id.spinner_veicolo)

            // Prende l'ID del cliente selezionato dallo spinner
            val id_veicolo = spinner.selectedItemPosition
            val veicolo = veicoli[id_veicolo]

            mInterventoViewModel.salvaIntervento(intervento =
                Intervento(0, problema, ore, arrivo, rilascio, veicolo.id) )// Passo l'ID del veicolo come parametro

            // Crea un Toast per la riuscita dell'inserimento
            Toast.makeText(requireContext(), "Intervento Inserito!", Toast.LENGTH_SHORT).show()

            // Naviga alla lista dei veicoli
            findNavController().navigate(R.id.action_aggiungiIntervento_to_listaInterventi, arguments)
        }
        }
}}