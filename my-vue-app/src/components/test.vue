<template>
    <div>
      <p>{{ message }}</p>
      <button @click="reverseMessage">Reverse Message</button>
    </div>
  </template>
  
  <script>
  export default {
    // 指定挂载的 DOM 元素
    el: '#app',
  
    // 定义实例的数据对象
    data() {
      return {
        message: 'Hello Vue!'
      };
    },
  
    // 计算属性，基于依赖进行缓存
    computed: {
      reversedMessage() {
        return this.message.split('').reverse().join('');
      }
    },
  
    // 定义方法，可以在模板中通过事件调用
    methods: {
      reverseMessage() {
        this.message = this.reversedMessage;
      }
    },
  
    // 观察者，用于响应数据变化
    watch: {
      message(newVal, oldVal) {
        console.log(`Message changed from "${oldVal}" to "${newVal}"`);
      }
    },
  
    // 定义组件可以接收的外部数据
    props: {
      title: String
    },
  
    // 注册自定义组件
    components: {
      // 假设有一个名为 'custom-button' 的自定义组件
      CustomButton: {}
    },
  
    // 注册全局自定义指令
    directives: {
      // 假设有一个名为 'focus' 的自定义指令
      focus: {
        // 当绑定元素插入到 DOM 中时...
        inserted(el) {
          // 自动聚焦元素
          el.focus();
        }
      }
    },
  
    // 定义过滤器，用于文本格式化
    filters: {
      capitalize(value) {
        if (!value) return '';
        value = value.toString();
        return value.charAt(0).toUpperCase() + value.slice(1);
      }
    },
  
    // 指定组件使用的自定义 v-model 属性和事件
    model: {
      prop: 'checked',
      event: 'change'
    },
  
    // 提供依赖注入的能力
    provide() {
      return {
        color: 'red'
      };
    },
  
    // 生命周期钩子
    hooks: {
      onMounted() {
        console.log('Component is mounted.');
      },
      onUpdated() {
        console.log('Component is updated.');
      },
      onUnmounted() {
        console.log('Component is unmounted.');
      }
    },
  
    // 定义 HTML 模板
    template: '<div>{{ message }}</div>',
  
    // 使用 JavaScript 函数来渲染组件
    render() {
      return this.$createElement('div', { style: { color: this.color } }, this.message);
    },
  
    // 全局捕获 Vue 实例的错误
    errorCaptured(error, instance, info) {
      console.error(`Error captured: ${info}`);
    },
  
    // 定义组件可以触发的事件
    emits: ['change']
  };
  </script>
  
  <style scoped>
  /* 组件的局部样式 */
  button {
    margin-top: 10px;
  }
  </style>