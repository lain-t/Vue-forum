import axios from "axios";
// const proxy = {
//     host: '127.0.0.1',
//     port: 80810,
//     protocol: 'http'
// }
const setting = {
    // baseURL: import.meta.env.VITE_APP_BASE_API,
    // baseURL: '/api',
    baseURL: 'http://192.168.0.5:8081',
    headers: {'Content-Type': 'application/json'},
    timeout: 7000,
}

const instance = axios.create(setting);
// 暴露
export default instance