package br.com.concrete.rodrigorocha.desafiojava.services

import br.com.concrete.rodrigorocha.desafiojava.exceptions.EmailAlreadyExistsException
import br.com.concrete.rodrigorocha.desafiojava.repositories.UserRepository
import br.com.concrete.rodrigorocha.desafiojava.services.dto.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun register(user: User): User {
        val existingUser: List<User> = userRepository.findUserByEmail(user.email)

        if (!existingUser.isEmpty()) {
            throw EmailAlreadyExistsException("E-mail já existente")
        }

        val currentDate = Date()
        user.created = currentDate
        user.modified = currentDate
        user.last_login = currentDate
        user.token = Jwts.builder()
            .setSubject("/users/TzMUocMF4p")
            .setExpiration(Date(currentDate.time + 60000))
            .claim("email", user.email)
            .claim("scope", "self groups/users")
            .signWith(SignatureAlgorithm.HS256, "secret".toByteArray(Charsets.UTF_8)).compact()
        return userRepository.save(user)
    }
}