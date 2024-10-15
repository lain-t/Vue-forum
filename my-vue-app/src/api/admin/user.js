import axios from "axios"

export function registerblog(data) {
    return axios.post("/user/register", data)
}

export function loginblog(username, password) {
    return axios.post("/user/login",{username, password})
}

export function quitblog() {
    return axios.post("/user/quit")
}