package br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterRequest
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterResponse
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.converters.RegisterConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("/api/register")
class RegisterController(
    @Autowired
    val registerConverter: RegisterConverter
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun register(@RequestBody request: RegisterRequest): RegisterResponse {
        val requestBody = registerConverter.convertRegisterRequestToUser(request)
        return registerConverter.convertUserToRegisterResponse(requestBody)
    }
}