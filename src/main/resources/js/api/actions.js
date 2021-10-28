import Vue from "vue";

export default {

	setLike: (postId, user) => Vue.http.post(`/api/action/setLike/` + postId, user),
	resetLike: postId => Vue.http.post(`/api/action/resetLike/` + postId),
}
