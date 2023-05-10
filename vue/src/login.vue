<template>
  
  
  <div class="login">
    <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>
    <van-nav-bar title="登录"  right-text="注册"  @click-left="onClickLeft"
      @click-right="onClickRight"  />
<div  style="text-align: center;">
  <van-image  round width="100px" height="100px" :src="require('@/assets/pic/1.png')">
</van-image>
</div>
      
      
    <van-form @submit="onSubmit" >
      <van-field v-model=loginForm.UID name="用户名" label="用户名" placeholder="用户名" :rules="[{ required: true }]" />
      <van-field v-model=loginForm.password type="password" name="密码" label="密码" placeholder="密码"
        :rules="[{ required: true }]" />
      <div style="margin: 16px;">
        
        <van-button  block type="info" native-type="submit" color="#ff4e20" plain>登录</van-button>
      </div>
    </van-form>
  
  </div>
</template>
<script>

import { Toast } from 'vant';
export default {
    data() {
        return {
            loginForm: {
                UID: "",
                password: "",
            }
        };
    },
    methods: {
        async onSubmit() {
            console.log("login");
            console.log(this.loginForm);
            const { data: res } = await this.$http.post("user/login?" + "UID=" + this.loginForm.UID + "&password=" + this.loginForm.password);
            console.log(res);
            this.result = res;
            if(this.result== 'success')
            {
              this.$router.push({path:"/main/push/ju"}).catch();
              window.sessionStorage.setItem('isLogin','true');
              window.sessionStorage.setItem('UID',this.loginForm.UID);
              this.$store.dispatch('asyncUpdateUser',this.loginForm);
              console.log(this.$store.getters.getUser);
            }
            if(res=='not found')
            {
              Toast.fail("用户不存在");
            }
            if(res=='error')
            {
              Toast.fail("密码错误")
            }

        },
        onClickLeft() {
            console.log("返回");
        },
        onClickRight() {
            console.log("注册");
            this.$router.push({path:"/sign"}).catch();
        },
    },
   
};


</script>

<style>

</style>


