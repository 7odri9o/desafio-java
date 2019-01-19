package br.com.concrete.rodrigorocha.desafiojava.controllers.dto

class RegisterResponse(
    val id: Long? = null,
    val name: String,
    val email: String,
    val created: String?,
    val modified: String?,
    val last_login: String?,
    val token: String?
)