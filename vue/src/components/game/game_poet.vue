<template>
    <div >
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>

        <div class="topBar">
            <van-nav-bar left-text="返回" left-arrow @click-left="onClickLeft" title="没想好叫啥">


            </van-nav-bar>
        </div>
        <van-tabs type="card">
            <van-tab title="李白" to="/game_p/li"></van-tab>
            <van-tab title="杜甫" to="/game_p/du"></van-tab>
            <van-tab title="苏轼" to="/game_p/su"></van-tab>
            <van-tab title="李清照" to="/game_p/yi"></van-tab>
        </van-tabs>

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
            this.$router.push({ path: '/main/write/push' })

        },

    },
};
</script>

<style></style>
