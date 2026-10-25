package com.julia.TodoList.controller;

import com.julia.TodoList.dto.TodoRequestDTO;
import com.julia.TodoList.dto.TodoResponseDTO;
import com.julia.TodoList.model.Prioridade;
import com.julia.TodoList.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoResponseDTO> listar(){
        return todoService.listar();
    }

    @GetMapping("/prioridade")
    public List<TodoResponseDTO> listarPorPrioridade(@RequestParam Prioridade prioridade){
        return todoService.listarPorPrioridade(prioridade);
    }

    @GetMapping("/concluidas")
    public List<TodoResponseDTO> listarConcluidas(boolean concluida){
        return todoService.listarConcluidas(concluida);
    }

    @PostMapping
    public TodoResponseDTO salvar(@RequestBody @Valid TodoRequestDTO requestDTO){
        return todoService.salvar(requestDTO);
    }

    @PutMapping("/{id}")
    public TodoResponseDTO atualizar(@PathVariable Integer id, @RequestBody @Valid TodoRequestDTO requestDTO){
        return todoService.atualizar(id, requestDTO);
    }

    @PatchMapping("/{id}")
    public TodoResponseDTO alternarEstado(@PathVariable Integer id){
        return todoService.alternarEstado(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        todoService.deletar(id);
    }
}