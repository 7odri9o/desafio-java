package br.com.concrete.rodrigorocha.desafiojava.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRegisterRequestException(exception: String): RuntimeException(exception)