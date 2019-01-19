package br.com.concrete.rodrigorocha.desafiojava.desafiojava.repositories

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.services.dto.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository: CrudRepository<User, Long>