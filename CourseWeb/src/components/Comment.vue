<template>
  <div>
    <el-row type="flex" justify="space-around" style="margin-top: 30px">
      <el-col :span="6"></el-col>
      <el-col :span="10">
        <el-card style="margin-bottom: 10px">
          <div slot="header">
            <h3>{{$route.query.title}}</h3>
          </div>
          <div>
            <div v-for="i in $store.state.comments.data" style="margin-bottom: 10px">
              <el-card>
                <div>
                  <span style="color: #409EFF">{{i.writer}}：</span>
                </div>
                <div style="margin-left: 20px; margin-top: 10px">
                  <span v-if="i.counterpart !== ''" style="color: #409EFF;margin-right: 3px">@{{i.counterpart}}</span>
                  <span>{{i.content}}</span>
                </div>
                <div style="text-align: right">
                  <el-button type="text" icon="el-icon-chat-square" @click="showResponse(i.writer)" circle></el-button>
                </div>
              </el-card>
            </div>
          </div>
          <div style="text-align: center">
            <el-button type="primary" icon="el-icon-chat-square" @click="showEdit">评论</el-button>
          </div>
        </el-card>
        <transition name="el-fade-in-linear">
          <el-card v-show="show">
            <el-form :model="form" :rules="rules" ref="form">
              <el-form-item prop="content">
                <el-input type="textarea" :rows="6" :placeholder="tips" v-model="form.content"></el-input>
              </el-form-item>
              <el-form-item style="text-align: center">
                <el-button @click="show=false">取 消</el-button>
                <el-button @click="resetForm('form')">重 置</el-button>
                <el-button type="primary" @click="addComment('form')">确 定</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </transition>
      </el-col>
      <el-col :span="6"></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Comment",
  data() {
    return {
      show: false,
      tips: '',
      form: {
        title: this.$route.query.title,
        content: '',
        writer: '',
        counterpart: '',
        time: ''
      },
      rules: {
        content: [
          { required: true, message: '请输入内容', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    showEdit() {
      this.show = true;
      this.tips = '请输入内容';
      this.form.counterpart = '';
    },
    showResponse(counterpart) {
      this.show = true;
      this.tips = '回复：@' + counterpart;
      this.form.counterpart = counterpart;
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    addComment(formName) {
      if (this.$store.state.isLogin) {
        this.form.writer = this.$store.state.user.name;
        this.form.time = new Date();
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post("http://localhost:8090/saveComment", this.form).then(result => {
              if (result.data) {
                this.$store.commit("addComment", JSON.parse(JSON.stringify(this.form)));
                this.$message({
                  type: 'success',
                  message: '发送成功'
                })
              }
            })
          }
        })
      } else {
        this.$message.error("请先登录！");
        this.$router.push('/mainPage');
      }
    }
  },
  created() {
    this.$http.get("http://localhost:8090/getCommentByTitle", {params: {title: this.$route.query.title}}).then(res => {
      this.$store.commit('setComment', res);
    });
  }
}
</script>

<style scoped>

</style>
