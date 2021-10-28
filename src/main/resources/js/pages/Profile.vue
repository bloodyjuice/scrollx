<template>
    <v-flex class="pt-3">

        <v-row class="mx-auto" align="center" justify="center">
            <v-col >
                <v-card rounded="xl">
                    <v-img src="https://fotogora.ru/wp-content/uploads/2014/04/by-Marc-Perrella.jpg"
                           class="postImage" alt="" height="250"
                           width="10000"
                           gradient="to top right, rgba(0,0,0,0.44), rgba(25,32,72,.7)"
                    ></v-img>
                </v-card>
            </v-col>
            <v-row justify="center" align="center" class="mt-n16">
                <v-card rounded="pill" elevation="10">
                    <v-badge
                            bordered
                            color="success"
                            offset-x="40"
                            offset-y="-20"
                            overlap
                    >
                        <v-avatar evelation="10" size="150" style="margin-top: -202px;" align="center" justify="center">
                            <v-img src="https://chance4traveller.com/wp-content/uploads/2021/05/ocean-pixabay-header.jpg"
                                   class="avatarImage " alt=""
                            ></v-img>
                        </v-avatar>
                    </v-badge>
                </v-card>
            </v-row>
        </v-row>

        <v-row justify="center">
            <v-card :width="width" rounded="xl">
                <v-row no-gutters justify="center">
                    <v-col cols="4" class="mt-n10 pb-0">

                        <!--                <v-row class="headerPic" align="center" justify="center">-->
                        <!--                </v-row>-->
                        <v-card  class="rounded-l-xl rounded-r-0" elevation="0" >
                            <v-card-title>
                                <h3>{{ profile.firstName }} {{ profile.lastName }}</h3>
                            </v-card-title>
                            <v-card-subtitle>
                                <h5>В сети</h5>
                            </v-card-subtitle>
                            <v-divider></v-divider>
                            <template #img v-if="profile.avatar != null">
                                <img :src="profile.avatar" class="postImage" alt="">
                            </template>
                            <v-card-subtitle>
                                <p>
                                    Возраст: {{ profile.age }}
                                    <br>
                                    Страна: {{ profile.country }}
                                </p>
                            </v-card-subtitle>
                        </v-card>


                    </v-col>
                    <v-col cols="8" class="mt-n10 pb-0">
                        <v-card class="rounded-r-xl rounded-l-0" height="1000">
                            <v-row no-gutters>
                                <v-col>
                                    <v-card-subtitle>
                                        <h3>
                                            Как ни коротки слова «да» и «нет», все же они требуют некоротковременнго
                                            серьезного размышления.

                                        </h3>
                                    </v-card-subtitle>
                                    <v-divider></v-divider>
                                </v-col>
                            </v-row>
                            <v-row no-gutters>
                                <v-col>
                                    <v-card-subtitle>
                                        <h3>
                                            Дальше будут элементы
                                            ...
                                            ...
                                            ...

                                            ...
                                        </h3>
                                    </v-card-subtitle>
                                    <v-divider></v-divider>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-col>
                </v-row>
            </v-card>

        </v-row>
    </v-flex>
</template>

<script>
import store from "../store/store";

export default {
	name: "Profile",
	data() {
		return {
			profile: store.state.profile
		}
	},
	beforeMount() {
		this.$emit('updateParent', [{ text: 'Настройки', icon: 'mdi-settings' },
			{ text: 'Редактор', icon: 'mdi-pen' },
			{ text: 'Статистика', icon: 'mdi-chart-areaspline-variant' }])

		console.log(store.state.profile)
	},
	computed: {
		width() {
			switch (this.$vuetify.breakpoint.name) {
				case 'xs':
					return 220
				case 'sm':
					return 400
				case 'md':
					return 600
				case 'lg':
					return 1200
				case 'xl':
					return 1400
			}
		},
	}
}
</script>

<style scoped>
.avatarImage {
    height: 60px;
    width: 60px;
}

.headerPic {
    position: absolute;
}

</style>