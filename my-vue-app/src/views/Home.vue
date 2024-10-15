<template>
    <UserHeader/>
    <!-- <your-component :key="componentKey"></your-component> -->
    <div class = "forum">
      <h1 style="text-align: left;">论坛主页</h1>
      <UserPosts :posts="posts" />
      <p v-show = "!username">登陆之后可以进行发帖</p>
      <div id = "postForm" v-show="username">
        <form @submit.prevent="submitPost">
          <input type="text" v-model="post.title" placeholder="输入帖子标题" required>
          <input type="text" v-model="post.content" placeholder="输入帖子内容" required>
          <button type="submit">发送</button>
        </form>
      </div>
  
    </div>

  </template>
  
<script>
import axios from '../axios';
import UserHeader from '../components/User/UserHeader.vue';
import UserPosts from '../components/User/UserPosts.vue';

export default {
  name: 'Home',
  data() {
    return {
      username: '',
      posts: [],
      post: {
        author: '',
        title: '',
        content: '',
        date: ''
      },
      isHome: true,
    };
  },
  components: {
    UserHeader,
    UserPosts
  },
  created() {
    this.loaduser();
    this.loadposts();
  },
  methods: {
    loaduser(){
      if (localStorage.getItem('userdata')) {
        const userData = JSON.parse(localStorage.getItem('userdata'));
        this.username = userData.username;
        this.post.author = userData.username;
      }
    },
    loadposts() {
      // 假设有一个 API 获取帖子数据
      axios.get('/post/pages/show').then(response => {
      this.posts = response.data;
      localStorage.setItem('postsdata', JSON.stringify(this.posts));
      console.log('帖子数据:', this.posts);
      // this.username = this.$store.state.username; // 假设你使用了 Vuex 存储用户信息
      }).catch(error => {
        console.error('There was an error fetching the posts:', error);
      });
     },
    submitPost() {
      axios.post('/post/create', this.post)
        .then(response => {
          console.log('Usersetting submitted successfully:', response.data);
          location.reload();
          // this.$forceUpdate();
        })
        .catch(error => {
          console.error('There was an error submitting the usersetting:', error);
        });
    }
  }
}


</script>

<style scoped>
  .forum {  
    /* font-family: Arial, sans-serif;  
    margin: 0;  
    padding: 20px;  
    background-color: #f2f2f2;   */
    padding: 10px;
    background-color: #f2f2f2; 
    text-align: center;
  }  

  #loginButton {
    position : absolute;
    top: 10px;
    right: 10px;
  }

  table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
  }

  th,
  td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }

  th {
    background-color: #f2f2f2;
  }

  #postForm {
    text-align: center;
    margin-top: 20px;
  }

  #postForm input[type="text"] {
    width:150px;
    padding: 10px;
    margin-right: 10px;
  }

  #postForm input[name="title"] {
    width: 100px;
  }

  #postForm input[name="content"] {
    width: 300px;
  }

  #postForm input[type="submit"] {
    padding: 10px 20px;
  }
</style>