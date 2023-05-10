<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">抒情</van-tag>
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
            taglist: ["友情", 
            '壮志未酬', '怀才不遇', '悲愤','壮志难酬', '愤懑', '抒情', '相思', '爱情','言志']
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