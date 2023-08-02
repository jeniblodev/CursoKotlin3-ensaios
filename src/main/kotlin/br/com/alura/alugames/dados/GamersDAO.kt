package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager


class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(gamer: Gamer): GamerEntity {
        return GamerEntity(gamer.id, gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario, gamer.plano.toEntity())
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario).apply { plano = entity.plano.toModel() }
    }

}