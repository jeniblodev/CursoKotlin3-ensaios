package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.modelo.Jogo

fun main() {
    val conexao = Banco.obterConexao()
    println(conexao)

}