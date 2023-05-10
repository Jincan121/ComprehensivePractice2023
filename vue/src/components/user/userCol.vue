<template>
    <div>
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>



        <van-sticky :offset-top="45">
            <div class="topBar">
                <van-nav-bar left-text="返回" left-arrow @click-left="onClickLeft" title="我的收藏">

                </van-nav-bar>
            </div>
        </van-sticky>

        <van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
            <van-cell v-for="item in list" :key="item.id" :title=item.name :label="item.dynasty + ' ' + item.poet_name"
                @click="ClickItem(item)" style="white-space: pre-wrap;" icon="delete-o" />


                
        </van-list>


    </div>
</template>

<script>
import router from '@/router';
import { Dialog } from 'vant';
export default {
    data() {
        return {
            searchKey: "",
            list: [],
            loading: false,
            finished: false,
        };
    },
    methods: {
        onClickLeft() {
            this.$router.back();

        },
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
            var UID = window.sessionStorage.getItem('UID');
            const { data: res } = await this.$http.post("user/searchCollectByUID?UID=" + UID);

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
        async ClickItem(item) {
            Dialog.confirm({
                title: '确认删除',
                message: '此操作不可恢复',
            })
                .then(async () => {
                    // on confirm
                    var UID = window.sessionStorage.getItem('UID');
                    const { data: res } = await this.$http.post("/writes/deleteWrite?UID=" + UID +"&id=" +item.id);
                    console.log(res);
                    if(res=='success')
                    {
                        this.$router.go(0);
                    }

                })
                .catch(() => {
                    // on cancel
                });
        }
    },


    components: { router }
};

</script>

<style></style>