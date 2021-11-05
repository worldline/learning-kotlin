<template>
<div class="demo">
<label>
  What is your name ?
  <input v-model="name" type="text">
</label>

<p>Hello {{ name }} !</p>
</div>
</template>

<script>
export default {
    name: "v-model-example",
    data(){
        return { name: "" }
    }
}
</script>
