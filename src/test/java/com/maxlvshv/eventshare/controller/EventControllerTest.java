package com.maxlvshv.eventshare.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the {@link EventController}
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/{0}", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateEventStatusToCompleted() throws Exception {
        mockMvc.perform(put("/{0}/comp", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
