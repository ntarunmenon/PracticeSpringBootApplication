package org.practice.api.tasks.repository;

import org.practice.api.tasks.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
