package br.com.alura.bytebank

fun main() {
    val minhaFuncao: () -> Unit = ::teste // Ou val minhaFuncao = ::teste
    // println(minhaFuncao()) => não executa a função
    val minhaFuncaoClasses: () -> Unit = Teste() // Ou val minhaFuncaoClasses = Teste()
    // println(minhaFuncaoClasses()) => não executa a função
    println(minhaFuncaoClasses())
}

fun teste() {
    println("Executa função")
}

class Teste: () -> Unit {
    override fun invoke() {
        println("Executa invoke do teste")
    }
}