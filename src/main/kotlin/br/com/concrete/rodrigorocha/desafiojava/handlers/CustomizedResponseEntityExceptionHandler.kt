package br.com.concrete.rodrigorocha.desafiojava.handlers

import br.com.concrete.rodrigorocha.desafiojava.exceptions.BadRegisterRequestException
import br.com.concrete.rodrigorocha.desafiojava.exceptions.EmailAlreadyExistsException
import br.com.concrete.rodrigorocha.desafiojava.exceptions.ExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CustomizedResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse: ExceptionResponse =
            ExceptionResponse(ex.message)
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(BadRegisterRequestException::class)
    fun handleBadRegisterRequest(ex: BadRegisterRequestException, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse: ExceptionResponse =
            ExceptionResponse(ex.message)
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(EmailAlreadyExistsException::class)
    fun handleBadRegisterRequest(ex: EmailAlreadyExistsException, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse: ExceptionResponse =
            ExceptionResponse(ex.message)
        return ResponseEntity(exceptionResponse, HttpStatus.CONFLICT)
    }
}