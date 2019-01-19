package br.com.concrete.rodrigorocha.desafiojava.services.dto

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,

    @Cascade(CascadeType.ALL)
    @OneToMany
    val phones: List<Phone>,
    var created: String? = null,
    var modified: String? = null,
    var last_login: String? = null,
    var token: String? = null)