// axios.js

import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://127.0.0.1:8080', // 设置基础URL
    timeout: 5000, // 设置超时时间
});

// 请求拦截器
instance.interceptors.request.use(
    (config) => {
        // 在请求发送前可以添加请求头等操作
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

// 响应拦截器
instance.interceptors.response.use(
    (response) => {
        // 在响应返回后可以对响应数据进行处理
        return response;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default instance;
