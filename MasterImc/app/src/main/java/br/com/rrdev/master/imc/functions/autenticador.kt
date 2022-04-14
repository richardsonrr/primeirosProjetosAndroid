package br.com.rrdev.master.imc.functions

import android.text.Editable

fun autenticador(peso: Editable, altura: Editable): Boolean {
    var autenticador = true
    when{
        peso.isEmpty() || peso == null -> autenticador = false
        altura.isEmpty() || altura == null -> autenticador = false
        !altura.contains('.') -> autenticador = false

    }



    return autenticador
}