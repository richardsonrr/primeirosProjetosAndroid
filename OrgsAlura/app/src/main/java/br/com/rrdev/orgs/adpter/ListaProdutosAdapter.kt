package br.com.rrdev.orgs.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.model.Produtos

// tal class obrigatoriamente que é com base em uma abstract tem que sobrescrever
// essas 3 propriedades, vamos tentar entender cada uma

class ListaProdutosAdapter(
    private val produtos: List<Produtos>,
    private val context: Context
) :
    RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    //devemos criar uma class ViewHolder() que é uma definição generica pra que possamos
    //criar o nosso proprio
    //ele recebe uma View
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produtos) {
            val product = itemView.findViewById<TextView>(R.id.product)
            product.text = produto.nome
            val descrição = itemView.findViewById<TextView>(R.id.description)
            descrição.text = produto.descrição
            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString()        }
    }


    //ViewHolder responsavel por pegar cada uma dessas views e fazer o processo de bind
    //refazer elas na tela na estrutura
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    //Vai indicar em qual momento dos itens do Recycler estamos e qual sua posição e oq queremos
    // fazer com essa informação
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)

    }

    //vai determinar para o adpter quantos itens nos queremos apresentar dentro dele
    override fun getItemCount(): Int {
        return produtos.size
    }


}
