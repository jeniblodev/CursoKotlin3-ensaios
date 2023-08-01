package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import javax.persistence.EntityManager
import javax.persistence.Id


class GamersDAO(private val manager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity -> Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id) }

    }

    fun adicionarGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.id, gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()

    }

    fun recuperarPeloID(id: Id): Gamer {
        val query = manager.createQuery("FROM GamerEntity WHERE id=:id", GamerEntity::class.java)
        query.setParameter("id", id)
        val entity = query.singleResult
        return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id)
    }

    fun apagarGamer(id: Id) {
        val query = manager.createQuery("FROM GamerEntity WHERE id=:id", GamerEntity::class.java)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }



}