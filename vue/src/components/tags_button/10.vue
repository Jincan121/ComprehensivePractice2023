<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">花鸟</van-tag>
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
            taglist: ["写花", 
            '写鸟', '惜花', '柳树','梅花', '牡丹', '荷花', '菊花']
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