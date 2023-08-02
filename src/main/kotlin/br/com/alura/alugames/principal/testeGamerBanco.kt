package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.PlanosDAO
import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer = Gamer("Daniel", "daniel@email.com", "19/10/1990", "daniel")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    //inserir no video
    val planoDAO = PlanosDAO(manager)
    //inserir no video
    gamer.plano = planoDAO.recuperarPeloID(3)

    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}