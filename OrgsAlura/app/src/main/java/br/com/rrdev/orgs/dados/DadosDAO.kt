package br.com.rrdev.orgs.dados

import br.com.rrdev.orgs.model.Produtos


class ProdutosDao{


    fun adicionar(produto: Produtos){
        armazenamento.add(produto)


    }

    fun buscaTodos():List<Produtos> {
        return armazenamento.toList()
    }

    companion object {
        private val armazenamento = mutableListOf<Produtos>()
    }

}