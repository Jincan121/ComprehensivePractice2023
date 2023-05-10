<template>
    <div class="contentJu">
       

        <div>
            

        </div>
        <!--  name="slide-fade"对应 
      .slide-fade-enter-active .slide-fade-leave-active .slide-fade-leave-active .slide-fade-enter
      等几个类名，如果没有设置name，则对应.v-enter-active .v-leave-to等 -->
      <div class="cardItem">
        <v-touch v-on:swipeleft="changeDocState()">
        <transition name="slide-fade">
            <div class="card" :style="`background:${cardInfo.color}`" :key="cardInfo.key" @click="open(cardInfo.key)">
                <div class="card-ju">{{ cardInfo.ju }}</div>
                <div class="card-poet">{{ cardInfo.poet }}</div>
            </div>
        </transition>
        </v-touch>
      </div>
        
        </div>
</template>
<script>
export default {
    data() {
        return {
            key: 1,
            show: true,
            velocityShow: false,
            cardInfo: { key: '71169', ju: '路漫漫其修远兮\n吾将上下而求索\n', poet: '屈原', color: 'white' },
            cardList: [
                { key: 'card1', ju: '登临送目\n正故国晚秋\n天气初肃\n', poet: '王安石', color: 'white' },
                { key: 'card2', ju: '烟水茫茫\n千里斜阳暮\n山无数\n乱红如雨\n不记来时路\n', poet: '秦观', color: 'white' },

            ],
            index: 0,
        }
    },
    methods: {
        async changeDocState() {
            console.log('切换')
            

            const { data: res } = await this.$http.post("ju/rand");
            console.log(res);

            this.cardInfo.ju=res.content;
            this.cardInfo.key=res.poetryID;
            this.cardInfo.poet=res.poetName;
            console.log(this.cardInfo);

        },
        async open(key)
        {
            console.log(key);

            const { data: res }=await this.$http.post("/poetry/searchByID?id="+key);

            if(res!='error')
            {
                this.$router.push({
                path:"/poetry",
                query:{id:key}
            });
            }
        }
    }
}
</script>
  
<style lang="less" scoped>
@import "@/assets/font/font.css";


.contentJu {
    position: relative;
    display: flex;
    margin-left: 25px;
    .cardItem
    {
        height: 100%;
    }
}



.card {
    width: 80%;
    
    border: 1px solid #888;
    border-radius: 6px;
    box-shadow: 5px 5px 3px #888888;
    /* 定位采用absolute，避免出现动画不流畅的问题 */
    position: absolute;
    top: 60px;

    font-size: 30px;
    font-family: 'FangSong';
    
    

}

.card-ju {

    position: right;

    writing-mode: vertical-rl;
    white-space: pre-wrap;
    float: right;
}

.card-poet {
    position: left;

    white-space: pre-wrap;
    writing-mode: vertical-rl;

}



/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
/* 推荐移入和移出的运动曲线保持一致 */
.slide-fade-enter-active {
    transition: all .5s ease-in-out;
}

.slide-fade-leave-active {
    transition: all .5s ease-in-out;
}


/* 移入前和移出后状态 */
.slide-fade-enter {
    transform: translateX(10%);
    opacity: 0;
}

.slide-fade-leave-to

/*.slide-fade-leave-active  用于 2.1.8 以下版本  */
    {
    transform: translateX(-10%);
    opacity: 0;
}
</style>
