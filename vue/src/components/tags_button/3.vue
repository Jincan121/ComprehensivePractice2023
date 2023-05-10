<template>
    <div>
        <div class="tagname">
            <van-tag type="danger">词牌</van-tag>
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
            taglist: ["如梦令", 
            '醉花阴', '虞美人', '定风波','雨霖铃', '长相思', '念奴娇', '六州歌头', '忆江南','临江仙', '浣溪沙', '水调歌头', '菩萨蛮', '鹧鸪天'
            , '满江红',  '蝶恋花', '西江月', '沁园春', '贺新郎', '清平乐', '水龙吟' , '渔家傲', '卜算子',  '苏幕遮', '江城子'
            , '青玉案', '摸鱼儿', '一剪梅', '破阵子'] 
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