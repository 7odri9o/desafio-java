package br.com.concrete.rodrigorocha.desafiojava.services

import br.com.concrete.rodrigorocha.desafiojava.exceptions.EmailAlreadyExistsException
import br.com.concrete.rodrigorocha.desafiojava.repositories.RegisterRepository
import br.com.concrete.rodrigorocha.desafiojava.services.dto.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterService {

    @Autowired
    lateinit var registerRepository: RegisterRepository

    fun register(user: User): User {
        val existingUser: List<User> = registerRepository.findUserByEmail(user.email)

        if (!existingUser.isEmpty()) {
            throw EmailAlreadyExistsException("E-mail já existente")
        }

        val currentDate = Date()
        user.created = currentDate
        user.modified = currentDate
        user.last_login = currentDate
        user.token = "TOKEN"
        return registerRepository.save(user)
    }
}