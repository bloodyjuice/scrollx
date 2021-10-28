<template>
    <div>
        <vs-button size="small" @click="popupActivo2=true" color="primary" type="filled">Вход</vs-button>
        <vs-popup class="popup-example"  title="Вход" :active.sync="popupActivo2">
            <vs-input placeholder="Логин" v-model="username"/>
            <vs-input placeholder="Пароль" v-model="password"/>


            <vs-divider></vs-divider>
            <vs-button @click="auth" color="primary" class="mt-10" type="filled">Войти</vs-button>
            <vs-button @click="popupActivo3=true" color="primary" type="filled">Регистрация</vs-button>
            <vs-popup title="Inner popup" :active.sync="popupActivo3">
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    <br><br>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    <br><br>
                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </vs-popup>
            <vs-spacer></vs-spacer>

            <div>
                Не беспокойтесь, мы шифруем
            </div>

        </vs-popup>
    </div>
</template>
<script>

import Registration from "./Registration.vue";
import userApi from "../api/userApi";
import AXIOS from 'axios';


export default {
	name: "Login",
	components: {Registration},
	data() {
		return {
			username: '',
			popupActivo: false,
			password: '',
			remember: false,
			select1:3,
			options1:[
				{text:'IT',value:0},
				{text:'Blade Runner',value:2},
				{text:'Thor Ragnarok',value:3},
			],
			value1:'',
			value2:'',
			popupActivo2:false,
			popupActivo3:false


		}
	},
	methods: {
		auth() {
			let formData = new FormData();
			formData.set("username", this.username);
			formData.set("password", this.password);
			console.log(formData)
			AXIOS.post('/login', formData)
				.then(result => {
					console.log("РЕЗУЛЬТ", result)
					this.loginSuccessful(result);

				})
				.catch((error) => {
					console.log("ОШИБКА" + error)
					this.loginFailed();
				})
		},
		loginSuccessful(req) {
			console.log(req)
			if (req.status !== 200) {
				this.loginFailed();
				return
			}
			this.error = false;
			localStorage.token = req.data.token;
			this.$router.replace('/')
			window.location.reload();

		},
		loginFailed() {
			this.error = 'Login failed!';
			delete localStorage.token
		},
		acceptAlert(color) {
			this.$vs.notify({
				color: 'success',
				title: 'Accept Selected',
				text: 'Lorem ipsum dolor sit amet, consectetur'
			})
		},
		close() {
			this.$vs.notify({
				color: 'danger',
				title: 'Closed',
				text: 'You close a dialog!'
			})
		},
	},
}
</script>
<style lang="stylus">
.popup-example
  .vs-input
    float left
    width 50%
    margin 10px
    margin-top 5px
  .con-select
    margin-left 10px
    width 70%
    margin-bottom 10px
</style>
