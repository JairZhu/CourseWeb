<template>
  <div id="app">
    <el-row>
      <el-col :span="24" style="text-align: center;">
        <el-image style="width: 60px; height: 60px; vertical-align: middle" :src="imageURL" :fit="'fill'"></el-image>
        <span style="font-size: 30px; vertical-align: middle; margin-left: 10px">软件体系结构课程网页</span>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
        <el-menu-item index="mainPage">首页</el-menu-item>
        <el-menu-item index="syllabus">教学大纲</el-menu-item>
        <el-menu-item index="discuss">在线答疑</el-menu-item>
      </el-menu>
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
