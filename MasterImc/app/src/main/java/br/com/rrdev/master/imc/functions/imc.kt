package br.com.rrdev.master.imc.functions

fun imc(peso: String, altura: String): String {
    var resultado = ""
    val imc = peso.toInt() / (altura.toFloat() * altura.toFloat())

    when {
        imc < 18.50 -> resultado = "Seu imc é: $imc\n indice abaixo do peso"
        imc in 18.50..24.90 -> resultado = "Seu imc é: $imc\n indice normal"
        imc in 25.00..29.90 -> resultado = "Seu imc é: $imc\n indice de Sobrepeso"
        imc in 30.00..40.00 -> resultado = "Seu imc é: $imc\n indice de Obesidade"
        imc > 40 -> resultado = "Seu imc é: $imc\n indice Obesidade grave, procure ajuda medica!!"
    }
    return resultado
}