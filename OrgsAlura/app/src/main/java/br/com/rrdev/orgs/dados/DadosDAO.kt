package br.com.rrdev.orgs.dados

import br.com.rrdev.orgs.model.Produtos


class ProdutosDao{

    private val armazenamento = mutableListOf<Produtos>()


    fun adicionar(produto: Produtos){
        armazenamento.add(produto)


    }

    fun buscaTodos():List<Produtos> {
        return armazenamento.toList()
    }

}