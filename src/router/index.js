import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'customer.index',
        component: () => import("../views/customer/index.vue")
    },
]


const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;