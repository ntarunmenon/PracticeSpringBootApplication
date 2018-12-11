package org.autogeneral.api.tasks.itest;

import org.autogeneral.api.tasks.TasksApplication;
import org.autogeneral.api.tasks.entity.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TasksApplication.class)
public class TodoControllerITCase {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql("classpath:insert_todo.sql")
    public void test_getToDoById() {
        ResponseEntity<Todo> response = restTemplate.getForEntity("/todo/100", Todo.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getText(), equalTo("This is a test record with Id 100"));
        assertThat(response.getBody().isCompleted(), equalTo(false));
    }

    @Test
    public void test_createToDo() {
        ResponseEntity<Todo> response = restTemplate.postForEntity("/todo",
                new Todo("Test todo insert", LocalDateTime.now()), Todo.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getText(), equalTo("Test todo insert"));
    }
}
