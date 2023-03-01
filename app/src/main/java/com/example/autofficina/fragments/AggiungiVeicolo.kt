
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.autofficina.R
import com.example.autofficina.entities.Veicolo
import com.example.autofficina.viewModel.ViewModelVeicolo

class AggiungiVeicolo : Fragment() {
    private lateinit var spinner: Spinner
    private lateinit var mClientiViewModel: ViewModelCliente
    private lateinit var mVeicoliViewModel: ViewModelVeicolo


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

        mClientiViewModel = ViewModelProvider(this).get(ViewModelCliente::class.java)
        mVeicoliViewModel = ViewModelProvider(this).get(ViewModelVeicolo::class.java)

        mClientiViewModel.tuttiClienti().observe(viewLifecycleOwner) { clienti ->
            val listaNomiClienti = mutableListOf<String>()
            clienti.forEach {
                listaNomiClienti.add("${it.nome} ${it.cognome}")
            }

            val spinnerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                listaNomiClienti
            )
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerAdapter

            view.findViewById<Button>(R.id.bottoneAggVeicolo).setOnClickListener {
                val numeroTelaio =
                    view.findViewById<EditText>(R.id.numeroTelaio_editText).text.toString()
                val marca = view.findViewById<EditText>(R.id.marca_editText).text.toString()
                val modello = view.findViewById<EditText>(R.id.modello_editText).text.toString()
                val targa = view.findViewById<EditText>(R.id.targa_editText).text.toString()
                val id_cliente = spinner.selectedItemPosition
                val cliente = clienti[id_cliente]

                mVeicoliViewModel.salvaVeicolo(
                    Veicolo(
                        0,
                        numeroTelaio,
                        marca,
                        modello,
                        targa,
                        cliente.id
                    )
                )

                Toast.makeText(requireContext(), "Veicolo Inserito!", Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.action_aggiungiVeicolo_to_listaVeicoli)
            }
        }
    }}

