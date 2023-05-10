<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">地点</van-tag>
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
            taglist: ["乡村", 
            '写山', '写水', '农村','地名', '宫廷', '寺庙', '山水', '景点','江南', '登楼','西湖','长江','黄河']
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