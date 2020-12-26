<template>
  <div id="app">
    <el-row>
      <el-col :span="24" style="text-align: center;">
        <el-image
          style="width: 60px; height: 60px; vertical-align: middle"
          :src="imageURL"
          :fit="fill"></el-image>
        <span style="font-size: 30px; vertical-align: middle; margin-left: 10px">软件体系结构课程网页</span>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-col :span="11">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-menu-item index="mainPage">首页</el-menu-item>
          <el-menu-item index="newsCenter">新闻中心</el-menu-item>
          <el-menu-item index="notifications">通知公告</el-menu-item>
          <el-menu-item index="syllabus">教学大纲</el-menu-item>
          <el-menu-item index="courseware">课件下载</el-menu-item>
          <el-menu-item index="homeworkDownload">作业下载</el-menu-item>
          <el-menu-item index="discuss">在线答疑</el-menu-item>
          <el-menu-item index="homeworkSubmit">作业提交</el-menu-item>
        </el-menu>
      </el-col>
      <el-col :span="2">
        <div style="margin-top: 10px">
          <el-button type="text">登录</el-button>
          <el-button type="text">注册</el-button>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <router-view/>
    </el-row>
  </div>
</template>

<script>
import image from "./assets/USTC.jpg";
export default {
  name: 'App',
  data() {
    return {
      imageURL: image,
      activeIndex: 'mainPage',
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      this.$router.push(key);
    }
  }
}
</script>

<style>

</style>
