<template>
  <div>
    <ul>
      <!-- 使用 <router-link> 创建文章链接 -->
      <router-link :to="'/article/' + article.articleId"
                   v-for="article in articles"
                   :key="article.articleId">
        <li>{{ article.articleTitle }}</li>
      </router-link>
    </ul>
    <router-link :to="'/article?pageNo='+(Number(this.pageNo)+1) + '&pageSize='+this.pageSize" v-if="this.hasMore">
      下一页
    </router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      articles: {},
      articlesTotalCount: 0,
      pageNo: 1, // 页码
      pageSize: 10, // 每页个数
      hasMore: false
    };
  },
  methods: {
    fetchData() {
      axios.post('/admin/article/findArticles', {
        pageNo: this.pageNo,
        pageSize: this.pageSize
      })
          .then((response) => {
            const data = response.data.data;
            console.log(data)
            this.articles = data.list;
            this.articlesTotalCount = data.total
            this.hasMore = Math.max(this.pageNo - 1, 0) * this.pageSize < this.articlesTotalCount
          })
          .catch((error) => {
            console.error('请求数据时出错：', error);
          });
    },

  },
  created() {
    this.pageNo = parseInt(this.$route.query.pageNo)
    this.pageSize = parseInt(this.$route.query.pageSize)
    this.fetchData()
  }
};
</script>
