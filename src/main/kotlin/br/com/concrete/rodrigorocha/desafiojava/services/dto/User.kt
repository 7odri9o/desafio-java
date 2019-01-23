package br.com.concrete.rodrigorocha.desafiojava.services.dto

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.util.*
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
    var created: Date? = null,
    var modified: Date? = null,
    var last_login: Date? = null,
    var token: String? = null)