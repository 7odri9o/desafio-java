package br.com.concrete.rodrigorocha.desafiojava.controllers

import br.com.concrete.rodrigorocha.desafiojava.controllers.dto.PhoneRequest
import br.com.concrete.rodrigorocha.desafiojava.controllers.dto.RegisterRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RegisterControllerIntegrationTest {

    @Autowired
    val registerController: RegisterController? = null

    lateinit var mockMvc: MockMvc

    private var mapper: ObjectMapper = ObjectMapper()

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build()
    }

    @Test
    fun `deve retornar status code 201 quando o cadastro tiver sido realizado com sucesso`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("11", "12345678"))

        val bodyRequest = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            phonesRequest)

        mockMvc.perform(post("/api/register")
                    .content(mapper.writeValueAsBytes(bodyRequest))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated)
    }

    @Test
    fun `deve retornar status code 400 quando o campo name estiver vazio`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("11", "12345678"))

        val bodyRequest = RegisterRequest(
            "",
            "michael.jackson@gmail.com",
            "1234",
            phonesRequest)

        mockMvc.perform(post("/api/register")
                    .content(mapper.writeValueAsBytes(bodyRequest))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest)
    }

    @Test
    fun `deve retornar status code 400 quando o campo email estiver vazio`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("11", "12345678"))

        val bodyRequest = RegisterRequest(
            "Michael Jackson",
            "",
            "1234",
            phonesRequest)

        mockMvc.perform(post("/api/register")
                    .content(mapper.writeValueAsBytes(bodyRequest))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest)
    }

    @Test
    fun `deve retornar status code 400 quando o campo password estiver vazio`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("11", "12345678"))

        val bodyRequest = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "",
            phonesRequest)

        mockMvc.perform(post("/api/register")
                    .content(mapper.writeValueAsBytes(bodyRequest))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest)
    }

    @Test
    fun `deve retornar status code 400 quando o campo ddd do telefone estiver vazio`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("", "12345678"))

        val bodyRequest = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "",
            phonesRequest)

        mockMvc.perform(post("/api/register")
                    .content(mapper.writeValueAsBytes(bodyRequest))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest)
    }

    @Test
    fun `deve retornar status code 400 quando o campo number do telefone estiver vazio`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("11", ""))

        val bodyRequest = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "",
            phonesRequest)

        mockMvc.perform(post("/api/register")
                    .content(mapper.writeValueAsBytes(bodyRequest))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest)
    }

    @Test
    fun `deve retornar status code 409 quando o email utilizado no cadastrado já foi cadastrado anteriormente`() {
        val phonesRequest = listOf<PhoneRequest>(
            PhoneRequest("11", "12345678"))

        val bodyRequest = RegisterRequest(
            "Michael Jackson",
            "michael.jackson@gmail.com",
            "1234",
            phonesRequest)

        mockMvc.perform(post("/api/register")
            .content(mapper.writeValueAsBytes(bodyRequest))
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated)

        mockMvc.perform(post("/api/register")
            .content(mapper.writeValueAsBytes(bodyRequest))
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isConflict)
    }
}