package br.com.rrdev.orgs.dados

import br.com.rrdev.orgs.model.Produtos
import java.math.BigDecimal
import java.math.RoundingMode

val dados = listOf(

Produtos(
nome = "Laranja", descrição = "laranja grande", valor = BigDecimal(12.99).setScale(2, RoundingMode.UP)
),
Produtos(
nome = "caramelo", descrição = "caramelo grande", valor = BigDecimal(15.99).setScale(2,RoundingMode.UP)
),
Produtos(
nome = "maça", descrição = "maça grande", valor = BigDecimal(10.99).setScale(2,RoundingMode.UP)
),
Produtos(
nome = "tanja", descrição = "tanja grande", valor = BigDecimal(2.99).setScale(2,RoundingMode.UP)
),
Produtos(
nome = "Laranja", descrição = "laranja grande", valor = BigDecimal(12.99).setScale(2,RoundingMode.UP)
)

)