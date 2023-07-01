package br.com.alura.bytebank.teste

fun testaFuncaoAnonima() {
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        println("Executa como anônima")
        return a + b
    }
    println(minhaFuncaoAnonima(10, 11))

    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun(salario: Double): Double {
        if (salario > 150.0) {
            return salario + 50.0
        }
        return salario + 100.0
    }
    println(calculaBonificacaoAnonima(200.5))
}

fun testaFuncaoLambda() {
    val minhaFuncaoLambda = { a: Int, b: Int ->
        a + b
    }
    println(minhaFuncaoLambda(2, 7))
    val calculaBonificacaoLambda: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 150.0) {
            return@lambda salario + 50.0
        }
        salario + 100.0
    }
    println(calculaBonificacaoLambda(100.0))
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: (Int, Int) -> Int = ::soma // Ou val minhaFuncao = ::teste
    // println(minhaFuncao) => não executa a função
    println(minhaFuncao(5, 2))
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasses: (Int, Int) -> Int = Soma() // Ou val minhaFuncaoClasses = Teste()
    // println(minhaFuncaoClasses()) => não executa a função
    println(minhaFuncaoClasses(4, 3))
}

class Soma: (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}