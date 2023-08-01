package br.com.alura.alugames.dados

import javax.persistence.EntityManager
import javax.persistence.Id

abstract class DAO <TModel, TEntity> (protected val manager: EntityManager, private val entityType: Class<TEntity>) {

    abstract fun toEntity(objeto: TModel): TEntity
    abstract fun getLista(): List<TModel>
    open fun adicionar(objeto: TModel) {
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
    abstract fun recuperarPeloID(id: Id): TModel
    open fun apagar(id: Id) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}