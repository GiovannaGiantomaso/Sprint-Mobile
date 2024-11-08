package com.example.sprint2_mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.services.Tratamento

class TratamentoAdapter(private val tratamentos: List<Tratamento>) :
    RecyclerView.Adapter<TratamentoAdapter.TratamentoViewHolder>() {

    class TratamentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtId: TextView = itemView.findViewById(R.id.txtId)
        val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
        val txtTipo: TextView = itemView.findViewById(R.id.txtTipo)
        val txtCusto: TextView = itemView.findViewById(R.id.txtCusto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TratamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tratamento, parent, false)
        return TratamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TratamentoViewHolder, position: Int) {
        val tratamento = tratamentos[position]
        holder.txtId.text = "ID TRATAMENTO: ${tratamento.id}"
        holder.txtDescricao.text = "DESCRIÇÃO: ${tratamento.descricao}"
        holder.txtTipo.text = "TIPO: ${tratamento.tipo}"
        holder.txtCusto.text = "CUSTO: ${tratamento.custo}"
    }

    override fun getItemCount(): Int = tratamentos.size
}
