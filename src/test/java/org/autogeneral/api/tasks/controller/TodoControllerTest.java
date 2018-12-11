package org.autogeneral.api.tasks.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.autogeneral.api.tasks.TasksApplication;
import org.autogeneral.api.tasks.controller.request.ToDoItemAddRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TasksApplication.class)
@AutoConfigureMockMvc
public class TodoControllerTest {

    private static final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private ObjectMapper jsonMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void itemNotFound() throws Exception {
        this.mockMvc.perform(get("/todo/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.details[0].message",equalTo("Item with 1 not found")));
    }

    @Test
    public void patchitemNotFound() throws Exception {
        ToDoItemAddRequest toDoItemAddRequest = new ToDoItemAddRequest();
        toDoItemAddRequest.setCompleted(true);
        toDoItemAddRequest.setText("1234");

        this.mockMvc.perform(patch("/todo/1")
                .contentType(contentType)
                .content(jsonMapper.writeValueAsString(toDoItemAddRequest)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.details[0].message",equalTo("Item with 1 not found")));
    }
}
