<template>
    <vs-card>
        <div slot="header">
            <h3>
                {{ post.title }}
            </h3>
        </div>
        <div slot="media">
            <v-img :src="post.picture" style="min-width: 100%;"></v-img>
        </div>
        <div>
            <span>{{ post.description }}</span>
        </div>
        <div slot="footer">
            <vs-row vs-justify="flex-end">

                <v-menu
                        open-on-hover
                        top
                        offset-y
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn fab :active="post.liked" class="mt-n5" type="filled" color="danger" icon @click="like"
                               v-on="on">
                            <v-icon color="red" v-if="post.liked">mdi-heart</v-icon>
                            <v-icon v-else color="grey">mdi-heart-outline</v-icon>
                            {{ post.likes.length > 0 ? post.likes.length : 0 }}
                        </v-btn>

                    </template>
                    <v-list subheader>
                        <v-list-item
                                class="mx-n5"
                                v-for="(item, index) in items"
                                :key="index"

                        >
                            <v-btn block text x-small @click="selectReaction(item)">
                                <v-img max-width="20" :src="item.src"></v-img>
                                {{ item.count }}

                            </v-btn>
                        </v-list-item>

                    </v-list>
                </v-menu>
                <v-btn fab radius class="mt-n5" icon>
                    <v-icon color="primary">mdi-comment</v-icon>
                </v-btn>

            </vs-row>
        </div>
    </vs-card>

</template>

<script>
import store from "../store/store";
import actions from "../api/actions";

export default {

	name: "PostCard",
	props: ["post"],
	data() {
		return {
			hovering: false,
			active: 0,
			showMenu: false,
			x: 0,
			y: 0,
			selectedIcon: null,
            likeId: null,
			items: [
				{
					src: 'https://cdn.shopify.com/s/files/1/1061/1924/products/Sad_Face_Emoji_large.png?v=1571606037',
					count: 203
				},
				{src: 'https://www.vhv.rs/dpng/d/504-5040079_evil-face-emoji-hd-png-download.png', count: 335},
				{src: 'http://assets.stickpng.com/images/586294223796e30ac446872f.png', count: 14},
			],
		}
	},
	methods: {
		selectReaction(item) {
			if (this.selectedIcon == null) {
				item.count++;
			}
			let sele = JSON.parse(JSON.stringify(item)).src
			this.selectedIcon = sele

		},
		async like() {
			if (!this.post.liked) {
				this.post.likes.push(
					{
						"user_id": store.state.profile.id,
						"post_id": this.post.id
					}
				)
                await actions.setLike(this.post.id, store.state.profile)
			} else {
				this.post.likes = this.post.likes.filter(function (value, index, arr) {
                    value.user_id = store.state.profile.id
				})
				console.log(this.post.id)
                actions.resetLike(this.post.id)
			}
			this.post.liked ? this.post.liked = false : this.post.liked = true;
		}
	},
	// beforeMount() {
	// 	this.post.likes = 4
	// },
	computed: {
		// likes: {
		// 	get() {
		// 		return this.post.likes
		//     },
		// 	set(newval) {
		// 		return this.post.likes += 1;
		//     }
		// }
	}
}
</script>

<style lang="stylus">
.examplex
  display: flex;
  align-items: center;
  justify-content: center;

  button
    margin: 0px !important;

    &.btnx
      margin-left: 10px !important;
      border-radius: 5px 0px 0px 5px;

    &.btn-drop
      border-radius: 0px 5px 5px 0px;
      border-left: 1px solid rgba(255, 255, 255, .2);

</style>