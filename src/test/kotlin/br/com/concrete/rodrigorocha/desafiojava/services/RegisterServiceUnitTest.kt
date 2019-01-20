package br.com.concrete.rodrigorocha.desafiojava.services

import br.com.concrete.rodrigorocha.desafiojava.services.dto.Phone
import br.com.concrete.rodrigorocha.desafiojava.services.dto.User
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RegisterServiceUnitTest {

    @Autowired
    val registerService: RegisterService? = null

    @Test
    fun `deve retornar um objeto contendo o campo id preenchido o 1`() {
        val dataAtual = Date()
        val userToInsert = User(
            1,
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                Phone(1, "11", "12345678")
            ),
            dataAtual,
            dataAtual,
            dataAtual,
            "TOKEN"
        )

        val id: Long = 1

        val userResult = registerService!!.register(userToInsert)
        Assert.assertEquals(id, userResult.id)
    }

    @Test
    fun `deve retornar um objeto contendo o campo name preenchido com Michael Jackson`() {
        val dataAtual = Date()
        val userToInsert = User(
            1,
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                Phone(1, "11", "12345678")
            ),
            dataAtual,
            dataAtual,
            dataAtual,
            "TOKEN"
        )

        val userResult = registerService!!.register(userToInsert)
        Assert.assertEquals("Michael Jackson", userResult.name)
    }

    @Test
    fun `deve retornar um objeto contendo o campo email preenchido com michaeljackson@gmailcom`() {
        val dataAtual = Date()
        val userToInsert = User(
            1,
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                Phone(1, "11", "12345678")
            ),
            dataAtual,
            dataAtual,
            dataAtual,
            "TOKEN"
        )

        val userResult = registerService!!.register(userToInsert)
        Assert.assertEquals("michael.jackson@gmail.com", userResult.email)
    }

    @Test
    fun `deve retornar um objeto contendo o campo password preenchido com 1234`() {
        val dataAtual = Date()
        val userToInsert = User(
            1,
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                Phone(1, "11", "12345678")
            ),
            dataAtual,
            dataAtual,
            dataAtual,
            "TOKEN"
        )

        val userResult = registerService!!.register(userToInsert)
        Assert.assertEquals("1234", userResult.password)
    }

    @Test
    fun `deve retornar um objeto contendo o campo phones que deve conter um objeto do tipo Phone com o ddd 11`() {
        val dataAtual = Date()
        val userToInsert = User(
            1,
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                Phone(1, "11", "12345678")
            ),
            dataAtual,
            dataAtual,
            dataAtual,
            "TOKEN"
        )

        val userResult = registerService!!.register(userToInsert)
        Assert.assertEquals("11", userResult.phones[0].ddd)
    }

    @Test
    fun `deve retornar um objeto contendo o campo phones que deve conter um objeto do tipo Phone com o number 12345678`() {
        val dataAtual = Date()
        val userToInsert = User(
            1,
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                Phone(1, "11", "12345678")
            ),
            dataAtual,
            dataAtual,
            dataAtual,
            "TOKEN"
        )

        val userResult = registerService!!.register(userToInsert)
        Assert.assertEquals("12345678", userResult.phones[0].number)
    }
}