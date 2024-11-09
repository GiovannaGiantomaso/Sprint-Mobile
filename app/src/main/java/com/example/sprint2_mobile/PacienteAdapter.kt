package com.example.sprint2_mobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint2_mobile.R
import com.example.sprint2_mobile.services.Paciente

class PacienteAdapter(private val pacientesList: List<Paciente>) : RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder>() {

    // ViewHolder para armazenar os elementos do layout
    class PacienteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.textViewNome)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        val telefoneTextView: TextView = itemView.findViewById(R.id.textViewTelefone)
        val dataNascimentoTextView: TextView = itemView.findViewById(R.id.textViewDataNascimento)
        val logradouroTextView: TextView = itemView.findViewById(R.id.textViewLogradouro)
        val bairroTextView: TextView = itemView.findViewById(R.id.textViewBairro)
        val cepTextView: TextView = itemView.findViewById(R.id.textViewCep)
        val complementoTextView: TextView = itemView.findViewById(R.id.textViewComplemento)
        val numeroTextView: TextView = itemView.findViewById(R.id.textViewNumero)
        val ufTextView: TextView = itemView.findViewById(R.id.textViewUf)
        val cidadeTextView: TextView = itemView.findViewById(R.id.textViewCidade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_paciente, parent, false)
        return PacienteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val paciente = pacientesList[position]

        // Preenchendo os dados do paciente nos campos correspondentes
        holder.nomeTextView.text = paciente.nome
        holder.emailTextView.text = paciente.email
        holder.telefoneTextView.text = paciente.telefone
        holder.dataNascimentoTextView.text = paciente.dataNascimento
        holder.logradouroTextView.text = paciente.logradouro
        holder.bairroTextView.text = paciente.bairro
        holder.cepTextView.text = paciente.cep
        holder.complementoTextView.text = paciente.complemento
        holder.numeroTextView.text = paciente.numero
        holder.ufTextView.text = paciente.uf
        holder.cidadeTextView.text = paciente.cidade
    }

    override fun getItemCount(): Int {
        return pacientesList.size
    }
}
