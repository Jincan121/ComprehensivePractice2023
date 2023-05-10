<template>
    <div id="userPage">
        <div class="user-profile">
            <div class="info">
                <van-image v-if="logo==1" round :src="require('@/assets/pic/logo/1.png')"/>
                <van-image v-if="logo==2" round :src="require('@/assets/pic/logo/2.jpg')"/>
                <h3 class="name">
                    {{ username}}
                    <br />
                    <van-tag size="mini">{{this.tag}}</van-tag>
                </h3>
            </div>
            <van-row>
                <van-col span="8">
                    <p>0</p>
                    <p>动态</p>
                </van-col>
                <van-col span="8">
                    <p>0</p>
                    <p>关注</p>
                </van-col>
                <van-col span="8">
                    <p>0</p>
                    <p>粉丝</p>
                </van-col>
            </van-row>
        </div>
        <van-row class="user-links">
            <van-col span="8">
                <van-icon name="newspaper-o" color="#f03d37" @click="toUserWrite"/>我的作品
            </van-col>
            <van-col span="8">
                <van-icon name="star-o" color="#f00" @click="toUserCol"/>我的收藏
            </van-col>
            <van-col span="8">
                <van-icon name="tosend" color="#f03d37" @click="toUserNotice"/>关注列表
            </van-col>
        </van-row>

        <van-cell-group class="user-group">
            <van-cell icon="edit" title="编辑资料" to="/user/profile" is-link />
            <van-cell icon="chat-o" title="联系客服" to="/user/chat" is-link />
            <van-cell icon="setting-o" title="系统设置" is-link />
            <van-cell icon="warning-o" title="退出登录" to="/login" is-link />
        </van-cell-group>

    </div>
</template>
  
<script>
export default {
    data() {
        return {
            tag:'',
            username:'0',
            logo:'1',
        }
    }
    ,
    async created() {

        //console.log(this.$store.getters.getUser.UID);
        var UID = window.sessionStorage.getItem('UID');

        const {data:res}= await this.$http.post("user/findUsernameByUID?UID="+UID);
        this.username=res.username;
        if(window.sessionStorage.getItem('isLogin') == 'true')
        {
            this.tag='普通用户';
        }
        else
        {
            this.tag= '未登录';
        }
        const {data:res1} =await this.$http.post("/user/findImageByUID?UID="+UID);
        this.logo=res1.image;
    },
    methods:
    {
        toUserWrite(){
            this.$router.push({path:"/userWrite"});
        },
        toUserCol(){
            this.$router.push({path:"/userCol"});
        },
        toUserNotice(){
            this.$router.push({path:"/userNotice"});
        }
    }

}

</script>
  
<style lang="less" scoped>
.cover {
    background-color: #f03d37;
    padding: 50px;
    text-align: center;

}

.user {
    &-profile {
        width: 100%;
        display: block;
        background: #a80404;
        color: #fff;

        .info {
            display: flex;
            padding: 20px;
            align-items: center;

            .van-image {
                width: 64px;
                height: 64px;
            }

            .name {
                font-size: 24px;
                font-weight: normal;
                margin-left: 10px;
            }

            .van-tag {
                background: #fff;
                color: #f03d37;
            }
        }

        p {
            margin: 0;
            text-align: center;
        }
    }

    &-group {
        margin-bottom: 15px;
    }

    &-links {
        padding: 15px 0;
        font-size: 12px;
        text-align: center;
        background-color: #fff;

        .van-icon {
            display: block;
            font-size: 24px;
            padding-bottom: 5px;
        }
    }
}</style>
  