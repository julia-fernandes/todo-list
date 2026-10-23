package com.julia.TodoList.dto;

import com.julia.TodoList.model.Prioridade;
import jakarta.validation.constraints.NotBlank;

public record TodoRequestDTO(

        @NotBlank(message = "Informe um título")
        String titulo,

        String descricao,

        Prioridade prioridade,

        boolean concluida
) {}