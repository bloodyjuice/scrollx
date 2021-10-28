<template>
    <div>

        <v-card>

            <quill-editor v-if="!additional"
                          :options="basicOptions"
            >
                <v-card>
                    <v-text-field> esfdcewfsdesfdcewfsdesfdcewfsdesfdcewfsdesfdcewfsdesfdcewfsdesfdcewfsdesfdcewfsd </v-text-field>
gi
                </v-card>

            </quill-editor>

        </v-card>

        <v-card>
            <quill-editor v-if="additional"
                          :options="additionalOptions"
            ></quill-editor>

        </v-card>
        <v-card>
            <v-checkbox label="Расширенная настройка" v-model="additional"></v-checkbox>

        </v-card>

    </div>

    <!--        <v-row no-gutters class="align-center justify-center">-->
    <!--            <v-col cols="11">-->

    <!--                <v-text-field label="Создайте пост"></v-text-field>-->

    <!--            </v-col>-->

    <!--        </v-row>-->
    <!--        <v-divider class="pb-10">-->
    <!--        </v-divider>-->

</template>

<script>
// import {quillEditor} from 'vue-quill-editor'

export default {

	name: "CreatePost",
	// components: {quillEditor},

	data() {
		return {
			additional: false,

			basicOptions: {
				modules: {
					toolbar: [
						['bold', 'italic', 'underline', 'strike'],
						[{'size': ['small', false, 'large', 'huge']}],
						[{'header': [1, 2, 3, 4, 5, 6, false]}],
					]
				}
			},
			additionalOptions: {
				modules: {
					toolbar: [
						['bold', 'italic', 'underline', 'strike'],
						['blockquote', 'code-block'],
						[{'header': 1}, {'header': 2}],
						[{'list': 'ordered'}, {'list': 'bullet'}],
						[{'script': 'sub'}, {'script': 'super'}],
						[{'indent': '-1'}, {'indent': '+1'}],
						[{'direction': 'rtl'}],
						[{'size': ['small', false, 'large', 'huge']}],
						[{'header': [1, 2, 3, 4, 5, 6, false]}],
						[{'font': []}],
						[{'color': []}, {'background': []}],
						[{'align': []}],
						['clean'],
						['link', 'image', 'video']
					],
				}
			}
		}
	},

	// computed: {
	// 	needWatch() {
	// 		return this.basicOptions = this.additionalOptions;
	// 	},
	// },
	// //
	// //
	// watch: {
	// 	needWatch(newVal, oldVal) {
	// 		const [ k, v ] = Object.entries(newVal).find(n => n[1] !== oldVal[n[0]]);
	// 		alert(`${k}.need_watch changed from ${oldVal[k]} to ${v}`);
	// 	},
	// }
	//
	// methods: {
	// 	setAdditional() {
	// 		this.options.modules = {
	// 			toolbar: [
	// 				['bold', 'italic', 'underline', 'strike'],
	// 				['blockquote', 'code-block'],
	// 				[{'header': 1}, {'header': 2}],
	// 				[{'list': 'ordered'}, {'list': 'bullet'}],
	// 				[{'script': 'sub'}, {'script': 'super'}],
	// 				[{'indent': '-1'}, {'indent': '+1'}],
	// 				[{'direction': 'rtl'}],
	// 				[{'size': ['small', false, 'large', 'huge']}],
	// 				[{'header': [1, 2, 3, 4, 5, 6, false]}],
	// 				[{'font': []}],
	// 				[{'color': []}, {'background': []}],
	// 				[{'align': []}],
	// 				['clean'],
	// 				['link', 'image', 'video']
	// 			],
	// 		}
	// 	}
	// }

}
</script>

<style scoped>

</style>