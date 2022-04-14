package br.com.rrdev.orgs.adpter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// tal class obrigatoriamente que é com base em uma abstract tem que sobrescrever
// essas 3 propriedades, vamos tentar entender cada uma
class ListaProdutosAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    //ViewHolder responsavel por pegar cada uma dessas views e fazer o processo de bind
    //refazer elas na tela na estrutura
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    //Vai indicar em qual momento dos itens do Recycler estamos e qual sua posição e oq queremos
    // fazer com essa informação
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    //vai determinar para o adpter quantos itens nos queremos apresentar dentro dele
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
