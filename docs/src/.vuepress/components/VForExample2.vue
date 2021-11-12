<template>
<div class="demo">
<transition-group name="flip-list" tag="ul">
  <li v-for="(todo, index) in todos_after_sort" :key="todo.label">
  <label>
    <input type="checkbox" v-model="todo.done">
    Task {{ index }} : {{todo.label}}
  </label>
  - <i>{{todo.done ? "DONE !": "in progress..."}}</i>
  </li>
</transition-group>
</div>
</template>

<script>
export default {
    name: "v-for-example-2",
    data(){
        return {
            todos: [
              { label: 'See list transitions', done: false },
              { label: 'Learn Vue', done: false },
              { label: 'Use v-for', done: true }
            ]
        }
    },
    computed: {
      todos_after_sort(){
        return this.todos.sort((a,b) => +a.done - b.done)
      }
    }
}
</script>

<style>
.flip-list-move {
  transition: transform 1s;
}
</style>
