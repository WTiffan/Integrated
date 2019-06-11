<template>
  <section class="login-container">
    <div id="TITLE">
      <div id="title">
        <a href="http://localhost:8190/#/home">
          <h1>在线考试</h1>
          <span>TESTING</span>
        </a>
      </div>
    </div>

    <!--显示登录注册页面Vue标志图标-->
    <div class="login-logo">
      <viewer>
        <img src="../../assets/test.png" class="logo_img">
      </viewer>
    </div>

    <!--登录-->
    <div class="login-wrap" v-show="showLogin">
        <mt-field label="用户名" placeholder="请输入用户名" v-model="sno" :state="snoState" />
        <mt-field label="密码" placeholder="请输入密码" type="password" v-model="stuPsw" :state="pswState" @keyup.enter.native="checkLogin"/>
        <mt-button type="primary" size="large" @click.native="checkLogin">登录</mt-button>

        <div class="toggle-login">
          <span @click="toRegister">没有账号？马上注册</span>
          <span @click="toFindPsw">忘记密码？</span>
        </div>
      </div>
    <!--</transition>-->

    <!--注册-->
    <div class="register-wrap" v-show="showRegister">
      <mt-field label="学号" placeholder="请输入12位数字学号" v-model="newSno" :state="newSnoState"
                @blur.native.capture="checkNewSno"/>
      <mt-field label="密码" placeholder="请输入至少6位数字密码" type="password" v-model="newPsw" :state="newPswState"
                @blur.native.capture="checkNewPsw"/>
      <mt-field label="确认密码" placeholder="请再次输入密码" type="password" v-model="newPswConfirm"
                :state="newPswConfirmState" @blur.native.capture="checkNewPswConfirm"/>
      <mt-field label="姓名" placeholder="请输入姓名" v-model="newName" :state="newNameState"
                @blur.native.capture="checkNewName"/>

      <mt-field label="邮箱" placeholder="请输入邮箱" v-model="newEmail" :state="newEmailState"
                @blur.native.capture="checkNewEmail"/>
      <mt-button type="primary" size="large" @click.native="stuRegister">注册</mt-button>

      <div class="toggle-register">
        <span @click="toLogin">已有账号？马上登录</span>
        <span @click="toFindPsw">忘记密码？</span>
      </div>
    </div>

    <!--找回密码-->
    <div class="find-psw-wrap" v-show="showFindPsw">
      <mt-field label="学号" placeholder="请输入12位数字学号" v-model="findSno"
                :state="findSnoState" @blur.native.capture="checkfindSno"/>
      <mt-field label="新密码" placeholder="请输入新密码" type="password" v-model="findNewPsw"
                :state="findNewPswState" @blur.native.capture="checkfindNewPsw"/>
      <mt-field label="确认新密码" placeholder="请再次输入新密码" type="password" v-model="findNewPswConfirm"
                :state="findNewPswConfirmState" @blur.native.capture="checkfindNewPswConfirm"
                @keyup.enter.native="stuFindPsw"/>
      <mt-button type="primary" size="large" @click="stuFindPsw">确认修改</mt-button>

      <div class="toggle-find-psw">
        <span @click="toLogin">已有账号？马上登录</span>
        <span @click="toRegister">没有账号？马上注册</span>
      </div>
    </div>
  </section>
</template>

<script>
  import HeaderTop from '../../components/HeaderTop/HeaderTop.vue'
  import {reqLogin, reqRegister, reqFindPsw} from '../../api'
  import {Toast, MessageBox} from 'mint-ui'
  export default {
    name: "",
    data() {
      return {
        showLogin: true,
        showRegister: false,
        showFindPsw:false,
        sno: '',
        snoState:'',
        stuPsw: '',
        pswState:'',
        newSno: '',
        newSnoState:'',
        newPsw: '',
        newPswState:'',
        newPswConfirm:'',
        newPswConfirmState:'',
        newName:'',
        newNameState:'',
        newEmail:'',
        newEmailState:'',
        newPhone:'',
        newPhoneState:'',
        newSecurityCode:'',
        newSecurityCodeState:'',
        newSecurityCodeConfirm:'',
        newSecurityCodeConfirmState:'',
        findSno:'',
        findSnoState:'',
        findPhone:'',
        findPhoneState:'',
        findSecurityCode:'',
        findSecurityCodeState:'',
        findNewPsw:'',
        findNewPswState:'',
        findNewPswConfirm:'',
        findNewPswConfirmState:''
      }
    },
    methods: {
      // 异步学生登录
      async checkLogin(){
        // 去个人中心界面
        console.log(this.sno);
        console.log(this.stuPsw);
        if(this.sno == "admin"){
          this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8022/user/login",
            data: {
              username: this.sno,
              password: this.stuPsw,
            },
            dataType: "json",
            crossDomain: true,
            cache: false,
            transformRequest(obj){
                    var str = [];
                    for(var p in obj){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
          }).then(resolve => {
            console.log(resolve.data);
            this.question = resolve.data;
            this.$router.replace('/admin')
          }, reject => {
              console.log(reject);
          });
        }
        else {
          this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8022/user/login",
            data: {
              username: this.sno,
              password: this.stuPsw,
            },
            dataType: "json",
            crossDomain: true,
            cache: false,
            transformRequest(obj){
                    var str = [];
                    for(var p in obj){
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    }
                    return str.join("&");
                },
          }).then(resolve => {
            console.log(resolve.data);
            this.question = resolve.data;
            this.$router.replace('/Personal')
          }, reject => {
              console.log(reject);
          });
        }
      },
      //点击展示登录面板
      toLogin(){
        this.sno = '';
        this.snoState = '';
        this.stuPsw = '';
        this.pswState = '';
        this.showLogin = true;
        this.showRegister = false;
        this.showFindPsw = false;
      },
      //点击展示注册面板
      toRegister(){
        this.newSno = '';
        this.newSnoState = '';
        this.newPsw = '';
        this.newPswState = '';
        this.newPswConfirm = '';
        this.newPswConfirmState = '';
        this.newName = '';
        this.newNameState = '';
        this.newEmail = '';
        this.newEmailState = '';
        this.newPhone = '';
        this.newPhoneState = '';
        this.newSecurityCode = '';
        this.newSecurityCodeState = '';
        this.newSecurityCodeConfirm = '';
        this.newSecurityCodeConfirmState = '';
        this.showLogin = false;
        this.showRegister = true;
        this.showFindPsw = false;
      },
      //点击展示找回密码面板
      toFindPsw(){
        this.findSno = '';
        this.findSnoState = '';
        this.findPhone = '';
        this.findPhoneState = '';
        this.findSecurityCode = '';
        this.findSecurityCodeState = '';
        this.findNewPsw = '';
        this.findNewPswState = '';
        this.findNewPswConfirm = '';
        this.findNewPswConfirmState = '';
        this.showLogin = false;
        this.showRegister = false;
        this.showFindPsw = true;
      },
    },
    components:{
      HeaderTop
    }


  }
</script>

<style lang="stylus" type="text/stylus" rel="stylesheet/stylus" scoped>
  #TITLE {
        width 100%
        padding 1.5% 1% 1% 3%
      }
      #title{
    width: 10%;
    line-height: 150%;
    color: black;
    text-align: center;
  }
  #title a {
    color: #1ea0fa;
    text-decoration: none;
  }
  #title h1 {
    font-size 20px
  }
  .login-container
    background-color #f5f5f5
    >h3
      padding 20px
    .login-logo
      width 90%
      margin 20px auto
      text-align center
      margin-bottom 20px
      background-image url("../../common/imgs/java.png"), url("../../common/imgs/cplus.png"), url("../../common/imgs/php.png"), url("../../common/imgs/android.png"), url("../../common/imgs/h5.png"), url("../../common/imgs/ios.png"), url("../../common/imgs/js.png"), url("../../common/imgs/python.png")
      background-size 50px 50px, 50px 50px, 50px 50px, 50px 50px, 44px 44px, 32px 32px, 28px 28px, 32px 32px
      background-repeat no-repeat, no-repeat, no-repeat, no-repeat, no-repeat, no-repeat, no-repeat, no-repeat
      background-position 2% 5%, 95% 5%, 90% 40%, 12% 42%, 95% 80%, 5% 78%, 80% 100%, 18% 100%
      .logo_img
        width 160px
        height 160px
        border-radius 80px
    .login-wrap
      width 30%
      margin 0 auto
      .mint-button
        width 50%
        margin 0 auto
        background-color #1ea0fa
        margin-top 15px
        margin-bottom 15px
      .toggle-login
        display flex
        justify-content space-between
        color #1ea0fa
    .register-wrap
      width 35%
      margin 0 auto
      padding-bottom 80px
      .mint-button
        width 50%
        margin 0 auto
        background-color #1ea0fa
        margin-top 15px
        margin-bottom 15px
      .toggle-register
        display flex
        justify-content space-between
        color #1ea0fa
    .find-psw-wrap
      width 35%
      margin 0 auto
      padding-bottom 80px
      .get-captcha
        height 30px
        background-color #1ea0fa
        color #fff
        border-radius 2px
        border 0
      .mint-button
        width 50%
        margin 0 auto
        background-color #1ea0fa
        margin-top 15px
        margin-bottom 15px
      .toggle-find-psw
        display flex
        justify-content space-between
        color #1ea0fa
      
</style>
