import {createRouter, createWebHistory} from 'vue-router';

import ArticleList from './components/ArticleList.vue';
import ArticleInfo from './components/ArticleInfo.vue';

const routes = [
    // 文章列表
    {path: '/article', component: ArticleList},
    {path: '/article/:id', component: ArticleInfo},
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;