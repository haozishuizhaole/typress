<template>
  <header>
    <p>
      <!--使用 router-link 组件进行导航 -->
      <!--通过传递 `to` 来指定链接 -->
      <!--`<router-link>` 将呈现一个带有正确 `href` 属性的 `<a>` 标签-->
      <router-link class="routerLink" to="/">Go to Home</router-link>
      <router-link class="routerLink" to="/article">Go to Article</router-link>
    </p>
  </header>

  <main>
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
  </main>
</template>

<script setup>
</script>

<style scoped>
header{
  width: 100%;
  display: block;
}
.routerLink {
  margin: 0 20px 0 20px;
}
</style>
