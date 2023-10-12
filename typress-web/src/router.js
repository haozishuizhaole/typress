import {createRouter, createWebHistory} from 'vue-router';
import Layout from "./views/Layout";
import FrontLayout from "./views/front/FrontLayout";
import AdminLayout from "./views/admin/AdminLayout";
import NotFound from "./views/base/NotFound";

const routes = [
    {
        path: '/',
        component: Layout,
        children: [
            {
                // 前端路由
                path: '/',
                component: FrontLayout, // 前端布局组件
                children: [
                    //     {path: '', component: FrontendHome},
                    //     {path: 'about', component: FrontendAbout},
                ],
            },
            {
                // 管理端路由
                path: 'admin',
                component: AdminLayout, // 管理端布局组件
                children: [
                    //     {path: '', component: AdminDashboard},
                    //     {path: 'users', component: AdminUsers},
                ],
            },
        ]
    },
    {
        // 404 not found
        path: '/:catchAll(.*)',
        component: NotFound
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;