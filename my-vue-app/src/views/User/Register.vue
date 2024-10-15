<template>
    <div class="register-page">
      <h1>注册页面</h1>
      <div class="register-form">
        <p>用户名由字母、数字、下划线构成，*注释的项必须填写。</p>
        <form @submit.prevent="register">
          <div>
            <label for="username">*用户名称:</label>
            <input type="text" id="username" v-model="user.username" required>
          </div>
          <div>
            <label for="password">*用户密码:</label>
            <input type="password" id="password" v-model="user.password" required>
          </div>
          <div>
            <button type="submit">注册</button>
          </div>
        </form>
      </div>
      <ToHome/>
    </div>
  </template>
  
<script>
//   import { reactive, onMounted } from 'vue';
//   import axios from 'axios';
import axios from '../../axios';
import ToHome from '../../components/ToHome.vue';
export default {
name: 'Register',
data() {
    return {
    user: {
        username: '',
        password: ''
    },
    // notices: ''
    };
},

methods: {
  register() {
      axios.post("/user/register", this.user)
        .then(response => {
          const userdata = response.data;
          localStorage.setItem('userdata', JSON.stringify(userdata));
          console.log('注册成功:', response.data);
          this.$router.push({ name: 'Home' });
        })
        .catch(error => {
          console.error('注册失败:', error);
        });
     }
    },
components: {
    ToHome
  }

// props: {
//     notices,
// }
// methods: {
//   register() {
//     // 发送注册请求到后端
//     axios.post('/RegisterServlet', this.user)
//       .then
// }
// setup() {
//   const user = reactive({
//     username: '',
//     password: ''
//   });
//   const notices = ref('');

//   onMounted(() => {
//     // 假设从服务端获取通知信息
//     // 这里可以使用 axios 获取或者通过 Vuex 获取
//   });

//   const register = () => {
//     // 发送注册请求到后端
//     axios.post('/RegisterServlet', user)
//       .then(response => {
//         // 处理响应
//         if (response.data.notices) {
//           notices.value = response.data.notices;
//         }
//       })
//       .catch(error => {
//         // 处理错误
//         console.error('注册失败:', error);
//       });
//   };

//   return {
//     user,
//     notices,
//     register
//   };
// }
};
</script>
  
<style scoped>
</style>