<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">选集</van-tag>
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
import { shallowReactive } from 'vue';

export default {
    data() {
        return {
            taglist: ["初中古诗", 
            '古文观止', '古诗三百首', '古诗十九首','唐诗三百首', '宋词三百首', '宋词精选', '小学古诗', '诗经','辞赋精选', '高中古诗']
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