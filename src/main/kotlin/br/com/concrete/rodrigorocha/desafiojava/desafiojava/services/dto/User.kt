package br.com.concrete.rodrigorocha.desafiojava.desafiojava.services.dto

class User(
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,
    val phones: List<Phone>,
    val created: String,
    val modified: String,
    val last_login: String,
    val token: String)