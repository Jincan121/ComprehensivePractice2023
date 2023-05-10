<template>
   <div class="wp">


      <template>
         
         <van-row>
            <van-col span="20">
               <van-tabs v-model="activeName"  >

                  <van-tab title="推荐" name="b" to="/main/write/push"></van-tab>
                  <van-tab title="关注" name="c" to="/main/write/notice"></van-tab>

               </van-tabs>
            </van-col>
            <van-col span="4">
               <div id="p_button">
                  <van-icon name="plus" size="40px" @click="showPopup" />
               </div>


               <van-popup v-model="show" position="bottom" :style="{ height: '50%' }">
                  <van-cell-group>
                     <van-field v-model="text" label="标题" placeholder="标题" />
                     <van-field v-model="content" rows="10" autosize label="内容" type="textarea" maxlength="1023"
                        placeholder="内容" show-word-limit />
                  </van-cell-group>
                  <div style="margin: 16px;">
                     <van-button round block type="info" native-type="submit" @click="sbumitWrite">发布</van-button>
                  </div>

               </van-popup>

            </van-col>

         </van-row>

      </template>

      <router-view>

      </router-view>

   </div>
</template>
   
<script>



export default {
   data() {

      return {
         position: 'ju',
         activeName: 'a',
         show: false,
         text: '',
         content:'',
      }

   },
   methods:
   {
      showPopup() {
         this.show = true;
      },
      async sbumitWrite(){
         var UID = window.sessionStorage.getItem('UID');
         
         this.content=encodeURIComponent(this.content);
         console.log(this.content);
         const {data:res} = await this.$http.post("writes/write?" + "UID=" + UID + "&headline=" + this.text+"&content=" + this.content);
         
         if(res=='success')
         {
            
            this.$toast.success('发布成功');
            this.$router.go(0);
            this.show = false;
         }
      }
   }
}

</script>
   
<style>
.wp {
   background-color: #ffffff;
   height: 90vh;

}

.p_button {
   position: right;
}
</style>
   