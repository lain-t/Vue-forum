<!-- UserInfo.vue -->
<template>
    <div class="user-info">
        <!-- <img :src="user.avatar" alt="avatar" class="avatar"> -->
        <div class="info">
            <h2>{{ user.name }}</h2>
            <p>性别：{{ user.gender }}</p>
            <p>入站日期：{{ user.registrationDate }}</p>
            <p :show = "user.email">邮箱：{{ user.email }}</p>
            <p>联系方式：{{ user.phone }}</p>
        </div>
    </div>
</template>
  
<script>
export default {
props: {
    user: {
    type: Object,
    required: true
    }
}
};
</script>

<style scoped>
/* .user-info {
display: flex;
align-items: center;
}
.avatar {
width: 100px;
height: 100px;
border-radius: 50%;
margin-right: 20px;
}
.info h2 {
margin: 0;
font-size: 24px;
}
.info p {
margin: 5px 0;
} */
</style>