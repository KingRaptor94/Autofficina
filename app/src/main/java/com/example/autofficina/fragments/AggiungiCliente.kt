import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.autofficina.R
import com.example.autofficina.entities.Cliente
import com.example.autofficina.servizi.ServiziClienti

class AggiungiCliente : Fragment() {

    // Override del metodo onCreateView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate del layout per questo fragment
        return inflater.inflate(R.layout.fragment_aggiungi_cliente, container, false)
    }

    // Override del metodo onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Settaggio del listener per il pulsante di aggiunta cliente
        view.findViewById<Button>(R.id.agg_cliente).setOnClickListener {
            // Recupero dei valori inseriti dall'utente
            val name = view.findViewById<EditText>(R.id.nome_editText).text.toString()
            val surname = view.findViewById<EditText>(R.id.cognome_editText).text.toString()
            val email = view.findViewById<EditText>(R.id.email_editText).text.toString()

            // Aggiunta del nuovo cliente attraverso i servizi dedicati
            ServiziClienti.aggiungiCliente(Cliente(0, name, surname, email))

            // Redirect alla lista dei clienti
            findNavController().navigate(R.id.action_aggiungiCliente_to_listaClienti)
        }
    }
}
