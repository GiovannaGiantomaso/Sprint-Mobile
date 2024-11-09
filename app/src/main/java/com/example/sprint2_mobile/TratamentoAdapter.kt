import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.R
import com.example.sprint2_mobile.services.Tratamento

class TratamentoAdapter(private val tratamentos: List<Tratamento>) : RecyclerView.Adapter<TratamentoAdapter.TratamentoViewHolder>() {

    inner class TratamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val descricaoTextView: TextView = itemView.findViewById(R.id.textViewDescricao)
        private val tipoTextView: TextView = itemView.findViewById(R.id.textViewTipo)
        private val custoTextView: TextView = itemView.findViewById(R.id.textViewCusto)

        fun bind(tratamento: Tratamento) {
            descricaoTextView.text = tratamento.descricao
            tipoTextView.text = tratamento.tipo
            custoTextView.text = tratamento.custo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TratamentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tratamento, parent, false)
        return TratamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TratamentoViewHolder, position: Int) {
        holder.bind(tratamentos[position])
    }

    override fun getItemCount(): Int {
        return tratamentos.size
    }
}
