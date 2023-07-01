package br.com.alura.bytebank

fun main() {
    testaTipoFuncaoReferencia()
    testaTipoFuncaoClasse()
    val minhaFuncaoLambda: () -> Unit = {
        println("Executa como lambda")
    }
    println(minhaFuncaoLambda)
    println(minhaFuncaoLambda())
    val minhaFuncaoAnonima: () -> Unit = fun() {
        println("Executa como lambda")
    }
    println(minhaFuncaoAnonima)
    println(minhaFuncaoAnonima())
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: () -> Unit = ::teste // Ou val minhaFuncao = ::teste
    // println(minhaFuncao) => não executa a função
    println(minhaFuncao())
}

fun teste() {
    println("Executa função")
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasses: () -> Unit = Teste() // Ou val minhaFuncaoClasses = Teste()
    // println(minhaFuncaoClasses()) => não executa a função
    println(minhaFuncaoClasses())
}

class Teste: () -> Unit {
    override fun invoke() {
        println("Executa invoke do teste")
    }
}