<template>
  <!--  <div>-->
  <!--    <ul>-->
  <!--      <li v-for="item in items.list" :key="item.articleId">{{ item.articleTitle }}</li>-->
  <!--    </ul>-->
  <!--  </div>-->
  <div>
    <ul>
      <li><h1>{{article.articleTitle}}</h1></li>
      <li>{{article.articleContent}}</li>
      <li>发布时间：{{article.createTime}}</li>
      <li>修改时间：{{article.updateTime}}</li>
    </ul>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  data() {
    return {
      article: {},
    };
  },
  methods: {
    fetchData() {
      const formData = new FormData();
      formData.append('articleId', this.$route.params.id);
      axios.post('/admin/article/getArticleInfo', formData)
          .then((response) => {
            this.article = response.data.data;
            console.log(this.article)
          })
          .catch((error) => {
            console.error('请求数据时出错：', error);
          });
    },
  },
  created() {
    this.fetchData()
  }
};
</script>

<style scoped>

</style>