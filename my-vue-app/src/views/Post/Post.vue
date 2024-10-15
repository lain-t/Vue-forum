<template>
    <UserHeader/>
    <div class="post" v-if="!editMode">
      <h1>{{ post.title }}</h1>
      <h3>作者：{{ post.author }}</h3>
      <p>发布时间：{{ post.date }}</p>
      <div class="content" v-html="post.content"></div>
    </div>
    <div v-else>
      <textarea v-model="post.title"></textarea>
      <textarea v-model="post.content"></textarea>
      <br>
      <button @click="cancelEdit">取消</button>
    </div>
    <div class = "adminAuthor" v-show="isAuthor && !editMode">
      <div id="settingButton">
        <button @click="editPost()">修改</button>
        <button @click="deletePost()">删除</button>
      </div>
    </div>
</template>
  
<script>
import axios from '../../axios'
import UserHeader from '../../components/User/UserHeader.vue';
export default {
name: 'Post',
data() {
  return {
    // username: '',
    isAuthor: false,
    editMode: false,
    post: {
      id: this.$route.params.postIndex,
      title: '',
      author: '',
      date: '',
      content: ''
    }
  };
},
components: {
  UserHeader,
},
// props: {  
//   postIndex: {
//     type: String,
//     required: true
//   }
// },
created() {
  // 假设帖子的数据通过一个API获取，你需要根据实际的API端点进行调整
  // const postIndex = ''; // 这里应该是从路由参数或其他地方获取的帖子索引
  // try {
  //   const response = await axios.get(`/api/posts/${postIndex}`);
  //   this.post = response.data;
  // } catch (error) {
  //   console.error('获取帖子数据失败:', error);
  // }
  // const postIndex = this.$route.params.postIndex;
  // const postData = JSON.parse(localStorage.getItem('postsdata'));
  // console.log(postData);
  this.fetchPost();
  this.loaduser();
  // this.post = postData[postIndex-1];
},
methods: {
  editPost() {
      this.editMode = true;
  },
  cancelEdit() {
      this.editMode = false;
  },
  loaduser() {
    const user = JSON.parse(localStorage.getItem('userdata'));
    // console.log(user.username);
    // console.log(this.post);
    if (user != null){
        if (String(user.username) == String(this.post.author)) {
        this.isAuthor = true;
      }
    }
  },
  fetchPost() {
    const postIndex = this.post.id;
    axios.post('/post/findpost',postIndex)
      .then(response => {
        this.post = response.data;
        this.loaduser();
      })
      .catch(error => {
        console.error('获取帖子数据失败:', error);
      })
    },
  deletePost() {
    // 简单验证，确保用户名和作者相同
    const postIndex = this.post.id;
    axios.post('/post/delete',postIndex)
      .then(response => {
        console.log(response.data);
        this.$router.replace({ path: '/user' });
      })
      .catch(error => {
        console.error('删除帖子数据失败:', error);
      })
    }   
  },
}
// setup() {
//     const post = ref({});

//     onMounted(async () => {
//     // 假设帖子的数据通过一个API获取，你需要根据实际的API端点进行调整
//     const postIndex = '1'; // 这里应该是从路由参数或其他地方获取的帖子索引
//     try {
//         const response = await axios.get(`/api/posts/${postIndex}`);
//         post.value = response.data;
//     } catch (error) {
//         console.error('获取帖子数据失败:', error);
//     }
//     });

//     return {
//     post
//     };
// }
</script>
<style scoped>
.post {
  top: 0;
  background-color: #f2f2f2;
}
.post h1 {
  font-size: 20px;
  font-weight: bold;
  margin-top: 0px;
  padding-top: 10px;
}
.post.content {
  font-size: 16px;
}
</style>