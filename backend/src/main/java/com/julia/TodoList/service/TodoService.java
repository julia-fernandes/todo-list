package com.julia.TodoList.service;

import com.julia.TodoList.dto.TodoRequestDTO;
import com.julia.TodoList.dto.TodoResponseDTO;
import com.julia.TodoList.model.Prioridade;
import com.julia.TodoList.model.Todo;
import com.julia.TodoList.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    private Todo toEntity(TodoRequestDTO requestDTO){
        Todo todo = new Todo();
        todo.setTitulo(requestDTO.titulo());
        todo.setDescricao(requestDTO.descricao());
        todo.setPrioridade(requestDTO.prioridade());
        todo.setConcluida(requestDTO.concluida());
        return todo;
    }

    private TodoResponseDTO toResponseDTO(Todo todo){

        return new TodoResponseDTO(
                todo.getTitulo(),
                todo.getDescricao(),
                todo.getPrioridade(),
                todo.isConcluida()
        );
    }

    private Todo buscarEntidade(Integer id){
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    public List<TodoResponseDTO> listaResponseDTO(List<Todo> todos){
        return todos.stream().map(this::toResponseDTO).toList();
    }

    public List<TodoResponseDTO> listar(){
        List<Todo> todos = todoRepository.findAll();
        return listaResponseDTO(todos);
    }

    public List<TodoResponseDTO> listarPorPrioridade(Prioridade prioridade){
        List<Todo> todos = todoRepository.findByPrioridade(prioridade);
        return listaResponseDTO(todos);
    }

    public List<TodoResponseDTO> listarConcluidas(boolean concluida){

        List<Todo> todos = todoRepository.findByConcluida(concluida);
        return listaResponseDTO(todos);
    }

    public TodoResponseDTO salvar(TodoRequestDTO requestDTO){

        Todo todo = toEntity(requestDTO);
        todoRepository.save(todo);
        return toResponseDTO(todo);
    }

    public TodoResponseDTO atualizar(Integer id, TodoRequestDTO requestDTO){

        Todo todo = buscarEntidade(id);

        todo.setTitulo(requestDTO.titulo());
        todo.setDescricao(requestDTO.descricao());
        todo.setPrioridade(requestDTO.prioridade());
        todo.setConcluida(requestDTO.concluida());

        Todo todoAtualizada = todoRepository.save(todo);
        return toResponseDTO(todoAtualizada);
    }

    public TodoResponseDTO alternarEstado(Integer id){
        Todo todo = buscarEntidade(id);

        todo.setConcluida(!todo.isConcluida()); //inverte o estado de conclusão atual
        return toResponseDTO(todoRepository.save(todo));
    }

    public void deletar(Integer id){

        Todo todo = buscarEntidade(id);
        todoRepository.delete(todo);
    }
}
