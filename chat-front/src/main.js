import { createApp } from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "@/router/index.js";
import axios from "axios";

const app = createApp(App);

//엑시오스 요청을 보내는 모든 요청을 인터셉트해서 main.js에서 토큰을 세팅
axios.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers["Authorization"] = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    // 인터셉터를 무시하고, 사용자의 본래요청인 화면으로 라우팅
    return Promise.reject(error);
  }
);

app.use(router);
app.use(vuetify);
app.mount("#app");
