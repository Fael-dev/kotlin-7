package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno

fun main() {
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
        Endereco(complemento = "apartamento"))
        .filter(predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(block = (::println))

    soma(1, 6, resultado = (::println))

    val autenticavel = object: Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }

    SistemaInterno().entra(autenticavel, 1234) { println("Realizar pagamento") }
    // OU
    // SistemaInterno().entra(autenticavel, 1234, autenticado = { println("Realizar pagamento") })
}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("Antes da soma")
    resultado(a + b)
    println("Depois da soma")
}

fun testeHigherOrderFunction() {
    1.let{ it }
    2.0.let{ it }

    "".let(::testeRecebeString)
    teste(1, {})
}

fun testeRecebeString(valor: String) {}

// Higher order function => Função que recebe ou devolve outra função
fun teste(teste: Int, bloco: () -> Unit) {
}