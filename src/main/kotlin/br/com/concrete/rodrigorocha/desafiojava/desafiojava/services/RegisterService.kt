package br.com.concrete.rodrigorocha.desafiojava.desafiojava.services

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.services.dto.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterService {

    fun register(user: User): User {
        val dataAtual = Date().toString()
        val insertedUser = User(
            1,
            user.name,
            user.email,
            user.password,
            user.phones,
            dataAtual,
            dataAtual,
            dataAtual,
            "ID_TOKEN"
        )
        return insertedUser
    }
}