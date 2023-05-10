<template>
    <div>

        <van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
            <van-cell v-for="item in list" :key="item.id" :title=item.name
                :label="item.dynasty + ' ' + item.poet_name" @click="ClickItem(item)" />

        </van-list>
    </div>
</template>
<script>
export default {
    inject: ['reload'],
    data() {
        return {
            list: [],
            loading: false,
            finished: false,
            peotryItemReturn:
            {
                id: '',
                star: '',
                content: '',
                name: '',
                dynasty: '',
                tag: '',
                peotName: '',
            },
            peotryItem:
            {
                id: '1',
                name: '关雎',
                dynasty: '先秦',
                peotName: '佚名',

            }
        };
    },
    methods: {
        async onLoad() {
            // 异步更新数据
            // setTimeout 仅做示例，真实场景中一般为 ajax 请求
            var UID = window.sessionStorage.getItem('UID');
            const { data: res } = await this.$http.post("poetry/recommend?UID="+UID);
                console.log(res);
            setTimeout(() => {
                for (let i = 0; i < 10; i++) {
                    this.list.push(res[i]);
                    
                }
                //console.log(this.list);
                                // 加载状态结束
                this.loading = false;

                // 数据全部加载完成
                if (this.list.length >= 65535) {
                    this.finished = true;
                }
            }, 1);

        },
        ClickItem(item) {
            console.log(item);
            this.reload();
            this.$router.push({
                path:"/poetry",
                query:{id:item.id}
            });
        }
    },
};
</script>
  
<style></style>
