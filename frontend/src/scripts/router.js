import Login from "@/pages/Login";
import Header from "@/components/Header";
import Home from "@/components/Home";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";

//path:컨트롤러 같은느낌
//component: 어느 vue를 부를것인지
const routes = [
    {path:'/', component: Home},
    {path:'/login', component: Login},
    {path:'/header', component: Header},
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;