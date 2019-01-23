package br.com.concrete.rodrigorocha.desafiojava.repositories

import br.com.concrete.rodrigorocha.desafiojava.services.dto.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {

    fun findUserByEmail(email: String): List<User>

}