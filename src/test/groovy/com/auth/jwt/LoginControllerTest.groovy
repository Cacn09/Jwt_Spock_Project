package com.auth.jwt

import com.auth.jwt.controller.LoginController
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post


@AutoConfigureMockMvc
@WebMvcTest
class LoginControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Mock
    LoginController loginController


    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello world!"
    }

    def "TESTING USERTOKEN GENERATING"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(post("/usertoken")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .characterEncoding("utf-8")
        .param("user" , "983482098")
        .param("password" , "pass123")
        )
        .andExpect(MockMvcResultMatchers.status().isOk())


        mvc.perform(get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello world!"
    }
}
