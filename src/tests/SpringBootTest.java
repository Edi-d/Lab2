package tests;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = {org.example.Main.class})
@AutoConfigureMockMvc
class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnUnauthorizedForFailedLogin() throws Exception {
        String jsonContent = "{\"email\": \"edi@gmail.com\", \"password\": \"pass124\"}";

        this.mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isUnauthorized()) // Expecting 401 Unauthorized
                .andExpect(content().string(containsString("Login failed. Invalid credentials")));
    }

    @Test
    void shouldReturnLoginSuccessful() throws Exception {
        String jsonContent = "{\"email\": \"edi@gmail.com\", \"password\": \"pass123\"}";

        this.mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk()) // Expecting 200 OK
                .andExpect(content().string(containsString("Login successful!")));
    }
}
