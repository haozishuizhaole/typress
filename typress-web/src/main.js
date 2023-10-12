import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'; // 导入路由配置
import axios from 'axios';
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

// 设置基础URL，这是你的API服务器的根URL
axios.defaults.baseURL = 'http://127.0.0.1:8080/';
// 设置通用的请求头
axios.defaults.headers.common['session_id'] = localStorage.getItem('session_id');

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(ElementPlus)
app.use(router)
app.mount('#app');