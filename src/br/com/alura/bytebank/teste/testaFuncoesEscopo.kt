package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaFuncoesEscopo() {
    //    val endereco = Endereco(logradouro = "Rua Regina Estela Cavalcante", numero = 207)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    run {
        println("Execução do run sem extensão")
    }

    val endereco = Endereco()
        .also { println("Criando endereço") }
        .apply {
            logradouro = "Rua Regina Estela Cavalcante"
            numero = 207
        }
    with(endereco) {
        "$logradouro, $numero".toUpperCase()
    }.let (::println)
    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    )
        .filter(predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(block = (::println))
}