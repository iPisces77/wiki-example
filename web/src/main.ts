import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'ant-design-vue/dist/antd.css';
import Antd from 'ant-design-vue';
import * as Icons from '@ant-design/icons-vue';
import axios from "axios";

axios.defaults.baseURL = process.env.VUE_APP_SERVER;
const app = createApp(App);
app.use(store).use(router).use(Antd).mount('#app')
const icons: any = Icons;
for (const i in icons) {
  app.component(i, icons[i]);
}
console.log('环境:', process.env.NODE_ENV)
console.log('环境:', process.env.VUE_APP_SERVER)