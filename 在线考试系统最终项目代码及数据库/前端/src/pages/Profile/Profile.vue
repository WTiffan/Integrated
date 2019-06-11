<template>
  <div class="profile">
        <div id="head">
          <a href="javascript:void(0)" @click="personInfor=true">
            <el-col :span="7" id="userhead">
              <img src="../../common/imgs/nomessage.jpg" width="70px" height="70px" style="border-radius: 35px" />
            </el-col>
            <el-col :span="17" id="username">
              <h4>{{userInfor.username}}，欢迎你</h4>
            </el-col>
          </a>
        </div>

    <!-- 导航 -->
    <div id="navigation">
      <el-menu
      default-active="1"
      class="el-menu-demo"
      background-color="#f5f5f5"
      active-text-color="#1ea0fa"
      mode="horizontal">
        <el-menu-item index="1">
          <i class="el-icon-menu"></i>
          <span slot="title" @click="sureTest=true; myScore=false">我的考试</span>
        </el-menu-item>
        <el-menu-item index="2" @click="sureTest=false; myScore=true">
          <i class="el-icon-document"></i>
          <span slot="title">查看成绩</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-back"></i>
          <a href="http://localhost:8190/#/home" target="_blank">
            首页
          </a>
        </el-menu-item>
      </el-menu>
    </div>

    <!-- 考试 -->
    <!-- 试卷列表 -->
    <el-card v-show="sureTest" id="testYes">
      <el-table :data="tableData2.slice((currentPage2-1)*pagesize,currentPage2*pagesize)" style="width: 100%">
          <el-table-column align="center" prop="paperId" label="试卷编号"></el-table-column>
          <el-table-column align="center" prop="paperName" label="试卷名称"></el-table-column>
          <el-table-column align="center" prop="operation" label="操作">
            <template slot-scope="scope">
              <el-button type="primary" 
                icon="el-icon-edit" 
                title="开始考试" 
                circle 
                plain
                @click="beginTest(scope.$index, scope.row); start()"></el-button>
            </template>
          </el-table-column>
          <div class="pagination">
            <el-pagination background layout="prev, pager, next" :total="total2" @current-change="current_change2" class="paginate"></el-pagination>
          </div>
      </el-table>
    </el-card>

    <!-- 考试页面 -->
    <el-card id="answer" v-show="testing">
      <div slot="header" class="clearfix" style="text-align:center">
        <span>答题页面</span>
        <br><br>
        <p>时间：{{str}}</p>
        <el-button type="primary" 
                  icon="el-icon-check" 
                  style="float: right; padding: 3px 0" 
                  plain 
                  @click="submiteAnwser()">确认提交</el-button>
      </div>
      <div v-for="item in question" :key="item.id" class="questionArea">
        <p><span>{{item.exerciseId}}. </span><span>{{item.content}}</span></p>
        <el-radio-group 
            v-model="item.index"
            @change="handleRadioChange(item.index,item.exerciseId)"
            v-show="radioShow">
            <el-radio label="A">A.{{item.typeA}}</el-radio>
            <el-radio label="B">B.{{item.typeB}}</el-radio>
            <el-radio label="C">C.{{item.typeC}}</el-radio>
            <el-radio label="D">D.{{item.typeD}}</el-radio>
          </el-radio-group>
      </div>
    </el-card>
    
    <!-- 查看成绩 -->
    <el-card v-show="myScore" id="score">
      <el-table :data="tableData1.slice((currentPage1-1)*pagesize,currentPage1*pagesize)" style="width: 100%" id="peoTable">
          <el-table-column align="center" prop="paperId" label="试卷编号"></el-table-column>
          <el-table-column align="center" prop="paperName" label="试卷名称"></el-table-column>
          <el-table-column align="center" prop="mark" label="得分"></el-table-column>
          <div class="pagination">
            <el-pagination background layout="prev, pager, next" :total="total1" @current-change="current_change1" class="paginate"></el-pagination>
          </div>
      </el-table>
    </el-card>

    <el-dialog title="个人信息" v-model="userInfor" :visible.sync="personInfor" :close-on-click-modal="false">
      <img id="userHead" src="../../common/imgs/nomessage.jpg" width="100px" height="100px" style="border-radius: 50px" />
      <el-form  ref="userInfor" label-width="150px">
        <el-form-item label="用户ID：">
          <el-col :span="8">
             <span>{{userInfor.userId}}</span>
          </el-col>
        </el-form-item>
        <el-form-item label="用户名：">
          <el-col :span="8">
            <span>{{userInfor.username}}</span>
          </el-col>
        </el-form-item>
        <el-form-item label="性别：">
          <el-col :span="8">
            <span>{{userInfor.sex}}</span>
          </el-col>
        </el-form-item>
        <el-form-item label="生日：">
          <el-col :span="8">
            <span>{{userInfor.birthday}}</span>
          </el-col>
        </el-form-item>
        <el-form-item label="权限：">
          <el-col :span="8">
            <span>{{userInfor.power}}</span>
          </el-col>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import HeaderTop from '../../components/HeaderTop/HeaderTop.vue'
  import ProfileItem from '../../components/ProfileItem/ProfileItem.vue'
  import { mapState, mapGetters } from 'vuex'
  import { MessageBox, Toast } from 'mint-ui';
  import {reqUpdateFeedbackStatus, reqFeedbackInfo} from '../../api'
  export default {
    name: "",
    data() {
      return {
        sno:this.$store.state.userInfo.sno,
        isSelect:false,

        //在线考试
        //试卷id
        paperID: '',
        sureTest: true,
        tableData2: [],
        radioAnswer: [],
        question: [],
        currentPage2: 1,
        total2: 0,
        h: 0,
        m: 0,
        s: 0,
        time: 0,
        str: '00:00:00',
        radio: '',
        radioShow: true,
        checkShow: false,
        testing: false,
        //分页
        pagesize: 10,
        //查看成绩
        myScore: false,
        tableData1: [],
        currentPage1: 1,
        total1: 0,

        //personInfor
        personInfor: false,

        //用户信息
        userInfor: [],
      }
    },
    computed:{
      ...mapState(['userInfo']),
      ...mapGetters(['unreadMsgCount'])
    },
    created(){
      //请求用户信息
      this.$ajax({
          method: "post",
          url: "http://47.103.10.220:8022/user/listUserById",
          dataType: "json",
          crossDomain: true,
          cache: false,
      }).then(resolve => {
        console.log(resolve.data[0]);
        this.userInfor = resolve.data[0];
      }, reject => {
          console.log(reject);
      });
      //所有试卷加载
      this.$ajax({
          method: "post",
          url: "http://47.103.10.220:8022/paper/listAllPaper",
          dataType: "json",
          crossDomain: true,
          cache: false,
      }).then(resolve => {
          this.tableData2 = resolve.data;
          this.total2 = resolve.data.length;
          console.log(this.total2);
          console.log(resolve.data);
      }, reject => {
          console.log(reject);
      });

      //个人成绩
      this.$ajax({
          method: "post",
          url: "http://47.103.10.220:8022/score/queryScoreByUser",
          dataType: "json",
          crossDomain: true,
          cache: false,
      }).then(resolve => {
          this.tableData1 = resolve.data;
          this.total1 = resolve.data.length;
          console.log(resolve.data);
      }, reject => {
          console.log(reject);
      });

    },
    methods: {
      //开始考试
      beginTest(index, row) {
        this.testing = true;
        this. sureTest = false;
        this.paperID = row.paperId;
        console.log(row.paperId);
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8022/paperDetail/listPaperDetailByPaperId",
            data: {
              paperIdStr: row.paperId,
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
          console.log(resolve);
          this.question = resolve.data;
        }, reject => {
            console.log(reject);
        });
      },

      //查看成绩
      current_change1(currentPage) {
        this.currentPage1 = currentPage;
      },
      //考试
      current_change2(currentPage) {
        this.currentPage2 = currentPage;
      },
      //选择
      handleRadioChange(chose, id){
        this.radioAnswer[id] = {index:id, value:chose};
        console.log(this.radioAnswer);
      },
      //交卷
      submiteAnwser() {
        clearInterval(this.time);
        this.$alert('请自行查看成绩', '提交成功！', {
            confirmButtonText: '确定',
            callback: action => {
              this.testing = false;
              this.sureTest = true;
              this.$ajax({
                method: "post",
                url: "http://47.103.10.220:8022/score/queryScoreByUser",
                dataType: "json",
                crossDomain: true,
                cache: false,
            }).then(resolve => {
                this.tableData1 = resolve.data;
                this.total1 = resolve.data.length;
                console.log(resolve.data);
            }, reject => {
                console.log(reject);
            });
          }
        });
        //算分
        let right = 0;
        for(let p=0; p<this.question.length; p++){
          for(let q=0; q<this.radioAnswer.length; q++){
            if(this.radioAnswer[q]!=undefined){
              if(this.question[p].exerciseId == this.radioAnswer[q].index){
                if(this.question[p].answer == this.radioAnswer[q].value){
                  right += this.question[p].score;
                }
              }
            }
          }
        }
        console.log(right);
        this.testing = true;
        this. sureTest = false;
        this.$ajax({
            method: "post",
            url: "http://47.103.10.220:8022/score/addScore",
            data: {
              paperIdStr: this.paperID,
              markStr: right,
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
        }, reject => {
            console.log(reject);
        });
      },
      //倒计时
      timer(){
      //秒针走动
        this.s=this.s+1;
        //秒进位分，秒归零
        if(this.s>=60){
          this.m=this.m+1;
          this.s=0;
        }
        //分进位时，分归零
        if(this.m>=60){
          this.h=this.h+1;
          this.m=0;
        }
        this.str=this.addZero(this.h)+":"+this.addZero(this.m)+":"+this.addZero(this.s);
        if(this.str == "02:00:00"){
          this.$alert('请停止答题，前往“我的成绩”中查询你的成绩', '考试时间到！', {
            confirmButtonText: '确定',
            callback: action => {
              this.testing = false;
              this.myScore = true;
            }
          });
          clearInterval(this.time);
        }
      },
      //补零
      addZero(t){
        if(t<10){
          return ("0"+t);
        }
        else{
          return t;
        }
      },
      //开始计时
      start(){
        //1秒=1000毫秒
        this.time=setInterval(this.timer,1000);
      },
    },
    components:{
      HeaderTop,
      ProfileItem
    }
  }
</script>

<style lang="stylus" type="text/stylus" rel="stylesheet/stylus" scoped>
  @import "../../common/stylus/mixins.styl"
  .profile
    width 100%
    overflow hidden
    padding-bottom 56px
  #head{
    position: absolute;
    right: 1.5%;
    width: 16%; 
    color: black;
    text-align: center;
    z-index: 100;
  }
  #username {
    line-height 72px;
  }
  #navigation {
    margin-top 1%
    // width 13%
    background-color rgba(255,255,255,0)
  }

  //考试
  #testOrNot {
    width 50%;
    position absolute 
    top 150px
    left 27%
  }
  #testYes
    position absolute 
    width 93%
    top 112px
    left 4%
  #answer
    position absolute 
    width 93%
    top 112px
    left 4%
  // 查看成绩
  #score {
    position absolute 
    width 93%
    top 112px
    left 4%
  }
  #userHead {
    position absolute
    top 12%
    right 15%;
  }
  .questionArea {
    // border: 1px solid red;
    width: 60%;
    margin: 0 auto;
    margin-bottom: 2%;
  }
  .questionArea p {
    margin-bottom: 1%;
    font-size: 16px;
  }
</style>
