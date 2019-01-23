package br.com.concrete.rodrigorocha.desafiojava.converters

import br.com.concrete.rodrigorocha.desafiojava.controllers.dto.PhoneRequest
import br.com.concrete.rodrigorocha.desafiojava.controllers.dto.RegisterRequest
import br.com.concrete.rodrigorocha.desafiojava.controllers.dto.RegisterResponse
import br.com.concrete.rodrigorocha.desafiojava.exceptions.BadRegisterRequestException
import br.com.concrete.rodrigorocha.desafiojava.services.dto.Phone
import br.com.concrete.rodrigorocha.desafiojava.services.dto.User
import org.springframework.stereotype.Component

@Component
class RegisterConverter {

    fun convertRegisterRequestToUser(registerRequest: RegisterRequest): User {

        if (registerRequest.name.isEmpty()) {
            throw BadRegisterRequestException("O campo Nome deve ser preenchido")
        }

        if (registerRequest.email.isEmpty()) {
            throw BadRegisterRequestException("O campo Email deve ser preenchido")
        }

        if (registerRequest.password.isEmpty()) {
            throw BadRegisterRequestException("O campo Password deve ser preenchido")
        }

        val invalidPhoneRequest: List<PhoneRequest> = registerRequest.phones
            .filter { it.ddd.isEmpty() || it.number.isEmpty() }
        if (!invalidPhoneRequest.isEmpty()) {
            throw BadRegisterRequestException("Os campos DDD e Number dos telefones devem ser preenchidos")
        }

        return User(
            null,
            registerRequest.name,
            registerRequest.email,
            registerRequest.password,
            registerRequest.phones.map { convertPhoneRequestToPhone(it) },
            null,
            null,
            null,
            null
        )
    }

    fun convertUserToRegisterResponse(user: User): RegisterResponse {
        return RegisterResponse(
            user.id,
            user.name,
            user.email,
            user.created.toString(),
            user.modified.toString(),
            user.last_login.toString(),
            user.token
        )
    }

    private fun convertPhoneRequestToPhone(phoneRequest: PhoneRequest): Phone {
        return Phone(null, phoneRequest.ddd, phoneRequest.number)
    }
}