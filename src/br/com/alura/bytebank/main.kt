package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Endereco

fun main() {

}

fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua Regina Estela Cavalcante"
        numero = 207
        bairro = "Vila Velha"
        cidade = "Fortaleza"
        estado = "CE"
        cep = "60345-827"
        complemento = "casa"
        completo()
    }.let(::println)
}