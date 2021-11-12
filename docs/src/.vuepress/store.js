import Vue from "vue"

const state = Vue.observable({ vueVersion: "vue3" }) // pas d'export pour l'état

const storage = typeof window === "object" && window.localStorage ? window.localStorage : null;

for (let key in state) {
	if (storage && storage.getItem(key) !== null) {
		state[key] = localStorage.getItem(key)
	}
}

const store = {
	get(prop) {
		return state[prop]
	},
	set(prop, value) {
		state[prop] = value
		storage && storage.setItem(prop, value)
	},
}

export default store
