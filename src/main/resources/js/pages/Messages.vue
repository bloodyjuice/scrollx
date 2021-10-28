<template>
    <v-flex>
        <v-row justify="center" class="pt-3">
            <v-card  :width="width" rounded="xl">
                <v-row no-gutters justify="center">
                    <v-col cols="4">
                        <v-row no-gutters>
                            <v-col
                                    cols="12"
                            >
                                    <v-list two-line >
                                        <template v-for="(item, index) in items">
                                            <v-subheader
                                                    v-if="item.header"
                                                    :key="item.header"
                                                    inset
                                            >
                                                {{
                                                    item.header
                                                }}
                                            </v-subheader>

                                            <v-divider
                                                    v-else-if="item.divider"
                                                    :key="index"
                                                    inset
                                            ></v-divider>

                                            <v-list-item
                                                    v-else
                                                    :key="item.title"
                                                    ripple
                                            >
                                                <v-list-item-avatar>
                                                    <img :src="item.avatar">
                                                </v-list-item-avatar>
                                                <v-list-item-content>
                                                    <v-list-item-title v-html="item.title"></v-list-item-title>
                                                    <v-list-item-subtitle
                                                            v-html="item.subtitle"
                                                    ></v-list-item-subtitle>
                                                </v-list-item-content>
                                            </v-list-item>
                                        </template>
                                    </v-list>
                            </v-col>
                        </v-row>


                    </v-col>
                    <v-col cols="8">
                            <v-row no-gutters>
                                <v-col cols="12">

                                    <v-layout justify-center>
                                        <v-card-subtitle>
                                            <h3>
                                                Алкаши
                                            </h3>
                                        </v-card-subtitle>
                                    </v-layout>
                                    <v-divider></v-divider>

                                </v-col>

                            </v-row>

                            <!--                            ТУТ ПЕРЕЧЕНЬ-->

                            <v-card>

                            <v-row class="no-gutters">
                                <v-col
                                        cols="12"
                                        class="flex-grow-1 flex-shrink-0"
                                >
                                    <v-responsive
                                            v-if="activeChat"
                                            class="overflow-y-hidden"


                                    >
                                        <v-card
                                                flat
                                                class="d-flex flex-column scroller"
                                        >
                                            <v-card-text class="flex-grow-1 overflow-y-auto">
                                                <template v-for="(msg, i) in messages">
                                                    <div
                                                            :class="{ 'd-flex flex-row-reverse': msg.me }"
                                                    >
                                                        <v-menu>
                                                            <template v-slot:activator="{ on }">
                                                                <v-hover
                                                                        v-slot:default="{ hover }"
                                                                >
                                                                    <v-chip
                                                                            :color="msg.me ? 'primary' : ''"
                                                                            dark
                                                                            style="height:auto;white-space: normal;"
                                                                            class="pa-4 mb-2"
                                                                            v-on="on"
                                                                    >
                                                                        {{ msg.content }}
                                                                        <sub
                                                                                class="ml-2"
                                                                                style="font-size: 0.5rem;"
                                                                        >{{ msg.created_at }}</sub>
                                                                        <v-icon
                                                                                v-if="hover"
                                                                                small
                                                                        >
                                                                            expand_more
                                                                        </v-icon>
                                                                    </v-chip>
                                                                </v-hover>
                                                            </template>
                                                            <v-list>
                                                                <v-list-item>
                                                                    <v-list-item-icon>
                                                                        <v-icon>
                                                                            mdi-delete
                                                                        </v-icon>
                                                                    </v-list-item-icon>
                                                                </v-list-item>
                                                            </v-list>
                                                        </v-menu>
                                                    </div>
                                                </template>
                                            </v-card-text>
                                            <v-divider></v-divider>
                                            <v-card-text >
                                                <v-text-field
                                                        dense
                                                        v-model="messageForm.content"
                                                        label="Напишите сообщение"
                                                        type="text"
                                                        no-details
                                                        outlined
                                                        @keyup.enter="sendMessage"
                                                        @click:append-outer="sendMessage"
                                                        hide-details
                                                />
                                            </v-card-text>
                                        </v-card>
                                    </v-responsive>
                                </v-col>
                            </v-row>
                            </v-card>

                        <!--                        <v-card class="mb-auto mt-n16">-->
<!--                            <v-card-actions>-->
<!--                                <v-text-field icon-after="true" label-placeholder="icon-after" class="mb-n5" icon-->
<!--                                              placeholder="Сообщение">-->
<!--                                    <v-icon slot="append">mdi-send</v-icon>-->

<!--                                </v-text-field>-->

<!--                            </v-card-actions>-->
<!--                        </v-card>-->
                    </v-col>
                </v-row>
            </v-card>

        </v-row>
    </v-flex>
</template>

<script>
import store from "../store/store";

export default {
	name: "Messages",
	data() {
		return {
			profile: store.state.profile,
			activeChat: 1,
			parents: [
				{
					id: 1,
					title: "john doe",
					active: true
				},
				{
					id: 3,
					title: "scarlett",
					active: false
				},
				{
					id: 4,
					title: "scarlett",
					active: false
				},
				{
					id: 5,
					title: "scarlett",
					active: false
				},
				{
					id: 6,
					title: "scarlett",
					active: false
				},
				{
					id: 7,
					title: "scarlett",
					active: false
				},
				{
					id: 8,
					title: "scarlett",
					active: false
				},
				{
					id: 9,
					title: "scarlett",
					active: false
				},
				{
					id: 10,
					title: "scarlett",
					active: false
				},
				{
					id: 11,
					title: "scarlett",
					active: false
				},
				{
					id: 12,
					title: "scarlett",
					active: false
				},
				{
					id: 13,
					title: "scarlett",
					active: false
				},
				{
					id: 14,
					title: "scarlett",
					active: false
				}
			],
			messages: [
				{
					content: "Нажремся?",
					me: true,
					created_at: "11:11am"
				},
				{
					content: "Да",
					me: false,
					created_at: "11:11am"
				},
				{
					content: "Сильно?",
					me: true,
					created_at: "11:11am"
				},
				{
					content: "ДА!",
					me: false,
					created_at: "11:11am"
				},
				{
					content: "В ОЧКОООО?",
					me: true,
					created_at: "11:11am"
				},
				{
					content: "ДАААА СУКА",
					me: false,
					created_at: "11:12am"
				},
				{
					content: "=)",
					me: false,
					created_at: "11:14am"
				}
			],
			messageForm: {
				content: "",
				me: true,
				created_at: "11:11am"
			},
			items: [
				{
					header: 'Cегодня',
				},
				{divider: true},
				{
					avatar: 'https://picsum.photos/250/300?image=660',
					title: 'Алкаши',
					subtitle:
						`<span class="font-weight-bold">Ярослав Девятовский</span> &mdash; I'll be in your neighborhood`,
				},
				{
					avatar: 'https://picsum.photos/250/300?image=821',
					title: 'Алексей Егорушков</span>',
					subtitle:
						'<span class="font-weight-bold">Го в деревню</span> &mdash; В трехе нажремся',
				},
				{
					avatar: 'https://picsum.photos/250/300?image=783',
					title: 'Даша Курилова',
					subtitle:
						'<span class="font-weight-bold">Ты пидор блядь</span> &mdash; Возьми трубку',
				},
				{
					header: 'Вчера',
				},
				{divider: true},
				{
					avatar: 'https://picsum.photos/250/300?image=1006',
					title: 'Артем Волгин',
					subtitle:
						'В сочи не летай там хуйня',
				},
				{
					avatar: 'https://picsum.photos/250/300?image=146',
					title: 'Василий Зуев',
					subtitle:
						'<span class="font-weight-bold">Я ПЁРНУЛ</span> &mdash; Ща видос кину',
				},
				{
					header: 'Прошедшая неделя',
				},
				{divider: true},
				{
					avatar: 'https://picsum.photos/250/300?image=1008',
					title: 'Эдик Плякин',
					subtitle:
						'Ну пиздец я ЕДИК!!!!!',
				},
				{
					avatar: 'https://picsum.photos/250/300?image=839',
					title:
						'Иван Золотарев',
					subtitle:
						'Го трек запишем заебал',
				},
				{
					avatar: 'https://picsum.photos/250/300?image=145',
					title: 'Дмитрий Титов',
					subtitle:
						'ПУТИН ХУЙЛО',
				},
			],
		}
	},
	beforeMount() {
		var audio = new Audio('https://cf-media.sndcdn.com/MSSabAV7bQxr.128.mp3');
		audio.play();

		this.$emit('updateParent', [])
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
					return 1600
				case 'lg':
					return 1200
				case 'xl':
					return 1400
			}
		},
	},
    methods: {
		sendMessage() {
			if (this.messageForm.content != '') {
				let xx = Object.assign({}, this.messageForm);
				this.messages.push(xx)
				this.messageForm.content = ''
			}
        },
    }
}
</script>

<style scoped>
.scroller {
    overflow: scroll;
    overflow-x: hidden;

    height: 85vh; /* Высота блока */
}
::-webkit-scrollbar {
    width: 0;  /* Remove scrollbar space */
    background: transparent;  /* Optional: just make scrollbar invisible */
}
/* Optional: show position indicator in red */
::-webkit-scrollbar-thumb {
    background: #FF0000;
}
</style>