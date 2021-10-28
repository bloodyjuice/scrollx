import Vue from 'vue'
import VueRouter from 'vue-router'
import News from "../pages/News.vue";
import Main from "../pages/Main.vue";
import Profile from "../pages/Profile.vue";
import Messages from "../pages/Messages.vue";


Vue.use(VueRouter)

const routes = [
	{
		path: '',
		component: Main,
		name: "Main",
	},
	{
		path: '/messages',
		component: Messages,
	},

	{
		path: '/news',
		component: News,
		name: "News"
	},

	{
		path: '/profile',
		component: Profile,
	},

]

export default new VueRouter({
	// mode: 'history',
	routes
})