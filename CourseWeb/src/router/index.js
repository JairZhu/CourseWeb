import Vue from 'vue'
import Router from 'vue-router'
import MainPage from "../components/MainPage";
import Syllabus from "../components/Syllabus";
import Discuss from "../components/Discuss";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/mainPage',
      name:'mainPage',
      component: MainPage
    },
    {
      path: '/syllabus',
      name: 'syllabus',
      component: Syllabus
    },
    {
      path: '/discuss',
      name: 'discuss',
      component: Discuss
    },
  ]
})
