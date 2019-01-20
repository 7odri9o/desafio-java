package br.com.concrete.rodrigorocha.desafiojava.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class EmailAlreadyExistsException(exception: String): RuntimeException(exception)