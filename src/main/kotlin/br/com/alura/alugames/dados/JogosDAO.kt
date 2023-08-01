package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager
import javax.persistence.Id


class JogosDAO(private val manager: EntityManager) {
    fun getJogos(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity -> Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id) }

    }

    fun adicionarJogo(jogo: Jogo) {
        val entity = JogoEntity(jogo.titulo, jogo.capa, jogo.preco, jogo.descricao)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()

    }

    fun recuperarPeloID(id: Id): Jogo {
        val query = manager.createQuery("FROM JogoEntity WHERE id=:id", JogoEntity::class.java)
        query.setParameter("id", id)
        val entity = query.singleResult
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
    }

    fun apagarJogo(id: Id) {
        val query = manager.createQuery("FROM JogoEntity WHERE id=:id", JogoEntity::class.java)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }



}