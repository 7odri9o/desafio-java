package br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers

import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.PhoneRequest
import br.com.concrete.rodrigorocha.desafiojava.desafiojava.controllers.dto.RegisterRequest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class RegisterControllerUnitTest {

    @Test
    fun `deve retornar um objeto contendo o campo id preenchido`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertNotNull(response.id)
    }

    @Test
    fun `deve retornar um objeto contendo o campo name com o valor Michael Jackson`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertEquals("Michael Jackson", response.name)
    }

    @Test
    fun `deve retornar um objeto contendo o campo email com o valor do michaeljackson@gmailcom`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertEquals("michael.jackson@gmail.com", response.email)
    }

    @Test
    fun `deve retornar um objeto contendo o campo created preenchido`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertNotNull(response.created)
    }

    @Test
    fun `deve retornar um objeto contendo o campo modified preenchido`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertNotNull(response.modified)
    }

    @Test
    fun `deve retornar um objeto contendo o campo last_login preenchido`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertNotNull(response.last_login)
    }

    @Test
    fun `deve retornar um objeto contendo o campo token preenchido`() {
        val registerController = RegisterController()
        val request = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            listOf(
                PhoneRequest(1,"11", "12345678")
            )
        )
        val response = registerController.register(request)

        Assert.assertNotNull(response.token)
    }
}