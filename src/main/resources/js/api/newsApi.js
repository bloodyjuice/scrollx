import Vue from 'vue'

const news = Vue.resource('/api/news{/id}')
const allNews = Vue.resource('/api/news/getAll')

export default {
	getNews: allNews.get({}),

	newsList: Vue.http.get(`/api/news/getAll`),
}
