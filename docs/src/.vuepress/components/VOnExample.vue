<template>
<div class="demo">
    <button v-on:click="counter += 1"> Click here! </button>
    This button has been clicked {{ counter }} times.

    <button @click="resetCounter($event)"> Reset </button>
</div>
</template>

<script>
export default {
    name: "v-on-example",
    data(){
        return { counter: 0 }
    },
    methods: {
        resetCounter(event){
            event.stopPropagation();
            this.counter = 0;
        }
    }
}
</script>
