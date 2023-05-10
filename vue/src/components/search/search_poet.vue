<template>
    <div class="sp">
        <van-index-bar :index-list="indexList" class="Index" style="margin-bottom: 45px;">
            <van-index-anchor index="先秦">先秦</van-index-anchor>
            <van-cell title="屈原" @click="toPoet('屈原')"/>

            <van-index-anchor index="两汉">两汉</van-index-anchor>
            <van-cell title="贾谊" @click="toPoet('贾谊')"/>
            <van-cell title="曹操" @click="toPoet('曹操')"/>
            <van-cell title="班固" @click="toPoet('班固')"/>
            <van-cell title="张衡" @click="toPoet('张衡')"/>
            <van-index-anchor index="魏晋">魏晋</van-index-anchor>
            <van-cell title="曹植" @click="toPoet('曹植')"/>
            <van-cell title="左思" @click="toPoet('左思')"/>

            <van-index-anchor index="南北朝">南北朝</van-index-anchor>
            <van-cell title="鲍照" @click="toPoet('鲍照')"/>
            <van-cell title="庾信" @click="toPoet('庾信')"/>
            <van-cell title="谢朓" @click="toPoet('谢朓')"/>
            <van-index-anchor index="隋代">隋代</van-index-anchor>
            <van-cell title="孙万寿" @click="toPoet('孙万寿')"/>
            <van-index-anchor index="唐代">唐代</van-index-anchor>
            <van-cell title="李白" @click="toPoet('李白')"/>
            <van-cell title="杜甫" @click="toPoet('杜甫')"/>
            <van-cell title="白居易" @click="toPoet('白居易')"/>
            <van-cell title="王勃" @click="toPoet('王勃')"/>
            <van-cell title="李商隐" @click="toPoet('李商隐')"/>
            <van-cell title="杜牧" @click="toPoet('杜牧')"/>
            <van-cell title="柳宗元" @click="toPoet('柳宗元')"/>
            <van-cell title="刘禹锡" @click="toPoet('刘禹锡')"/>
            <van-index-anchor index="五代">五代</van-index-anchor>
            <van-cell title="李煜" @click="toPoet('李煜')"/>
            <van-index-anchor index="宋代">宋代</van-index-anchor>
            <van-cell title="苏轼" @click="toPoet('苏轼')"/>
            <van-cell title="欧阳修" @click="toPoet('欧阳修')"/>
            <van-cell title="辛弃疾" @click="toPoet('辛弃疾')"/>
            <van-cell title="李清照" @click="toPoet('李清照')"/>
            <van-cell title="陆游" @click="toPoet('陆游')"/>
            <van-cell title="王安石" @click="toPoet('王安石')"/>
            <van-index-anchor index="元代">元代</van-index-anchor>
            <van-cell title="马致远" @click="toPoet('马致远')"/>
            <van-cell title="关汉卿" @click="toPoet('关汉卿')"/>
            <van-index-anchor index="明代">明代</van-index-anchor>
            <van-cell title="袁枚" @click="toPoet('袁枚')"/>
            <van-index-anchor index="清代">清代</van-index-anchor>
            <van-cell title="黄宗羲" @click="toPoet('黄宗羲')"/>
            

        </van-index-bar>
    </div>
</template>

<script>
export default {
    data() {
        return {
            title:'',
            indexList: ['先秦', '两汉','魏晋','南北朝','隋代','唐代','五代','宋代','元代','明代','清代'],
        };
    },
    methods:{
        toPoet(poet)
        {
            console.log(poet);
            this.$router.push({
                path: "/tagList",
                query: { tag: poet}
            });
        }
    }
};
</script>

<style lang="less">
.sp {
   background-color: #e2e2e5;
 
   
}

</style>