package br.com.alura.alugames.dados

import javax.persistence.Id

abstract class DAO <TModel> {
    abstract fun getLista(): List<TModel>
    abstract fun adicionar(objeto: TModel)
    abstract fun recuperarPeloID(id: Id): TModel
    abstract fun apagar(id: Id)
}