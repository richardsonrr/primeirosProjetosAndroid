package br.com.rrdev.orgs.adpter

import android.content.Context
import android.icu.text.NumberFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.databinding.ProductItemBinding
import br.com.rrdev.orgs.model.Produtos
import java.util.*

// tal class obrigatoriamente que é com base em uma abstract tem que sobrescrever
// essas 3 propriedades, vamos tentar entender cada uma

class ListaProdutosAdapter(
    produtos: List<Produtos>,
    private val context: Context
) :
    RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    //devemos criar uma class ViewHolder() que é uma definição generica pra que possamos
    //criar o nosso proprio
    //ele recebe uma View
    class ViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {


        @RequiresApi(Build.VERSION_CODES.N)
        fun vincula(produto: Produtos) {

            val product = binding.product
            product.text = produto.nome
            val descricao = binding.description
            descricao.text = produto.descrição
            val valor = binding.valor
            val formatador:NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            valor.text =   formatador.format(produto.valor)
        }
    }


    //ViewHolder responsavel por pegar cada uma dessas views e fazer o processo de bind
    //refazer elas na tela na estrutura
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context),parent,false)

        return ViewHolder(binding)

    }

    //Vai indicar em qual momento dos itens do Recycler estamos e qual sua posição e oq queremos
    // fazer com essa informação

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)

    }

    //vai determinar para o adpter quantos itens nos queremos apresentar dentro dele
    override fun getItemCount(): Int {
        return produtos.size
    }

    fun atualiza(produtos: List<Produtos>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()

    }


}
