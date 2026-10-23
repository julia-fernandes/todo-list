package com.julia.TodoList.dto;

import com.julia.TodoList.model.Prioridade;

public record TodoResponseDTO(

        String titulo,
        String descricao,
        Prioridade prioridade,
        boolean concluida
){}