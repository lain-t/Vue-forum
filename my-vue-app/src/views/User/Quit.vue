<template>
    <div class = "user-quit">
      <h2>您已成功退出系统。</h2>
      <ToHome/>
    </div>
  </template>
  
<script>
import ToHome from '../../components/ToHome.vue';

export default {
  name: 'Quit',
  components: {
    ToHome
  },
  created() {
    // localStorage.removeItem('userdata');
    // localStorage.clear();
  },
  // setup() {
  //   const router = useRouter();
  //   onMounted(() => {
  //     // 模拟移除用户信息的逻辑
  //     // 在Vue中，我们通常不会直接操作session，而是使用Vuex或本地存储来管理用户状态
  //     // 这里我们假设有一个全局状态管理或者本地存储来存储用户信息
  //     localStorage.removeItem('userBean');

  //     // 可以在这里执行其他清理操作，比如清除用户信息等
  //   });
  //   return {};
  // }
};
</script>
  
  <style scoped>
  /* 这里可以添加CSS样式 */
  </style>