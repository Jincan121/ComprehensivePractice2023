<template>
   <div class="p">
      <van-sticky :offset-top="46">
         <van-nav-bar>
            <template #left>
               <van-icon name="exchange" size="35" @click="changeModel()" color="#114514" />
            </template>
         </van-nav-bar>
      </van-sticky>
      <router-view>

      </router-view>

   </div>
</template>
  
<script>



export default {
   data() {

      return {
         position: 'ju',
      }

   },
   methods:
   {
      changeModel() {
         if (this.$route.path == '/main/push/ju') {
            
            this.$router.push({ path: "/main/push/shi" }).
            return;
         }
         else {
            this.position = 'ju';
            this.$router.push({ path: "/main/push/ju" }).catch();
            return;
         }
      }
   }
}

</script>
  
<style>
.p {
   background-color: #fff;

}
</style>
  