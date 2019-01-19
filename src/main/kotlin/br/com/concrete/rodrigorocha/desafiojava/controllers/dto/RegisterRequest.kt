package br.com.concrete.rodrigorocha.desafiojava.controllers.dto

class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phones: List<PhoneRequest>
)