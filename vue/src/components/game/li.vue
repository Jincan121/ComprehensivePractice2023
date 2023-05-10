<template>
    <div>
        <div style="display: inline-flex;">
            <div style="font-size: 25px;font-family:'STXingkai';margin-left: 30px;margin-top: 30px; ">
                李白
            </div>
            <van-button disabled type="primary" style="margin-left: 200px; margin-top: 5px;" size="mini"
                color="#141414">通关以解锁</van-button>
        </div>

        <div style="margin-left: 20px;  color: brown; margin-top: 20px;">
            简介
        </div>

        <div style="margin-left: 15px;">
            李白（701年—762年），字太白，号青莲居士，又号“谪仙人”。是唐代伟大的浪漫主义诗人，被后人誉为“诗仙”。
        </div>
        <van-divider style=" border-color: rgb(121, 121, 121);" />

        <div style="margin-left: 15px; font-size: smaller;">
            *背诵10句不同作品中的诗句即可通关，并解锁人物立绘
        </div>

        <div>
            <div v-for="i in 10">
                <input style="height: 25px; width: 80%; margin-left: 10px;text-align: center; margin-top: 10px;"
                    v-model="inputList[i - 1]" />
                <van-icon v-if="reslist[i] == 1" name="success" />

                <van-icon v-if="reslist[i] == -1" name="cross" />
            </div>


        </div>
        <van-button color="linear-gradient(to right, #ff6034, #ee0a24)" style="margin-top: 20px; margin-left: 20px;" @click="submitJu">
            提交
        </van-button>
        <div v-show="false">
            <van-button @click="switchValue" style="height: 20px; width: 20px;">
            </van-button>
            <van-icon v-if="isShow" name="success" />

            <van-icon v-if="!isShow" name="cross" />

        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {

            inputList: ['', '', '', '', '', '', '', '', '', ''],
            reslist: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
            isShow: true,
        }
    },
    methods:{
        switchValue() {
            this.isShow = !this.isShow;
        },
        async submitJu() {
            this.switchValue();
            const {data:res} =await this.$http.post("game/poetLevel?poet=李白&content=" + this.inputList);
            console.log(res);
            for(var i=0;i<10;i++)
            {
                this.switchValue();
                if(res[i] == 'true')
                {
                    this.switchValue();
                    this.reslist[i]=1;
                }
                if(res[i] == 'false')
                {
                    this.switchValue();
                    this.reslist[i]=-1;
                }
                if(res[i] == 'empty')
                {

                }
            }
            console.log(this.reslist);
        },
        
    }
}

</script>

<style lang="less" scoped></style>