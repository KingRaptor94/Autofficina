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
import com.example.autofficina.servizi.ServiziIntervento
import com.example.autofficina.servizi.ServiziVeicoli

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
