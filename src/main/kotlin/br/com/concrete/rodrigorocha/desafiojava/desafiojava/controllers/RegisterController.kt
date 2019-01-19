package br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterRequest
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController("/api/register")
class RegisterController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun register(@RequestBody request: RegisterRequest): RegisterResponse {
        val date = Date().toString()

        return RegisterResponse(
            1,
            request.name,
            request.email,
            date,
            date,
            date,
            "TOKEN"
        )
    }
}