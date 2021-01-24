<template>
  <div>
    <el-row type="flex" justify="space-around" style="margin-top: 30px">
      <el-col :span="6">
        <el-card v-if="$store.state.isLogin" style="margin-bottom: 10px">
          <div slot="header">
            <i class="el-icon-user"></i>
            <span style="margin-left: 5px;">个人中心</span>
          </div>
          <div>
            <div style="text-align: center">
              <el-image v-if="$store.state.isTeacher" :src="require('@/assets/teacher.png')" :fit="'contain'" style="width: 150px; height: 150px;"></el-image>
              <el-image v-else :src="require('@/assets/student.png')" :fit="'contain'" style="width: 150px; height: 150px;"></el-image>
              <br>
              <span>{{$store.state.user.name}}</span>
              <br>
              <el-button type="danger" @click="userLogout" style="margin-top: 10px" round>退出</el-button>
            </div>
          </div>
        </el-card>
        <el-card v-else style="margin-bottom: 10px">
          <div slot="header">
            <i class="el-icon-user"></i>
            <span style="margin-left: 5px;">用户登录</span>
          </div>
          <div>
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="70px" class="demo-ruleForm">
              <el-form-item label="用户名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input v-model="ruleForm.password" type="password"></el-input>
              </el-form-item>
              <el-form-item label="类型" prop="type">
                <el-select v-model="ruleForm.type" placeholder="请选择类型">
                  <el-option label="学生" value="false"></el-option>
                  <el-option label="老师" value="true"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item>
                <el-button type="success" icon="el-icon-check" @click="submitForm('ruleForm')" circle></el-button>
                <el-button type="danger" icon="el-icon-close" @click="resetForm('ruleForm')" circle></el-button>
                <el-button type="primary" icon="el-icon-plus" @click="loginForm('ruleForm')" circle></el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
        <el-card>
          <div slot="header">
            <i class="el-icon-upload"></i>
            <span style="margin-left: 5px">作业上传</span>
          </div>
          <div>
<!--           todo:作业上传-->
          </div>
        </el-card>
      </el-col>
      <el-col :span="10">
        <el-card style="margin-bottom: 10px">
          <div slot="header">
            <i class="el-icon-news"></i>
            <span style="margin-left: 5px;">新闻</span>
          </div>
          <div v-for="i in news" :key="i" style="margin-bottom: 18px">
            <i class="el-icon-link"></i>
            <el-button type="text" @click="getDialogInfo(i)">{{i.title}}</el-button>
          </div>
        </el-card>
        <el-card>
          <div slot="header">
            <i class="el-icon-bell"></i>
            <span style="margin-left: 5px;">通知</span>
          </div>
          <div v-for="i in notifications" :key="i" style="margin-bottom: 18px">
            <i class="el-icon-position"></i>
            <el-button type="text" @click="getDialogInfo(i)">{{i.title}}</el-button>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card style="margin-bottom: 10px">
          <div slot="header">
            <i class="el-icon-edit-outline"></i>
            <span style="margin-left: 5px;">最新作业列表</span>
          </div>
          <div v-for="i in assignments" :key="i" style="margin-bottom: 18px">
            <i class="el-icon-notebook-1"></i>
            <el-button type="text" @click="getDrawerInfo(i)">{{i.title}}</el-button>
          </div>
        </el-card>
        <el-card>
          <div slot="header">
            <i class="el-icon-document-copy"></i>
            <span style="margin-left: 5px">课件下载</span>
          </div>
          <div v-for="i in ppts" style="margin-bottom: 18px">
            <i class="el-icon-tickets"></i>
            <a :href="'static/ppt/' + i.title" :download="i.title">{{i.title}}</a>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-drawer
      :title="drawerTitle"
      :visible.sync="drawerVisible"
      :direction="drawerDirection">
      <div style="margin-left: 20px; margin-right: 20px;">
        <span style="line-height: initial; white-space: pre-wrap">{{drawerContent}}</span>
      </div>
    </el-drawer>
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="60%">
      <div style="margin-left: 20px; margin-right: 20px;">
        <span style="line-height: initial; white-space: pre-wrap">{{dialogContent}}</span>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "MainPage",
  data() {
    return {
      drawerVisible: false,
      drawerDirection: 'ltr',
      drawerTitle: null,
      drawerContent: null,
      dialogTitle: null,
      dialogVisible: false,
      dialogContent: null,
      ruleForm: {
        name: '',
        password: '',
        type: null,
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        type: [
          { required: true, message: '请选择类型', trigger: 'change' }
        ],
      },
      news: [],
      notifications: [],
      ppts: [],
      assignments: [],
    };
  },
  methods: {
    userLogout() {
      this.$store.commit('setIsLogin', false);
      this.$store.commit('setTeacher', false);
      this.$store.commit('setUser', null);
      localStorage.setItem("isLogin", JSON.stringify(false));
      localStorage.setItem("isTeacher", JSON.stringify(false));
      localStorage.setItem("user", JSON.stringify(null));
    },
    getDrawerInfo(item) {
      this.drawerVisible = true;
      this.drawerTitle = item.title;
      this.drawerDirection = 'ltr';
      this.drawerContent = item.content;
      // console.log(this.drawerContent);
    },
    getDialogInfo(item) {
      this.dialogVisible = true;
      this.dialogTitle = item.title;
      this.dialogContent = item.content;
      // console.log(this.dialogContent)
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // console.log(this.ruleForm);
          this.$http.post("http://localhost:8090/postUser", this.ruleForm).then(result => {
            if (result.data) {
              this.$store.commit('setIsLogin', true);
              this.$store.commit('setTeacher', (this.ruleForm.type === 'true'));
              this.$store.commit('setUser', this.ruleForm);
              localStorage.setItem("isLogin", JSON.stringify(this.$store.state.isLogin));
              localStorage.setItem("isTeacher", JSON.stringify(this.$store.state.isTeacher));
              localStorage.setItem("user", JSON.stringify(this.$store.state.user));
              this.$notify({
                title: '登录成功',
                message: this.$store.state.user.name + '，欢迎！',
                type: 'success',
              });
            } else {
              this.$store.commit('setIsLogin', false);
              this.$store.commit('setTeacher', false);
              this.$store.commit('setUser', null);
              this.$notify.error({
                title: '登录失败',
                message: '账号、密码或类型错误！',
              });
            }
          })
        } else {
          this.$store.commit('setIsLogin', false);
          this.$store.commit('setTeacher', false);
          this.$store.commit('setUser', null);
          this.$notify.error({
            title: '登录失败',
            message: '请正确填写信息！',
          });
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    loginForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http.post("http://localhost:8090/saveUser", this.ruleForm).then(result => {
            if (result.data) {
              this.$store.commit('setIsLogin', true);
              this.$store.commit('setTeacher', (this.ruleForm.type === 'true'));
              this.$store.commit('setUser', this.ruleForm);
              localStorage.setItem("isLogin", JSON.stringify(this.$store.state.isLogin));
              localStorage.setItem("isTeacher", JSON.stringify(this.$store.state.isTeacher));
              localStorage.setItem("user", JSON.stringify(this.$store.state.user));
              this.$notify({
                title: '注册成功',
                message: this.$store.state.user.name + '，欢迎！',
                type: 'success',
              })
            } else {
              this.$store.commit('setIsLogin', false);
              this.$store.commit('setTeacher', false);
              this.$store.commit('setUser', null);
              this.$notify.error({
                title: '注册失败',
                message: '用户已存在！',
              })
            }
          });
        } else {
          this.$store.commit('setIsLogin', false);
          this.$store.commit('setTeacher', false);
          this.$store.commit('setUser', null);
          this.$notify.error({
            title: '注册失败',
            message: '请正确填写信息！',
          })
        }
      });
    }
  },
  created() {
    this.$http.get("http://localhost:8090/getPPTs").then(result => {
      this.ppts = result.data;
      // console.log(result.data);
    });
    this.$http.get("http://localhost:8090/getNews").then(result => {
      this.news = result.data;
      // console.log(this.news[0].content);
    });
    this.$http.get("http://localhost:8090/getNotifications").then(result => {
      this.notifications = result.data;
      // console.log(this.notifications[0].content);
    });
    this.$http.get("http://localhost:8090/getAssignments").then(result => {
      this.assignments = result.data;
    });
    this.$store.commit('setIsLogin', JSON.parse(localStorage.getItem("isLogin")));
    this.$store.commit('setTeacher', JSON.parse(localStorage.getItem("isTeacher")));
    this.$store.commit('setUser', JSON.parse(localStorage.getItem("user")));
  }
}
</script>

<style >
.el-drawer:focus {
  outline: none;
}
.el-drawer__header span:focus {
  outline: 0;
}
</style>
