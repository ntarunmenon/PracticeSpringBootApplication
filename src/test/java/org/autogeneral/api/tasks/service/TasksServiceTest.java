package org.autogeneral.api.tasks.service;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TasksServiceTest {

    private TasksService tasksService = new TasksService();

    @Test
    public void testBalancedString(){
        assertTrue(tasksService.isBalanced("{{}}"));
    }

    @Test
    public void testUnBalancedString(){
        assertFalse(tasksService.isBalanced("{{}"));
    }
}
