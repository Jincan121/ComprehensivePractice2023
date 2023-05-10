<template>
    <div id="peotryitem">
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>
        <van-sticky :offset-top="45">
            <div class="topBar">
                <van-nav-bar left-text="返回" left-arrow @click-left="onClickLeft" color="rgb(219, 28, 28)">
                    <template #right>
                        <div>
                            <van-icon name="like" size="18" @click="like()" color="rgb(219, 28, 28)" />
                        </div>
                        <div style="margin-left: 20px;">
                            <van-icon name="star" size="18" @click="star()" color="rgb(219, 28, 28)" />
                        </div>

                    </template>

                </van-nav-bar>
            </div>
        </van-sticky>


        <div class="name">
            {{ peotryItem.name }}
        </div>

        <div class="poetAndDynasty">
            {{ poetAndDynasty }}
        </div>
        <div class="content">
            {{ '\n'+peotryItem.content }}
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            test: 'test',
            poetAndDynasty: '',
            peotryItem:
            {
                content: '',
                dynasty: '',
                id: '',
                name: '',
                poet_id: '',
                poet_name: '',
                star: '',
                tag: ''
            },
           
        }
    },
    async created() {
        const { data: res } = await this.$http.post("poetry/searchByID?" + "id=" + this.$route.query.id);
        this.peotryItem = res;
        console.log(this.peotryItem);
        this.poetAndDynasty = '[' + this.peotryItem.dynasty + '] ' + this.peotryItem.poet_name;
    },


    methods: {
        onClickLeft() {
            this.$router.back();

        },
        async like() {
            console.log('like');
            if (window.sessionStorage.getItem('isLogin') != 'true') {
                Toast('请登录');
            }
            else {
                var UID = window.sessionStorage.getItem('UID');
                const { data: res } = await this.$http.post("poetry/support?" + "UID=" + UID + "&id=" + this.peotryItem.id);
                this.$toast({
                    message: '点赞成功',
                    icon: 'like-o',
                });
            }
        },

        async star() {

            if (window.sessionStorage.getItem('isLogin') != 'true') {
                Toast('请登录');
            }
            else{
                var UID = window.sessionStorage.getItem('UID');
                const { data: res } = await this.$http.post("user/collect?" + "UID=" + UID + "&id=" + this.peotryItem.id);
                this.$toast({
                    message: '已收藏',
                    icon: 'star-o',
                });
            }

        }
    },
};
</script>

<style>
.name {
    margin-top: 45px;
    text-align: center;
    font-size: 30px;

}

.poetAndDynasty {
    margin-top: 15px;
    text-align: center;
    font-size: 15px;

}

.content {
    margin-top: 15px;
    position: relative;
    display: flex;
    font-size: 20px;
    margin-left: 35px;
    margin-right: 35px;
    white-space: pre-wrap;
    justify-content: center;

}
</style>
