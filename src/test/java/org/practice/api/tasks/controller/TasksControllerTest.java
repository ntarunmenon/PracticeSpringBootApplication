package org.practice.api.tasks.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.practice.api.tasks.TasksApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TasksApplication.class)
@AutoConfigureMockMvc
public class TasksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldOnlyAllowBrackets() throws Exception {
        this.mockMvc.perform(get("/tasks/validateBrackets")
                .param("input", "aaaa"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldBeBalanced() throws Exception {
        this.mockMvc.perform(get("/tasks/validateBrackets")
                .param("input", "{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isBalanced", equalTo(true)));
    }
}
