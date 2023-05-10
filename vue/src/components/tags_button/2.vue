<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">节日</van-tag>
        </div>

        <div class="taglist">

            <van-grid :column-num="3" :gutter="10">

                <van-grid-item v-for ="item in taglist" :key="item" @click="toTag(item)">
                    <h4 style="font-family: 'FangSong'; font-size: 20px; text-align: center;font-weight: 400;">
                        {{ item}}
                    </h4>
            
                </van-grid-item>
            </van-grid>


        </div>

    </div>
</template>

<script>
export default {
    data() {
        return {
            taglist: ["七夕节",'中秋节', '元宵节' ,'寒食节','春节', '清明节', '端午节', '重阳节']
        };
    },
    methods:{
        toTag(item)
        {
            this.$router.push({
                path: "/tagList",
                query: { tag: item}
            });
        }
    }
}

</script>

<style>
.tagname {
    margin-top: 20px;
    margin-left: 20px;
    padding-bottom: 50px;
}

.taglist {
    margin-bottom: 30px;

}
</style>