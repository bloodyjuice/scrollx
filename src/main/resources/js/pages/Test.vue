<template>
    <v-app id="q-app">
        <v-app-bar
                app
                color="white"
                flat
        >
            <v-avatar
                    :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'"
                    size="32"
            ></v-avatar>

            <v-tabs
                    centered
                    class="ml-n9"
                    color="grey darken-1"
            >
                <v-tab
                        v-for="link in links"
                        :to="link.link"
                >
                    {{ link.text }}
                </v-tab>
            </v-tabs>

            <login v-if="profile == null"></login>


            <v-avatar
                    class="hidden-sm-and-down"
                    color="grey darken-1 shrink"
                    size="32"
            >
                <v-img src="https://fotogora.ru/wp-content/uploads/2014/04/by-Marc-Perrella.jpg">

                </v-img>
            </v-avatar>
        </v-app-bar>

        <v-main class="grey lighten-3">
            <v-container>
                <v-row justify="center">
                    <v-col v-if="items.length > 0"
                            cols="2"
                    >
                        <v-sheet
                                rounded="lg"
                        >
                            <v-list
                                    nav
                                    dense
                            >
                                <v-list-item-group
                                        v-model="selectedItem"
                                        color="primary"
                                >
                                    <v-list-item
                                            v-for="(item, i) in items"
                                            :key="i"
                                    >
                                        <v-list-item-icon>
                                            <v-icon v-text="item.icon"></v-icon>
                                        </v-list-item-icon>

                                        <v-list-item-content>
                                            <v-list-item-title>
                                                {{ item.text }}
                                            </v-list-item-title>
                                        </v-list-item-content>
                                    </v-list-item>
                                </v-list-item-group>
                            </v-list>
                        </v-sheet>
                    </v-col>

                    <v-col
                            cols="8"
                    >
                        <v-sheet
                                min-height="90vh"
                                rounded="xl"
                                :class=" items.length > 0 ? undefined : 'grey lighten-3'"
                        >

                            <router-view @updateParent="handleUpdate">
                            </router-view>

                        </v-sheet>
                    </v-col>


<!--                    <v-col-->
<!--                            cols="12"-->
<!--                            sm="2"-->
<!--                    >-->
<!--                        <v-sheet-->
<!--                                rounded="lg"-->
<!--                                min-height="268"-->
<!--                        >-->
<!--                            &lt;!&ndash;  &ndash;&gt;-->
<!--                        </v-sheet>-->
<!--                    </v-col>-->
                </v-row>

            </v-container>
        </v-main>
    </v-app>
</template>

<script>

import Login from "../components/Login.vue";
import store from "../store/store";
import userApi from "../api/userApi";

export default {
	components: {Login},
	data: () => ({
		active: 'guide',
		profile: store.state.profile,
		links: [
			{
				text: 'Дом', link: "/profile",
			},
			{
				text: 'Сообщения', link: "/messages",
			},
			{
				text: 'Друзья', link: "/friends",
			},
			{
				text: 'Газета', link: "/news",
			},
			{
				text: 'Группы', link: "/groups",
			},
			{
				text: 'Музыка', link: "/music",
			},
			{
                text: 'Видео', link: "/video"
            },
			{
                text: 'Заметки', link: "/notes"
            },
			{
                text: 'Уведомления', link: "/notifications"
            },
		],
		selectedItem: 0,
		items: [],
	}),
	methods: {
		logout() {
			userApi.logout()
		},
		handleUpdate (filterItems) {
			this.items = filterItems
		}
	},
	mounted() {
		this.$vs.theme('dark')
	},
}
</script>
<style scoped>

.vs-navbar-group {
    z-index: 100;
}

.vs-card {
    z-index: 1;
    min-width: 99%;
    right: 0;
    top: 0;
    left: 0;
}

.addition {
    overflow: hidden;
    width: 90%;
    height: 100vh;

}

.nodisplay {
    display: none;

}
div.sidebar {
    background: #fff;
    width: 100%;
}
div#scrollable {
    overflow-y: auto;
    height:90vh;

}
div#fixed {
    background: #76a7dc;
    color: #fff;
    position:fixed;
    top:0;
    width:100%;
}

</style>