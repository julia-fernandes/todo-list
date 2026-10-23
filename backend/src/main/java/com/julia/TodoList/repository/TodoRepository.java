package com.julia.TodoList.repository;

import com.julia.TodoList.model.PrioridadeTodo;
import com.julia.TodoList.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByPrioridade(PrioridadeTodo prioridade);
    List<Todo> findByConcluida(Boolean concluida);
}
