<template>

    <v-flex class="pt-5">
        <create-post></create-post>

        <v-row class="pb-5 pt-10" align="start" justify="center" v-for="post in news">

            <v-col cols="11">

                <!--                <vs-card type hoverable class="postFix vs-card-content" id="filterSectionHeight">-->

                <!--                    <template #title>-->
                <!--                        <h3>{{ post.title }}</h3>-->
                <!--                    </template>-->
                <!--                    <template #img v-if="post.picture != null">-->
                <!--                        <img :src="post.picture" class="postImage" alt="">-->
                <!--                    </template>-->
                <!--                    <template #media>-->
                <!--                        <img :src="post.picture" class="postImage" alt="">-->

                <!--                    </template>-->

                <!--                    <template #text>-->
                <!--                        <p>-->
                <!--                            {{ post.description }}-->
                <!--                        </p>-->
                <!--                    </template>-->
                <!--                    <template #interactions>-->
                <!--                        <vs-button danger>-->
                <!--                            <v-icon>mdi-heart</v-icon>-->
                <!--                            4-->
                <!--                        </vs-button>-->
                <!--                        <vs-button class="btn-chat" shadow primary>-->
                <!--                            <v-icon>mdi-comment</v-icon>-->
                <!--                            54-->
                <!--                        </vs-button>-->
                <!--                    </template>-->
                <!--                </vs-card>-->

                <post-card  :post="post" :key="post.id">

                </post-card>

            </v-col>
        </v-row>
    </v-flex>

</template>

<script>
import newsApi from "../api/newsApi";
import store from "../store/store";
import PostCard from "../components/PostCard.vue";
import mapActions from '../store/store'
import CreatePost from "../components/CreatePost.vue";

export default {
	name: "News",
	components: {CreatePost, PostCard},
	data() {
		return {
			news: [],
			profile: store.state.profile
		}
	},

	methods: {
		...mapActions['getPageFilters'],

		async getNews() {

		}
	},

	async beforeMount() {
		this.$emit('updateParent', [{ text: 'Для вас', icon: 'mdi-home' },
			{ text: 'Друзья', icon: 'mdi-account' },
			{ text: 'Настройки', icon: 'mdi-message' },
		])
		let response = await newsApi.newsList
		console.log(await response.json())

		let data = await response.json()
		this.news = await data
	}
}
</script>

<style scoped>
.v-card--reveal {
    align-items: center;
    bottom: 0;
    justify-content: center;
    opacity: .5;
    position: absolute;
    width: 100%;
}
/*.postImage {*/
/*    !*max-width: 300px;*!*/
/*    !*max-height: 300px;*!*/
/*    height: max-content;*/

/*}*/
.postImage {
    background: green;
    height: 100%;
    width: 20%;
    right: 0;
    top: 0;
}

.cardx {
    margin: 15px;
}
</style>