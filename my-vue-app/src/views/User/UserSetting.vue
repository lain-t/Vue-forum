<template>
    <div class="user-setting">
      <h2>用户设置</h2>
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="username">用户名:</label>
          <input type="text" v-model="user.username" id="username" name="username" placeholder="请输入用户名">
          <br>

          <label for="password">密码:</label>
          <input type="password" v-model="user.password" id="password" name="password" placeholder="请输入密码">          <br>

          <label for="email">电子邮件:</label>
          <input type="email" v-model="user.email" id="email" name="email" placeholder="请输入电子邮件">
          <br>

          <label>性别:</label>
          <input type="radio" id="male" name="gender" value="male" v-model="user.gender">
          <label for="male">男</label>
          <input type="radio" id="female" name="gender" value="female" v-model="user.gender">
          <label for="female">女</label>
          <br>

          <label for="birthday">生日:</label>
          <input type="date" v-model="user.birthday" id="birthday" name="birthday">
          <br>

          <label for="phone">手机号:</label>
          <input type="tel" v-model="user.phone" id="phone" name="phone" placeholder="请输入手机号">
          <br>

          <label for="introduction">简介:</label>
          <textarea v-model="user.introduction" id="introduction" name="introduction" placeholder="请输入简介"></textarea>
          <br>

          <label for="avatar">头像:</label>
          <!-- <input type="file" id="avatar" name="avatar"> -->
          <input type="text" id="avatar" name="avatar" v-model="user.avatar" placeholder="请输入头像链接">
          <br>
        </div>
        <button type="submit">保存设置</button>
      </form>
    </div>
    <ToHome/>
  </template>
  
<script>
import axios from '../../axios';
import ToHome from '../../components/ToHome.vue';
export default {
  name: 'UserSetting',
  components: {},
  data() {
    return {
      user: {
        username: '',
        password: '',
        email: '',
        gender: '',
        birthday: '',
        phone: '',
        introduction: '',
        avatar: ''
      }
    };
  },
  created() {
    // const user0 = JSON.parse(localStorage.getItem('userdata'));
    // this.user.username = user0.username;
    // this.user.password = user0.password;
  },
  mounted() {},
  methods: {
    submitForm() {
      console.log(this.user);
        axios.post('/user/update', this.user)
          .then(response => {
            localStorage.setItem('userdata', JSON.stringify(response.data));
            console.log(response.data);
          })
          .catch(error => {
            console.error(error);
          })
    }
  },components: {
    ToHome
  }
}
</script>
<style scoped>
</style>