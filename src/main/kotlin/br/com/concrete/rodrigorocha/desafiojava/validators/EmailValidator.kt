package br.com.concrete.rodrigorocha.desafiojava.validators

import java.util.regex.Pattern

class EmailValidator {

    companion object {
        private const val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        private val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)

        fun validateEmail(email: String): Boolean {
            return pattern.matcher(email).matches()
        }

    }
}