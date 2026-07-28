package com.interviewos.ostip;

import com.interviewos.ostip.dto.CandidateCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CandidateControllerIT {

    @Autowired
    MockMvc mockMvc;


    @Test
    @WithMockUser(
            username = "admin@interviewos.local",
            roles = {"ADMIN"}
    )
    void shouldCreateCandidate() throws Exception {
        final String email = "%s@test.com".formatted(UUID.randomUUID().toString());
        final CandidateCreateRequest test = new CandidateCreateRequest(UUID.randomUUID().toString(), UUID.randomUUID().toString(), email, "test");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/candidates")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(test)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(
            username = "admin@interviewos.local",
            roles = {"ADMIN"}
    )
    void shouldReturn404WhenCandidateMissing()
            throws Exception {


        mockMvc.perform(
                        get("/api/v1/candidates/{id}",
                                UUID.randomUUID())
                )
                .andExpect(status().isNotFound());

    }
}
