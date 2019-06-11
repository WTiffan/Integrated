<template>
  <div class="home">
    <div id="TITLE">
      <div id="title">
        <a href="http://localhost:8190/#/home">
          <h1>在线考试</h1>
          <span>TESTING</span>
        </a>
        <div id="operation">
          <router-link class="header_login" slot="right" :to="userInfo.sno ? '/profile/info' : '/login'">
            <span class="header_login_text" v-if="!userInfo.sno">
              <el-button type="primary" plain>登录</el-button>
            </span>
          </router-link>
        </div>
      </div>
    </div>
    
    <div id="move">
            <el-carousel height="460px" indicator-position="outside" :autoplay="true" >
                <el-carousel-item v-for="item in dataimg" v-bind:key="item.index">
                    <div id="playCard">
                        <img :src="item.src" />
                    </div>
                </el-carousel-item>
            </el-carousel>
        </div>
    
    <div id="introduce">
      <img src="../../assets/big.png" width="100%" >
    </div>

    <div id="bottom" style="text-align:center; color:#1ea0fa ">
      <p>版权所有 © 一体化在线考试系统 这个美丽又可爱的婷婷婷啊~</p>
    </div>
  </div>
</template>

<script>
  import {Toast} from 'mint-ui'
  import HeaderTop from '../../components/HeaderTop/HeaderTop.vue'
  import Swiper from '../../components/Swiper/Swiper.vue'
  import {mapState} from 'vuex'

  export default {
    name: "",
    created(){
      this.$store.dispatch('getRotationImages');
      this.$store.dispatch('getLanguagesInfo');
    },
    data() {
      return {
        currentDate:new Date(),
        curSelect:null,
        alreadyClock: false,
        dataimg :[
          {
            src: require('../../assets/1.png'),
          },
          {
            src: require('../../assets/2.png'),
          },
          {
            src: require('../../assets/3.png'),
          },
          {
            src: require('../../assets/4.png'),
          }
        ],
      }
    },
    computed:{
      //轮播图的数组
      ...mapState(['examCalendar','rotationImages','userInfo','languagesInfo'])
    },
    methods:{
    },
    components:{
      HeaderTop,
    } 
  }
</script>

<style lang="stylus" type="text/stylus" rel="stylesheet/stylus" scoped>
     #move {
       width 33%;
        // margin-top: 5%;
        margin-left 2%;
      }
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
      #operation {
        position: absolute;
        right: 3%;
        top: 3%;
      }
      #introduce {
        height 250px;
        width 60%;
        position absolute;
        top 30%;
        right 0;
      }
</style>

