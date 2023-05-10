<template>
    <div id="peotryitem">
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>

        <div class="topBar">
                <van-nav-bar left-text="返回" left-arrow @click-left="onClickLeft" title="飞花"  >
                    

                </van-nav-bar>
            </div>
        <van-grid style="border: 1px solid #bdbdbd;" border :gutter="10"> 
            <van-grid-item icon="photo-o" text="风" to="/flower/feng"/>
            <van-grid-item icon="photo-o" text="花" to="/flower/hua"/>
            <van-grid-item icon="photo-o" text="雪" to="/flower/xue"/>
            <van-grid-item icon="photo-o" text="月" to="/flower/yue"/>
        </van-grid>

        <router-view>

        </router-view>
    </div>
</template>

<script>
export default {
    data() {
        return {

        }
    },
    async created() {

    },


    methods: {
        onClickLeft() {
            this.$router.push({path:'/main/write/push'})

        },

    },
};
</script>

<style></style>
