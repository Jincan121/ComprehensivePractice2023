<template>
    <div>

        <van-image width="350" height="200" />

        <van-cell v-for="i in 7">
            <input v-for="j in 7" style="height: 25px; width: 25px; margin-left: 10px;text-align: center; " maxlength="1"
                v-model="p[i - 1][j - 1]" ref="ij" :readonly="i == j" @keyup.enter="toNext(i, j)"
                 />

            <van-button plain hairline style="margin-left: 5px;" type="info" color="brown" size="small" @click="submitJu(i)">
                提交
            </van-button>


            <van-icon v-if="juCor[i]" name="success" />

            <van-icon v-if="!juCor[i]" name="cross" />

        </van-cell>

        <div v-show="false">
            <van-button @click="switchValue" style="height: 20px; width: 20px;">
            </van-button>
            <van-icon v-if="isShow" name="success" />

            <van-icon v-if="!isShow" name="cross" />

        </div>



    </div>
</template>

<script>
import { Toast } from 'vant';


export default {
    data() {
        return {
            isShow: true,
            value: '',
            p: [['风', '', '', '', '', '', ''], ['', '风', '', '', '', '', ''], ['', '', '风', '', '', '', ''], ['', '', '', '风', '', '', ''], ['', '', '', '', '风', '', ''],
            ['', '', '', '', '', '风', ''], ['', '', '', '', '', '', '风']

            ],

            juCor: [0, 0, 0, 0, 0, 0, 0, 0],
            list: ['1', '2', '3', '4'],
            test: '',
            testkey: '',
        }
    },
    methods: {
        async toNext(i, j) {
            if (j == 7) {

            } else {
                this.$refs.ij[(i - 1) * 7 + j].focus();

            }

        },
        switchValue() {
            this.isShow = !this.isShow;
        },
        async submitJu(i) {
            
            console.log(this.juCor);
            this.switchValue();
            
            var pju = '';
            for (var item = 0; item < 7; item++) {
                pju = pju + this.p[i - 1][item];
            };
            console.log(pju);
            const { data: res } = await this.$http.post("game/Feihualing?content=" + pju);
            console.log(res);
            if (res == true) {
                this.switchValue();
                this.juCor[i] = 1;
                Toast.success('yes');
            };
            console.log(this.juCor);
        },
        back(i, j) {
            if (i == 0) {

            }
            else {
                this.$refs.ij[(i - 1) * 7 + j - 2].focus();
            }
        }
    }

}


</script>

<style lang="less" scoped>
.van-image {
    margin-top: 30px;
    display: flex;
    margin-left: 20px;
}

.test {
    margin-left: 100px;
}
</style>