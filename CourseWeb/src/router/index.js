import Vue from 'vue'
import Router from 'vue-router'
import MainPage from "../components/MainPage";
import NewsCenter from "../components/NewsCenter";
import Notifications from "../components/Notifications";
import Syllabus from "../components/Syllabus";
import Courseware from "../components/Courseware";
import HomeworkDownload from "../components/HomeworkDownload";
import Discuss from "../components/Discuss";
import HomeworkSubmit from "../components/HomeworkSubmit";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/mainPage',
      name:'mainPage',
      component: MainPage
    },
    {
      path: '/newsCenter',
      name: 'newsCenter',
      component: NewsCenter
    },
    {
      path: '/notifications',
      name: 'notification',
      component: Notifications
    },
    {
      path: '/syllabus',
      name: 'syllabus',
      component: Syllabus
    },
    {
      path: '/courseware',
      name: 'courseware',
      component: Courseware
    },
    {
      path: '/homeworkDownload',
      name: 'homeworkDownload',
      component: HomeworkDownload
    },
    {
      path: '/discuss',
      name: 'discuss',
      component: Discuss
    },
    {
      path: '/homeworkSubmit',
      name: 'homeworkSubmit',
      component: HomeworkSubmit
    }
  ]
})
