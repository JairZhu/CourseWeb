<template>
  <div>
    <el-row type="flex" justify="space-around" style="margin-top: 30px">
      <el-col :span="6">
        <el-card style="margin-bottom: 10px">
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
                  <el-option label="学生" value="student"></el-option>
                  <el-option label="老师" value="teacher"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item>
                <el-button type="success" icon="el-icon-check" @click="submitForm('ruleForm')" circle></el-button>
                <el-button type="danger" icon="el-icon-close" @click="resetForm('ruleForm')" circle></el-button>
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
          <div v-for="i in 8" :key="i" style="margin-bottom: 18px">
            <i class="el-icon-link"></i>
            {{'新闻' + i}}
          </div>
        </el-card>
        <el-card>
          <div slot="header">
            <i class="el-icon-bell"></i>
            <span style="margin-left: 5px;">通知</span>
          </div>
          <div v-for="i in 8" :key="i" style="margin-bottom: 18px">
            <i class="el-icon-position"></i>
            {{'通知' + i}}
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card style="margin-bottom: 10px">
          <div slot="header">
            <i class="el-icon-edit-outline"></i>
            <span style="margin-left: 5px;">最新作业列表</span>
          </div>
          <div v-for="i in homework" :key="i" style="margin-bottom: 18px">
            <i class="el-icon-notebook-1"></i>
            {{'作业' + i}}
          </div>
        </el-card>
        <el-card>
          <div slot="header">
            <i class="el-icon-document-copy"></i>
            <span style="margin-left: 5px">课件下载</span>
          </div>
          <div v-for="i in courseWare" style="margin-bottom: 18px">
            <i class="el-icon-tickets"></i>
            <a :href="'static/ppt/' + i" :download="i">{{i}}</a>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "MainPage",
  data() {
    return {
      ruleForm: {
        name: '',
        password: '',
        type: '',
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
      courseWare: ['0_Guide.ppt', '1_Overview.ppt', '2_Architectures_In_Context.ppt', '3_Basic_Concepts.ppt',
        '4_Architectural Views.ppt', '5_ca.ppt', '5_ea.ppt', '5_ia.ppt', '6_Design the Arch.ppt', '6_Pattern and Style I.ppt',
        '6_Pattern and Style II.ppt', '7_Distributed Architectures.ppt', '7_Frameworks.ppt', '7_Microservices.ptt',
        '7_MVC, MVP and MVVM A Comparison of Architectural Patterns.ppt', '7_Serverless architecture.ppt',
        '7_Service Architectures.ppt', '7_Service Oriented Architecture.ppt', '8_Quality Attributes of Arch.-availability.ppt',
        '8_Quality Attributes of Arch.-modifiability & security.ppt', '8_Quality Attributes of Arch.-performance.ppt',
        '8_Quality Attributes of Arch.-testability & usability.ppt', '8_Quality Attributes.ppt', '9_OO Design Principles.ppt',
        '9_Refactorhelloworld.ppt', '10_Design pattern.ppt', '11_1 Scaling up.ppt', '11_patterns-frameworks-middleware.ppt'],
      homework: [1,2,3,4,5],
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>

</style>
