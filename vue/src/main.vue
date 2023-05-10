<template>
    <!-- 顶部 -->



    <div>
        <van-sticky>
            <van-nav-bar title="楚辞·诗源" >
            </van-nav-bar>
        </van-sticky>
        <router-view>

        </router-view>


        <!-- 底部导航栏 -->
      <div id="bottom">

      
        <van-tabbar v-model="active" active-color="#ee0a24" route>
            <van-tabbar-item replace to="/main/push/ju">
                <span>推送</span>
                <template #icon="props">
                    <img :src="props.active ? icon.active : icon.inactive" />
                </template>
            </van-tabbar-item>
            <van-tabbar-item icon="search" replace to="/main/search/tag/1">搜索</van-tabbar-item>
            <van-tabbar-item icon="setting-o" replace to="/main/write/push">社区</van-tabbar-item>
            <van-tabbar-item icon="setting-o" replace to="/main/user">用户</van-tabbar-item>
        </van-tabbar>
    </div>
    </div>
</template>
  
<script>
import router from './router';

export default {
    data() {
        return {
            active: 0,
            icon: {
                active: "https://img01.yzcdn.cn/vant/user-active.png",
                inactive: "https://img01.yzcdn.cn/vant/user-inactive.png",
            },
        };
    },
    methods:{
        toUser()
        {
            this.$router.push({path:"/main/user"})
        }
    },
    components: { router }
};
</script>
  
<style>
.bottom{
    padding-bottom: 150xp;
}

</style>
  