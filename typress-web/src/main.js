import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import router from './config/router';

// 创建App
createApp(App)
    .use(router) // 路由配置
    .mount('#app');