package br.com.concrete.rodrigorocha.desafiojava.desafiojava.services

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.repositories.RegisterRepository
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.services.dto.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterService {

    @Autowired
    lateinit var registerRepository: RegisterRepository

    fun register(user: User): User {
        val currentDate = Date().toString()
        user.created = currentDate
        user.modified = currentDate
        user.last_login = currentDate
        user.token = "TOKEN"
        return registerRepository.save(user)
    }
}