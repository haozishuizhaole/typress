import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'; // 导入路由配置
import axios from 'axios';

// 设置基础URL，这是你的API服务器的根URL
axios.defaults.baseURL = 'http://127.0.0.1:8080/';
// 设置通用的请求头
axios.defaults.headers.common['session_id'] = localStorage.getItem('session_id');

createApp(App).use(ElementPlus).use(router).mount('#app');