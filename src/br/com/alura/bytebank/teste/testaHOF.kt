package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaHOF() { // HOF => Higher order function
    soma(1, 6, resultado = { valor ->
        println(valor)
    })
    somaReceiver(1, 6, resultado = {
        println(this)
    })

    val autenticavel = object: Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }
    val sistema = SistemaInterno()

    sistema.entra(autenticavel, 1234) { println("Realizar pagamento") }
    // OU
    // SistemaInterno().entra(autenticavel, 1234, autenticado = { println("Realizar pagamento") })
    sistema.entraReceiver(autenticavel, 1234, autenticado = {
        pagamento()
    })
}

fun testeHigherOrderFunction() {
    1.let{ it }
    2.0.let{ it }

    "".let(::testeRecebeString)
    teste(1, {})
}

fun testeRecebeString(valor: String) {}

// Higher order function => Função que recebe ou devolve outra função
fun teste(teste: Int, bloco: () -> Unit) {}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("Antes da soma")
    resultado(a + b)
    println("Depois da soma")
}

fun somaReceiver(a: Int, b: Int, resultado: Int.() -> Unit) {
    println("Antes da soma")
    val total = a + b
    total.resultado()
    println("Depois da soma")
}
