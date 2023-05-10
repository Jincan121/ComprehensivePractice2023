<template>
    <div class="pe">
 
        <van-sticky :offset-top="46">
       <template>
          <van-row>
             <van-col span="20">
                <van-tabs v-model="activeName">
 
                   <van-tab title="分类" name="b" to="/main/search/tag/1"></van-tab>
                   <van-tab title="作者" name="c" to="/main/search/poet"></van-tab>
 
                </van-tabs>
             </van-col>
             <van-col span="4">
                <div class="p_button">
                   <van-icon name="search" size="40px" @click="toSearch"/>
                </div>
             </van-col>
 
          </van-row>
 
 
       </template>
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
          activeName: 'a',
       }
 
    },
    methods:
    {
      toSearch()
      {
         
         this.$router.push({path:"/searchPage"})
      }
    }
 }
 
 </script>
    
 <style>
 .pe {
    background-color: #ffffff;
   
    
 }
 .p_button
 {
   background-color: #ffffff;

 }
 
 </style>
    