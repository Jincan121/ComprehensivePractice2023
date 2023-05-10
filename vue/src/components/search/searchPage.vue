<template>
    <div>
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>

        <form action="/">
            <van-search v-model.trim="searchKey" show-action placeholder="请输入搜索关键词" @input="searchEvent" @search="onSearch(searchKey)"
                @cancel="onCancel" />
        </form>

        <div class="searchList">

            <van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
                <van-cell v-for="item in list" :key="item.id" :title=item.name :label="item.dynasty + ' ' + item.poet_name"
                    @click="ClickItem(item)" />

            </van-list>
        </div>


    </div>
</template>

<script>
import router from '@/router';

export default {
    data() {
        return {
            searchKey: "",
            list: [],
            loading: false,
            finished: true,
        };
    },
    methods: {
        onSearch(val) {
            console.log(val);
            this.list = [];
            this.$emit('searchHandler', this.searchKey);
            this.loading = true;
            this.finished = false;
            this.onLoad();
        },
        onCancel() {
            this.$router.back();
        },
        searchEvent() {
            this.clearTimer();
            if (this.searchKey && this.searchKey.length > 0) {
                //获取当前延时函数的ID，便于后面clearTimeout清除该ID对应的延迟函数
                this.timer = setTimeout(() => {
                    this.onSearch(this.searchKey);
                }, 1000);
            } else {
                this.$emit('searchHandler', this.searchKey);
            }
        },

        clearTimer() {
            if (this.timer) {
                clearTimeout(this.timer);
            }
        },


        async onLoad() {
            const { data: res } = await this.$http.post("poetry/search?content=" + this.searchKey);
            
            var listSize = 100;
            if (res.length > 0 && res.length < 100) {
                listSize = res.length;
            }
            setTimeout(() => {
                for (let i = 0; i < listSize; i++) {

                    this.list.push(res[i]);
                    
                }
                console.log(this.list);
                // 加载状态结束
                this.loading = false;
                // 数据全部加载完成   
                this.finished = true;

            }, 1);
        },
        ClickItem(item) {
            console.log(item);
            this.$router.push({
                path: "/poetry",
                query: { id: item.id }
            });
        }
    },


    components: { router }
};

</script>

<style></style>