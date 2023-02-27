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
import com.example.autofficina.entities.Veicolo
import com.example.autofficina.servizi.ServiziClienti
import com.example.autofficina.servizi.ServiziVeicoli

class AggiungiVeicolo : Fragment() {
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla il layout del fragment
        val view = inflater.inflate(R.layout.fragment_aggiungi_veicolo, container, false)
        spinner = view.findViewById(R.id.spinner_cliente) // Prende l'istanza del spinner dalla view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaClienti = ServiziClienti.tuttiClienti()

        val listaNomiClienti = mutableListOf<String>()
        listaClienti.forEach {
            listaNomiClienti.add("${it.nome}${it.cognome}")
        }

        // Crea un ArrayAdapter per il spinner con la lista dei nomi dei clienti
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listaNomiClienti)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter // Imposta l'adapter per il spinner

        view.findViewById<Button>(R.id.agg_veicolo).setOnClickListener {
            // Prende i valori dei campi di input dall'interfaccia utente
            val numeroTelaio = view.findViewById<EditText>(R.id.numeroTelaio_editText).text.toString()
            val marca = view.findViewById<EditText>(R.id.marca_editText).text.toString()
            val modello = view.findViewById<EditText>(R.id.modello_editText).text.toString()
            val targa = view.findViewById<EditText>(R.id.modello_editText).text.toString()

            // Prende l'ID del cliente selezionato dallo spinner
            val id_cliente = spinner.selectedItemPosition
            val cliente = listaClienti[id_cliente]

            // Aggiunge il nuovo veicolo al database utilizzando il servizio Veicoli
            ServiziVeicoli.aggiungiVeicolo(Veicolo(0, numeroTelaio, marca, modello, targa,cliente.id))

            // Naviga alla lista dei veicoli
            findNavController().navigate(R.id.action_aggiungiVeicolo_to_listaVeicoli)
        }
    }
}