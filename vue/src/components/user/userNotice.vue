<template>
  <div>
    <van-sticky>
      <van-nav-bar title="楚辞·诗源">
      </van-nav-bar>
    </van-sticky>



    <van-sticky :offset-top="45">
      <div class="topBar">
        <van-nav-bar left-text="返回" left-arrow @click-left="onClickLeft" title="关注列表">

        </van-nav-bar>
      </div>
    </van-sticky>
    <div class="writeList">



      <van-list v-model="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
        <van-cell v-for="item in list">
          <div class="writeListItem">

            <div class="info">
              <van-image v-if="item.image == 1" round :src="require('@/assets/pic/logo/1.png')" />
              <van-image v-if="item.image==2" round :src="require('@/assets/pic/logo/2.jpg')"/>
              <span style="margin-top: 15px;margin-left: 15px;font-size: 15px;">
                {{ item.followedname }}
              </span>

              <van-button v-if="follewList.findIndex((n) => n == item.followed) == -1" plain hairline icon="friends-o"
                type="info" color="brown" size="small" @click="noticeUser(item)">
                关注
              </van-button>

              <van-button v-if="follewList.findIndex((n) => n == item.followed) != -1" type="info" color="brown"
                size="small" @click="CancelNoticeUser(item)">
                已关注
              </van-button>
            </div>
          </div>
        </van-cell>
      </van-list>
    </div>
  </div>
</template>
     
<script>



export default {
  data() {
    return {
      list: [],
      follewList: [],
      writeItemTest: {
        username: 'username',
        content: 'content',
        title: 'title',
        time: 'time',
      },
      loading: false,
      finished: false,
    }
  },
  async created() {
    var UID = window.sessionStorage.getItem('UID');
    const { data: res } = await this.$http.post("user/searchFollowByUID?" + 'UID=' + UID);
    console.log(res);
    if (res == 'empty') {
      return;
    }
    for (let i = 0; i < res.length; i++) {
      this.follewList.push(res[i].followed);
    }
    //console.log(this.follewList);
    console.log(this.follewList.findIndex((n) => n > 0));
  },

  methods: {
    async onLoad() {
      var UID = window.sessionStorage.getItem('UID');
      const { data: res } = await this.$http.post("user/searchFollowByUID?UID=" + UID);
      console.log(res);
      var listSize = 100;
      if (res.length > 0 && res.length < 100) {
        listSize = res.length;
      }
      setTimeout(async () => {
        for (let i = 0; i < listSize; i++) {

          this.list.push(res[i]);
          var uid = res[i].followed;
          const { data: res1 } = await this.$http.post("/user/findImageByUID?UID=" + uid);

          //this.logoList.push(res.image);
          this.list[i].image = res1.image;
        }
        //console.log(this.list);
        // 加载状态结束
        this.loading = false;
        // 数据全部加载完成   
        this.finished = true;

      }, 1);

    },
    onClickLeft() {
      this.$router.back();

    },
    toFlower() {
      this.$router.push({ path: "/flower" });
    },
    async noticeUser(item) {
      console.log(item);
      var UID = window.sessionStorage.getItem('UID');
      const { data: res } = await this.$http.post("user/follow?" + "following=" + UID + "&followed=" + item.followed);
      console.log(res);
      if (res == 'success') {
        this.$toast.success('关注')
        this.follewList.push(item.followed);
      }
    },
    async CancelNoticeUser(item) {
      console.log(item);
      var UID = window.sessionStorage.getItem('UID');
      const { data: res } = await this.$http.post("user/cancelFollow?" + "following=" + UID + "&followed=" + item.followed);
      console.log(res);
      if (res == 'success') {
        this.$toast.success('取消关注');
        var index = this.follewList.findIndex((n) => n == item.followed);
        this.follewList.splice(index, 1);
      }

    }

  }

}

</script>
     
<style lang="less" scoped>
.writeList {
  .writeListItem {
    margin-top: 10px;

    border-top: 1px solid #ebebeb;

    .info {
      margin-top: 5px;
      position: relative;

      display: flex;
    }

    .van-image {
      margin-top: 5px;
      margin-left: 5px;
      width: 50px;
      height: 50px;
    }

    .van-button {
      position: absolute;
      margin-left: 80%;
      margin-top: 10px;
    }

    .writeItem {
      margin-top: 10px;

      .title {
        font-size: larger;
        font-weight: bold;
      }

      .writeContent {
        white-space: pre-wrap;
      }
    }

  }

}
</style>
     