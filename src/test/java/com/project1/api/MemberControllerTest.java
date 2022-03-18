package com.project1.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.entity.Member;
import com.project1.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Profile("test")
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberRepository memRepo;

    @Autowired
    ObjectMapper objectMapper;

    static String memIdOne, memIdTwo;

    @BeforeEach
    void setUp() {
        memRepo.deleteAll();
        memIdOne = memRepo.save(new Member("a", "a@mail.dk", "aaa", "af", "al", "avej", "aby", "2000")).getUsername();
        memIdTwo = memRepo.save(new Member("b", "b@mail.dk", "bbb", "bf", "bl", "bvej", "bby", "2000")).getUsername();
    }

    @Test
    void getMembers() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("api/members/" + memIdOne)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.username").value("a"))
                .andExpect(jsonPath("$.email").value("a@mail.dk"));
    }

    @Test
    void getMember() {
    }

    @Test
    void addMember() {
    }

    @Test
    void editMember() {
    }

    @Test
    void deleteMember() {
    }
}