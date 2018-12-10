package org.autogeneral.api.tasks.repository;

import org.autogeneral.api.tasks.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Long> {
}
