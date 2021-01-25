import Vue from 'vue'
import Vuex from 'vuex'

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
    }
  },
  actions: {},
  getters: {},
  modules: {}
})

export default store
