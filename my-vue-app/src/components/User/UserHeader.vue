<template>
    <nav class="user-header">

      <div class="user-header-left">

        <div class = "user-loginIn">
          <span v-if="isLoggedIn">欢迎, {{ username }}</span>
        </div>
        <div class = "user-loginOut">

        </div>

      </div>

      <div class="user-header-right">

        <div class = "user-loginOut" v-show = "!isLoggedIn">
          <router-link to="/register">注册</router-link>
          <router-link to="/login">登录</router-link>
        </div> 
        <div class = "user-loginIn" v-show = "isLoggedIn">
          <router-link to="/user" v-show = "pagepath != '/user'">个人中心</router-link>
          <ToHome v-show ="pagepath != '/'" />
          <router-link to="/quit" @click="logout">退出</router-link>
        </div>    
      </div>
      <!-- <div>当前路径是: {{ $route.path }}</div> -->
    </nav>
  </template>
  
<script>
import ToHome from '../ToHome.vue';
export default {
  data() {
    return {
      isLoggedIn: false,
      pagepath: this.$route.path,
      username: ''
    };
  },
  components: {
    ToHome
  },
  created() {
    if(JSON.parse(localStorage.getItem('userdata'))){
      this.isLoggedIn = true;
      this.username = JSON.parse(localStorage.getItem('userdata')).username;
    }
  },
  methods: {
    logout() {
      localStorage.removeItem('userdata');
      // this.$router.resolve('/');
      // this.$router.replace('/');
    }
  //   login() {
  //     // 这里应该调用登录API
  //     this.isLoggedIn = true;
  //     this.username = '用户名称'; // 假设登录后获取到的用户名
  //   },
  //   register() {
  //     // 这里应该跳转到注册页面
  //     alert('跳转到注册页面');
  //   },
  //   logout() {
  //     // 这里应该调用登出API
  //     this.isLoggedIn = false;
  //     this.username = '';
  //   }
  }
};
</script>
  
<style scoped>
.user-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  border-radius: 20px 20px 0 0;
  background-color: #f8f8f8;
}
.user-header-right,
.user-header-left,
.user-loginIn,
.user-loginOut {
  display: flex;
  align-items: center;
}
.user-loginIn *,
.user-loginOut * {
  padding-inline: 2px;
}
</style>