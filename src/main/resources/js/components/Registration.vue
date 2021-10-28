<template>
    <div class="center" >
        <vs-button @click="active=!active" success block>
            Регистрация
        </vs-button>
        <vs-dialog overflow-hidden v-model="active">
            <template #header>
                <h4 class="not-margin pt-3">
                    Будьте вместе в <b>SCROLLX</b>
                </h4>
            </template>


            <div class="con-form">
                <vs-input v-model="input1" placeholder="Логин">
                    <template #icon>
                        <v-icon>mdi-account</v-icon>
                    </template>
                </vs-input>
                <vs-input type="password" v-model="input2" placeholder="Пароль">
                    <template #icon>
                        <v-icon>mdi-key</v-icon>
                    </template>
                </vs-input>
                <div class="flex">
                    <vs-checkbox v-model="checkbox1">Запомнить</vs-checkbox>
                </div>
            </div>

            <div v-if="registrated">
                {{ registrated }}
            </div>

            <template #footer>
                <div class="footer-dialog">
                    <vs-button block @click="createUser">
                        В путь!
                    </vs-button>
                        Уже есть аккаунт? <a href="#" @click="active=!active">Войди!</a>
                </div>
            </template>
        </vs-dialog>
    </div>

</template>

<script>
import userApi from "../api/userApi";

export default {
	name: "Registration",
	data: () => ({
		active: false,
		input1: '',
		input2: '',
		checkbox1: false,
        registrated: null
	}),
    methods: {
		async createUser() {
		    let result = await userApi.createUser(this.input1, this.input2)
		    let data = await result.json()
            this.registrated = "Вы зарегистрировались!"
        },
    }

}
</script>

<style scoped>

</style>