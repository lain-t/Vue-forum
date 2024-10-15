<template>
  <div>
    <p>登录界面</p>
    <div>
      <form @submit.prevent="login">
        <label for="username">*用户名称:</label>
        <input type="text" id="username" v-model="user.username" required><br><br>
        <label for="password">*用户密码:</label>
        <input type="password" id="password" v-model="user.password" required><br><br>
        <button type="submit">登录</button>
      </form>
    </div>
  </div>
  <ToHome/>
</template>
  
<script>
import axios from '../../axios';
import ToHome from '../../components/ToHome.vue';

export default {
  name: 'Login',
  data() {
    return {
      user:{
        username: '',
        password: ''
      }
    };
  },
  methods: {
  login() {
    axios.post("/user/login", this.user)
      .then(response => {
        localStorage.setItem('userdata', JSON.stringify(response.data));
        console.log('登录成功:', response.data);
        this.$router.push({ name: 'Home' });
      })
      .catch(error => {
        console.error('登录失败:', error);
      });
    }
  },
  components: {
    ToHome
  }
};
</script>

<style scoped>
</style>