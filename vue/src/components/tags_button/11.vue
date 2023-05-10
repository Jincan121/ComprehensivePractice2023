<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">体裁</van-tag>
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
            taglist: ['乐府','乐歌','咏史','婉约','民歌','民谣','田园','讽刺','豪放','豪迈','赞美','边塞','长诗']
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