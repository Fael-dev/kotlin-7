package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.teste.testaHOF

fun main() {
    testaHOF()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("Taxa mensal: $taxaMensal")


    val contaPoupanca = ContaPoupanca(Cliente(
        nome = "Rafael Rodrigues",
        cpf = "111.111.111-11",
        senha = 1234
    ), 1000)

    contaPoupanca.run {
        deposita(1000.0)
        saldo * taxaMensal
    }.let{ rendimentoMensal ->
        println("Rendimento mensal: $rendimentoMensal")
    }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }

    println("Simulação rendimento anual: $rendimentoAnual")
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