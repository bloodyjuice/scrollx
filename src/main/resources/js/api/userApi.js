import Vue from 'vue'



export default {
	logout: user => Vue.http.post("/logout", {}),

	login: (username, password) => Vue.http.post('/login', {username: username, password: password}),
	createUser: (username, password) => Vue.http.post(`/api/user/create`, {username: username, password: password}),
}
