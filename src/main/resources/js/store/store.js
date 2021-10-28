import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex)

export default new Vuex.Store({
	state: {
		// tests: frontendData.tests,
		profile: frontendData.profile,
		filterPage: [],
		// userTests: frontendData.userTests,

	},
	// getters: {
	// 	sortedTests: state => (state.tests || []).sort((a, b) => -(a.id - b.id)),
	// },
	// plugins: [
	//     createPersistedState()
	// ],
	// mutations: {

		// ! Tests
	// 	addTestMutation(state, test) {
	//
	// 		state.tests = [
	// 			...state.tests,
	// 			test
	// 		]
	// 	},
	// 	updateTestMutation(state, test) {
	// 		const updateIndex = state.tests.findIndex(item => item.id === test.id)
	//
	// 		state.tests = [
	// 			...state.tests.slice(0, updateIndex),
	// 			test,
	// 			...state.tests.slice(updateIndex + 1)
	// 		]
	//
	// 	},
	// 	removeTestMutation(state, test) {
	// 		const deleteIndex = state.tests.findIndex(item => item.id === test.id)
	// 		if (deleteIndex > -1) {
	// 			state.tests = [
	// 				...state.tests.slice(0, deleteIndex),
	// 				...state.tests.slice(deleteIndex + 1)
	// 			]
	// 		}
	//
	// 	},
	//
	// 	reloadTestMutation(state, list) {
	// 		state.tests = list
	// 	},
	//
	// 	reloadUserTestsMutation(state, list) {
	// 		state.userTests = [
	// 			...list
	// 		]
	// 	},
	//
	// 	finishTestMutation(state, test) {
	// 		const updateIndex = state.tests.findIndex(item => item.id === test.id)
	//
	// 		test.trysLeft -= 1
	//
	// 		console.log(test)
	// 		state.tests = [
	// 			...state.tests.slice(0, updateIndex),
	// 			test,
	// 			...state.tests.slice(updateIndex + 1)
	//
	// 		]
	// 	}
	//
	// },
	// actions: {
	// 	async addTestAction({commit, state}, test) {
	// 		const result = await testApi.add(test)
	//
	// 		const data = await result.json()
	// 		const index = state.tests.findIndex(item => item.id === test.id)
	// 		if (index > -1) {
	// 			commit('updateTestMutation', data)
	// 		} else {
	// 			commit('addTestMutation', data)
	// 		}
	// 	},
	// 	async updateTestAction({commit}, test) {
	// 		const result = await testApi.update(test)
	// 		const data = await result.json()
	// 		commit('updateTestMutation', data)
	// 	},
	// 	async removeTestAction({commit}, test) {
	//
	// 		const result = testApi.remove(test.id)
	// 		if (result.ok) {
	// 			commit('removeTestMutation', test)
	// 		}
	//
	// 	},
	// 	async reloadTestAction({commit}) {
	// 		const reuslt = await testApi.forUserTests
	// 		const data = await reuslt.json()
	// 		commit('reloadTestMutation', data)
	// 		await console.log("ВОТ ТУТ ОБНОВА", this.state.tests)
	//
	// 	},
	//
	//
	// 	// ! USER_TESTS
	// 	async reloadUserTestAction({commit}, ) {
	//
	// 		const result = await testApi.getMyUserTests
	// 		const data = await result.json()
	//
	// 		commit('reloadUserTestsMutation', data)
	//
	// 	},
	// }

	mutations: {
		reloadFilters(state, data) {
			state.filterPage = data
		},
	},

	actions: {
		getPageFilters({commit}, ) {
			switch (this.$route.name) {
				case "Main":
					commit('reloadFilters', )

			}
		}
	}
})