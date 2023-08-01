package br.com.alura.alugames.dados

import javax.persistence.EntityManager
import javax.persistence.Id

abstract class DAO <TModel> (protected val manager: EntityManager) {

    abstract fun toEntity(objeto: TModel)
    abstract fun getLista(): List<TModel>
    open fun adicionar(objeto: TModel) {
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
    abstract fun recuperarPeloID(id: Id): TModel
    abstract fun apagar(id: Id)
}