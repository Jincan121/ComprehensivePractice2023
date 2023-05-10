<template>
    <div class="tag">
        <div   ref="container" class="sidebar" style="width: 80px;">
            
                <template>
                    <van-sidebar v-model="activeKey">
                        <van-sidebar-item title="选集" to="/main/search/tag/1" />
                        <van-sidebar-item title="节日" to="/main/search/tag/2"/>
                        <van-sidebar-item title="词牌" to="/main/search/tag/3"/>
                        <van-sidebar-item title="主题" to="/main/search/tag/4"/>
                        <van-sidebar-item title="地点" to="/main/search/tag/5"/>
                        <van-sidebar-item title="时令" to="/main/search/tag/6"/>
                        <van-sidebar-item title="人物" to="/main/search/tag/7"/>
                        <van-sidebar-item title="写景" to="/main/search/tag/8"/>
                        <van-sidebar-item title="抒情" to="/main/search/tag/9"/>
                        <van-sidebar-item title="花鸟" to="/main/search/tag/10"/>
                        <van-sidebar-item title="体裁" to="/main/search/tag/11"/>

                    </van-sidebar>
                </template>
           
        </div>

        <div id="tagpage" >
            <template>

                <router-view>
                </router-view>
            </template>

        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            activeKey: 0,
            container: null,
        };
    },
    mounted() {
    this.container = this.$refs.container;
  },
};
</script>

<style>
.sidebar {
    height: 100%;
}

.tag {
    display: flex;
    position: relative;
}

.tagpage {
    margin-right: 0%;
    margin-left: 80xp;
}
</style>