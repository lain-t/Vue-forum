import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router';
import App from '../App.vue'
import Test from '../components/Test.vue'

//veiws
import Home from '../views/Home.vue'

import User from '../views/User/User.vue'
import UserInfo from '../components/User/UserInfo.vue';
import UserPosts from '../components/User/UserPosts.vue';
import UserSetting from '../views/User/UserSetting.vue'


import Login from '../views/User/Login.vue'
import Quit from '../views/User/Quit.vue'
import Register from '../views/User/Register.vue'

import Post from '../views/Post/Post.vue'


const routes = [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta: {
        title: '主页'
      }
      },
      {
        path: '/user',
        name: 'User',
        component: User,
        meta: {
          title: '用户'
        },
        // children: [
        //   {
        //     path: 'userinfo',
        //     component: UserInfo,
        //     meta: {
        //       title: '博客设置'
        //     }
        //   },
        //   {
        //     path: 'userposts', // 确保路径名正确
        //     component: UserPosts,
        //     meta: {
        //       title: '设置'
        //     }
        //   }
        // ]
      },
      {
        path: '/usersetting',
        name: 'UserSetting',
        component: UserSetting,
        meta: {
          title: '用户'
        }
      },
      {
        path: '/login',
        name: 'Login',
        component: Login,
        meta: {
          title: '登录'
        }
      },
      {
        path: '/quit',
        name: 'Quit',
        component: Quit,
        meta: {
          title: '退出'
        }
      },
      {
        path: '/register',
        name: 'Register',
        component: Register,
        meta: {
          title: '博客设置'
        }
      },
      {
        path: '/post/:postIndex',
        name: 'Post',
        component: Post,
        meta: {
          title: '博客设置'
        }
      },
  ];

const routes0 = [
  {
    path: '/',
    component: Test,
    // children: [
    //   {
    //     path: 'test', // 注意这里没有斜杠，表示它是根路径下的子路径
    //     component: Test,
    //     meta: {
    //       title: '博客设置'
    //     }
    //   },
    //   {
    //     path: 'welcome', // 确保路径名正确
    //     component: HelloWorld,
    //     meta: {
    //       title: '设置'
    //     }
    //   }
    // ]
  }
];
  
const router = createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    // history: createWebHashHistory(), 带#号
    history: createWebHistory(),
    routes, // `routes: routes` 的缩写
})

// ES6 模块导出语句，它用于将 router 对象导出，以便其他文件可以导入和使用这个对象
export default router