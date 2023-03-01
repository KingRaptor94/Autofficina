import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.autofficina.R

class HomePageFragment : Fragment() {


    // Override del metodo onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // Override del metodo onCreateView()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflating del layout della homepage
        var view: View = inflater.inflate(R.layout.fragment_home_page, container, false)

        // Gestione del click sul bottone Lista Clienti
        view.findViewById<Button>(R.id.lista_clienti).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomePageFragment_to_listaClienti)
        }

        // Gestione del click sul bottone Aggiungi Cliente
        view.findViewById<Button>(R.id.agg_cliente).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomePageFragment_to_aggiungiCliente)
        }

        // Gestione del click sul bottone Lista Veicoli
        view.findViewById<Button>(R.id.lista_veicoli).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomePageFragment_to_listaVeicoli)
        }

        // Gestione del click sul bottone Aggiungi Veicolo
        view.findViewById<Button>(R.id.agg_veicolo).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomePageFragment_to_aggiungiVeicolo)
        }

        // Gestione del click sul bottone Aggiungi Intervento
        view.findViewById<Button>(R.id.agg_intervento).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomePageFragment_to_aggiungiIntervento)
        }

        // Gestione del click sul bottone Lista Interventi
        view.findViewById<Button>(R.id.lista_interventi).setOnClickListener {
            view.findNavController().navigate(R.id.action_HomePageFragment_to_listaInterventi)
        }

        return view
    }

    // Override del metodo onViewCreated()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gestione del click sul bottone Aggiungi Cliente
        view.findViewById<Button>(R.id.agg_cliente).setOnClickListener {
            findNavController().navigate(R.id.action_HomePageFragment_to_aggiungiCliente)
        }

        // Gestione del click sul bottone Aggiungi Veicolo
        view.findViewById<Button>(R.id.agg_veicolo).setOnClickListener {
            findNavController().navigate(R.id.action_HomePageFragment_to_aggiungiVeicolo)
        }

        // Gestione del click sul bottone Aggiungi Intervento
        view.findViewById<Button>(R.id.agg_intervento).setOnClickListener {
            findNavController().navigate(R.id.action_HomePageFragment_to_aggiungiIntervento)
        }
    }
}