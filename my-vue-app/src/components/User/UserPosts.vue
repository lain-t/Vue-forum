<!-- UserPosts.vue -->
<template>
    <div class="user-posts">
      <h2>帖子列表</h2>
      <table id="forumTable">
        <tr>
          <!-- <th>帖子ID</th> -->
          <th>标题</th>
          <th>用户</th>
          <!-- <th>内容</th> -->
          <th>发布时间</th>
        </tr>
        <tr v-for="post in posts" :key="index">
          <!-- <td>{{ post.id }}</td> -->
          <td><router-link :to="{name: 'Post', params: { postIndex: post.id}}">{{ post.title }}</router-link></td>
          <td>{{ post.author }}</td>
          <!-- <td>{{ post.content }}</td> -->
          <td>{{ post.date }}</td>
        </tr>
      </table>
    </div>
  </template>
  
<script>
export default {
  props: {
    posts: {
      type: Array,
      required: true
    }
  }
};
</script>
  
<style scoped>
#forumTable {
  width: 100%;
  border-collapse: collapse;
  margin: 20px 0;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);

  white-space: nowrap;
  overflow: hidden; /* 隐藏溢出的文本 */
  text-overflow: ellipsis; /* 使用省略号表示文本被截断 */
}
#forumTable th {
  background-color: #42b983;
  color: white;
  text-align: left;
  padding: 10px;
  border-bottom: 1px solid #ddd;
}
#forumTable td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}
#forumTable td:first-child,
#forumTable th:first-child{
  width: 70%;
}
#forumTable td:last-child,
#forumTable th:last-child{
  width: 25%;
}

#forumTable td a {
  color: #42b983;
  text-decoration: none;
}
#forumTable td a:hover {
  text-decoration: underline;
}

/* 条纹效果 */
#forumTable tr:nth-child(even) {
  background-color: #f9f9f9;
}

/* 鼠标悬停效果 */
#forumTable tr:hover {
  background-color: #f1f1f1;
}
</style>