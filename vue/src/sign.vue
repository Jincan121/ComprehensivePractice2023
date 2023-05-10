<template>
    <div>
        <van-sticky>
            <van-nav-bar title="楚辞·诗源">
            </van-nav-bar>
        </van-sticky>
        <van-nav-bar title="注册" right-text="登录" @click-left="onClickLeft" @click-right="onClickRight" />
        <div style="text-align: center;">
            <van-image round width="100px" height="100px" :src="require('@/assets/pic/1.png')">
            </van-image>
        </div>
        <van-form @submit="onSubmit">
            <van-field v-model=signForm.UID name="UID" label="UID" placeholder="UID" :rules="[{ required: true }]" />
            <van-field v-model=signForm.username name="用户名" label="用户名" placeholder="用户名" :rules="[{ required: true }]" />
            <van-field v-model=signForm.password type="password" name="密码" label="密码" placeholder="密码"
                :rules="[{ required: true }]" />
            <van-field v-model=ConfirmPassword type="password" name="confirmpas" label="确认密码" placeholder="确认密码"
                :rules="[{ validator, message: '输入不一致' }]" />
            <van-field v-model=signForm.email name="邮箱" label="邮箱" placeholder="邮箱" :rules="[{ required: true }]" />
            <div style="margin: 16px;">

                <van-button  block type="info" native-type="submit" color="#ff4e20" plain>注册</van-button>
            </div>
        </van-form>

    </div>
</template>
<script>
export default {
    data() {
        return {
            signForm: {
                UID: '',
                username: '',
                password: '',
                email: '',
            },
            ConfirmPassword: '',
            result: '',
        };
    },
    methods: {
        async onSubmit() {
            console.log('sign');
            console.log(this.signForm);

            const { data: res } = await this.$http.post('user/register?' +
                "UID=" + this.signForm.UID +
                "&password=" + this.signForm.password +
                "&username=" + this.signForm.username +
                "&email=" + this.signForm.email);
            this.result = res;
            console.log(this.result);
            if(res=='success')
            {
                this.$toast.success('注册成功')
                this.$router.push({path:'/login'})
            }else{
                this.$toast.fail('UID或邮箱已注册')
            }

        },
        validator() {
            return this.signForm.password == this.ConfirmPassword;
        },
        onClickLeft() {
            console.log('返回');
        },
        onClickRight() {
            console.log('登录');
            this.$router.push({ path: "/login" }).catch();
        },
    },
};


</script>
  
<style></style>
  
  
  