import Vue from "vue";
import VueRouter from "vue-router";
import CompProduct from "../views/CompProduct.vue";
import CompHome from "../views/CompHome.vue";
import CompContact from "../views/CompContact.vue";
import CompChiTietSp from "../components/CompChiTietSp.vue";
import CompCart from "../components/CompCart.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "CompHome",
    component: CompHome,
  },
  {
    path: "/product/",
    name: "CompProduct",
    component: CompProduct,
  },
  {
    path: "/product/:id",
    name: "CompChiTietSp",
    component: CompChiTietSp,
  },
  {
    path: "/cart",
    name: "CompCart",
    component: CompCart,
  },
  {
    path: "/contact",
    name: "CompContact",
    component: CompContact,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
