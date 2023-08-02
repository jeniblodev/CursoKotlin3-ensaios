package br.com.alura.alugames.dados

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name ="gamers3")
data class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int = 0,
    var nome:String = "Nome do gamer",
    var email:String = "email@email.com",
    var dataNascimento: String? = null,
    var usuario: String? = null,
    @ManyToOne
    var plano: PlanoEntity = PlanoAvulsoEntity("BRONZE"))