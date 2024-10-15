<template>
    <UserHeader :isSetting = "true"/>
    <div class="user">
      <h1>用户页面</h1>
      <UserInfo :user="user"/>
      <UserPosts :posts="userPosts"/>
      <router-link to="/usersetting">设置</router-link>

      <!-- <ToHome/> -->
    </div>
</template>
  
<script>
import axios from '../../axios.js';
import UserHeader from '../../components/User/UserHeader.vue';
import UserInfo from '../../components/User/UserInfo.vue';
import UserPosts from '../../components/User/UserPosts.vue';
// import ToHome from '../../components/ToHome.vue';

export default {
  name: "User",
  components: {
    UserHeader,
    UserInfo,
    UserPosts,
    // ToHome,
  },
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
        avatar: '',
        registrationDate: '',
      },
      userPosts: [],
      isSetting: true,
    };
  },
  created() {
    const userdata = JSON.parse(localStorage.getItem('userdata'));
    // console.log(userdata);
    this.user = userdata;
    this.loadpostsbyauthor(userdata.username);
    // console.log(userdata.username);
  },
    methods: {
      loadpostsbyauthor(username) {
      axios.post('/post/pages/author',username)
        .then(response => {
          this.userPosts = response.data;
          console.log('帖子数据:', this.posts);
        // this.username = this.$store.state.username; // 假设你使用了 Vuex 存储用户信息
        }).catch(error => {
        console.error('There was an error fetching the posts:', error);
      });
     },
    }
};
</script>

<style scoped>
.user {
  display: flex;
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f2f2f2; 
}
.user-info {
  flex: 1;
  padding: 20px;
  border-right: 1px solid #ccc; /* 分隔线 */
}
.user-posts {
  flex: 2;
  padding: 20px;
}
</style>