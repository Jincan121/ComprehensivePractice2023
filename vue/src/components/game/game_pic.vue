<template>
    <div>
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>

        <div class="topBar">
            <van-nav-bar left-text="返回" left-arrow @click-left="onClickLeft" title="猜句">


            </van-nav-bar>
        </div>
        <div class="caijuPic" style="margin-top: 20px; margin-left: 20px;">
            <van-image v-show="currentPage == 1" width="350" height="200" :src="require('@/assets/pic/caiju/1.png')" />
            <van-image v-show="currentPage == 2" width="350" height="200" :src="require('@/assets/pic/caiju/2.png')" />
            <van-image v-show="currentPage == 3" width="350" height="200" :src="require('@/assets/pic/caiju/3.png')" />
            <van-image v-show="currentPage == 4" width="350" height="200" :src="require('@/assets/pic/caiju/4.png')" />
            <van-image v-show="currentPage == 5" width="350" height="200" :src="require('@/assets/pic/caiju/5.png')" />
        </div>


        <div>

            <van-radio-group v-model="radio" style="margin-left: 30px;margin-top: 20px;">
                
                <van-radio  name="0" checked-color="#ee0a24"
                style="margin-top: 15px; font-size: large;">{{ juList[currentPage-1][0] }}</van-radio>
                <van-radio  name="1" checked-color="#ee0a24"
                style="margin-top: 15px; font-size: large;">{{ juList[currentPage-1][1] }}</van-radio>
                <van-radio  name="2" checked-color="#ee0a24"
                style="margin-top: 15px; font-size: large;">{{ juList[currentPage-1][2] }}</van-radio>
                <van-radio  name="3" checked-color="#ee0a24"
                style="margin-top: 15px; font-size: large;">{{ juList[currentPage-1][3] }}</van-radio>
                
            </van-radio-group>
        </div>


        <div style="margin-top: 30px; margin-left: 43%;">
            <van-button type="warning" @click="submit">确认</van-button>
        </div>
        <div style="margin-top: 30px;">
            <van-pagination v-model="currentPage" :total-items="24" :items-per-page="5" />
        </div>
    </div>
</template>

<script>
import { Toast } from 'vant';
export default {
    data() {
        return {
            picSrcList: [
                '@/assets/pic/caiju/1.png', '@/assets/pic/caiju/1.png', '@/assets/pic/caiju/1.png', '@/assets/pic/caiju/1.png', '@/assets/pic/caiju/1.png'
            ],
            radio:'',
            currentPage: 1,
            testSrc: '@/assets/pic/caiju/1.png',
            juList:[ 
            ['乱云低薄暮，急雪舞回风 —— 杜甫','柴门闻犬吠，风雪夜归人 —— 刘长卿','三月雪连夜，未应伤物华 —— 温庭筠','朝来出门忘，知在雪山中 —— 皇甫冉'],
                ['初晴山院里，何处染嚣尘 —— 王勃','儿童相见不相识，笑问客从何处来 —— 贺知章','爆竹声中一岁除，春风送暖入屠苏 —— 王安石','燎火委虚烬，儿童炫彩衣 —— 刘禹锡'],
                ['独坐幽篁里，弹琴复长啸 —— 王维','名士竹林隈，鸣琴宝匣开 —— 李峤','秦筝何慷慨，齐瑟和且柔 —— 曹植','睢园绿竹，气凌彭泽之樽 —— 王勃'],
                ['只在此山中，云深不知处 —— 贾岛','借问酒家何处有，牧童遥指杏花村 —— 杜牧','千山鸟飞绝，万径人踪灭 —— 柳宗元','举手可近月，前行若无山 —— 李白'],
                ['马作的卢飞快，弓如霹雳弦惊 —— 辛弃疾','老夫聊发少年狂，左牵黄，右擎苍 —— 苏轼','君不见走马川行雪海边，平沙莽莽黄入天 —— 岑参','黄沙百战穿金甲，不破楼兰终不还 —— 王昌龄']
                
            ],
            anserLisr:[1,2,0,0,1],
        }
    },
    methods: {
        onClickLeft() {
            this.$router.push({path:'/main/write/push'})

        },
        submit(){
            if(this.radio == this.anserLisr[this.currentPage-1]) {
                Toast("答对啦");
                if(this.currentPage!=5)
                {
                    Toast("答对啦");
                    this.currentPage=this.currentPage+1;
                }else
                {
                    Toast.success('完成答题');
                }
                
                this.radio='';
            }
            else{

                Toast("答错了");
            }
        }
    }
}


</script>

<style lang="less" scoped></style>