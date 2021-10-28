import Vuesax from 'vuesax'
import Test from 'pages/Test.vue'
import Vue from 'vue'
import Vuetify from 'vuetify'
import "@babel/polyfill"
import 'api/resource'
import router from "router/router/"
import store from "store/store"
import 'vuetify/dist/vuetify.min.css'
import 'boxicons';
import LongPress from 'vue-directive-long-press'
import 'vuesax/dist/vuesax.css' //Vuesax styles
import 'material-icons/iconfont/material-icons.css';
import 'boxicons/css/boxicons.min.css'
import 'material-icons/iconfont/material-icons.css';
import '../css/matIcons.css'
import VueQuillEditor from 'vue-quill-editor'

import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme



// import { TiptapVuetifyPlugin } from 'tiptap-vuetify';


[Vuetify, Vuesax, VueQuillEditor].forEach((x) => Vue.use(x));


Vue.directive('long-press', LongPress)

new Vue({
	el: '#app',
	router,
	config: {},
	// preset,
	store,
	rtl: true,
	theme: { dark: true },
	vuetify: new Vuetify(),
	render: a => a(Test),
})
