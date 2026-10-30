<script setup lang="ts">
import { ref } from 'vue'
import type Todo from '@/interfaces/Todo'

const todos = ref<Todo[]>([
  { id: 1, titulo: 'Estudar Vue', descricao: '', prioridade: 'MEDIANA', concluida: false },
  { id: 2, titulo: 'Fazer café', descricao: '', prioridade: 'TRANQUILA', concluida: true },
])

function alternar(todo: Todo) {
  todo.concluida = !todo.concluida
}
</script>

<template>
  <main style="padding: 20px; font-family: sans-serif;">
    <h1>Todos</h1>
    <ul>
      <li
        v-for="todo in todos"
        :key="todo.id"
        :style="{ textDecoration: todo.concluida ? 'line-through' : 'none' }"
      >
        {{ todo.titulo }} ({{ todo.prioridade }})
        <button @click="alternar(todo)">Alternar</button>
      </li>
    </ul>
  </main>
</template>