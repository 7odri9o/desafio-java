package br.com.concrete.rodrigorocha.desafiojava.desafiojava.converters

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.PhoneRequest
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterRequest
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterResponse
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.services.dto.Phone
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.services.dto.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class RegisterConverter {

    fun convertRegisterRequestToUser(registerRequest: RegisterRequest): User {
        val dataAtual = Date().toString()
        val user = User(
            1,
            registerRequest.name,
            registerRequest.email,
            registerRequest.password,
            registerRequest.phones.map { convertPhoneRequestToPhone(it) },
            dataAtual,
            dataAtual,
            dataAtual,
            "ID_TOKEN")
        return user
    }

    fun convertUserToRegisterResponse(user: User): RegisterResponse {
        val response = RegisterResponse(
            user.id,
            user.name,
            user.email,
            user.created,
            user.modified,
            user.last_login,
            user.token)
        return response
    }

    private fun convertPhoneRequestToPhone(phoneRequest: PhoneRequest): Phone {
        return Phone(null, phoneRequest.ddd, phoneRequest.number)
    }
}