package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.AluguelDAO
import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.modelo.Periodo
import java.time.LocalDate

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloID(1)
    val jogo = jogoDAO.recuperarPeloID(1)
    val aluguel = gamer.alugaJogo(jogo, Periodo(LocalDate.now(), LocalDate.now().plusDays(7)))

    aluguelDAO.adicionar(aluguel)

    val listaAluguelBanco = aluguelDAO.getLista()
    println(listaAluguelBanco)

    manager.close()
}