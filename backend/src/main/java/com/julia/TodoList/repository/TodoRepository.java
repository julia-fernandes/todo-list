package com.julia.TodoList.repository;

import com.julia.TodoList.model.Prioridade;
import com.julia.TodoList.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByPrioridade(Prioridade prioridade);
    List<Todo> findByConcluida(Boolean concluida);
}
