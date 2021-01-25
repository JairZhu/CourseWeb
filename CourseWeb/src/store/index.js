import Vue from 'vue'
import Vuex from 'vuex'
import it from "element-ui/src/locale/lang/it";

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    isLogin: false,
    isTeacher: false, //true表示老师，false表示学生
    user: null,
    assignments: [],
    news: [],
    ppts: [],
    notifications: []
  },
  mutations: {
    setIsLogin(state, online) {
      state.isLogin = online;
    },
    setTeacher(state, teacher) {
      state.isTeacher = teacher;
    },
    setUser(state, item) {
      state.user = item;
    },
    setAssignments(state, item) {
      state.assignments = item;
    },
    setNews(state, item) {
      state.news = item;
    },
    setPPTs(state, item) {
      state.ppts = item;
    },
    setNotifications(state, item) {
      state.notifications = item;
    },
    addNews(state, item) {
      state.news.push(item);
    },
    addNotification(state, item) {
      state.notifications.push(item);
    },
    addAssignment(state, item) {
      state.assignments.push(item);
    },
    addPPT(state, item) {
      state.ppts.push(item);
    },
  },
  actions: {},
  getters: {},
  modules: {}
})

export default store
