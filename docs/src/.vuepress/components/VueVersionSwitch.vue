<template>
<div>
    <label><input type="radio" value="vue2" :name="slotKey+'-vue-version'" v-model="vueVersion"> Vue 2.x</label>
    <label><input type="radio" value="vue3" :name="slotKey+'-vue-version'" v-model="vueVersion"> Vue 3.x</label>
    <Content :slot-key="slotKey+'-vue3'" v-if="vueVersion == 'vue3'" />
    <Content :slot-key="slotKey+'-vue2'" v-else />
</div>
</template>

<script>
import store from "../store"

export default {
    name: "VueVersionSwitch",
    props: {
        slotKey: String,
    },
    data(){
        return { store }
    },
    computed: {
        vueVersion: {
            get(){ return this.store.get("vueVersion") },
            set(newVal){ this.store.set("vueVersion", newVal)}
        }
    }
}
</script>