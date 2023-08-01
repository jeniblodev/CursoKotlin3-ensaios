package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager
import javax.persistence.Id


class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(jogo: Jogo): JogoEntity {
        return JogoEntity(jogo.titulo, jogo.capa, jogo.preco, jogo.descricao, jogo.id)
    }

    override fun getLista(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity -> Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id) }

    }

    override fun recuperarPeloID(id: Id): Jogo {
        val query = manager.createQuery("FROM JogoEntity WHERE id=:id", JogoEntity::class.java)
        query.setParameter("id", id)
        val entity = query.singleResult
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
    }





}