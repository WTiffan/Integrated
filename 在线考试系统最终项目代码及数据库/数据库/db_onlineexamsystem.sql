/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost:3306
 Source Schema         : db_onlineexamsystem

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : 65001

 Date: 10/06/2019 23:54:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer`  (
  `answerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '答题情况Id（唯一）',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号',
  `exerciseId` int(11) DEFAULT NULL COMMENT '试卷题目编号',
  `score` int(255) DEFAULT NULL COMMENT '分值',
  `checked` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所选答案',
  PRIMARY KEY (`answerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_answer
-- ----------------------------
INSERT INTO `t_answer` VALUES (1, 1, 1, 1, '1');
INSERT INTO `t_answer` VALUES (2, 2, 2, 6, '0');
INSERT INTO `t_answer` VALUES (4, 2, 2, 6, '0');
INSERT INTO `t_answer` VALUES (5, 2, 2, 6, '0');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告Id（唯一）',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`noticeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, 2, 'test标题', 'testtest', 'Mon Jun 03 01:16:08 CST 2019');
INSERT INTO `t_notice` VALUES (3, 3, '测试增加通告标题', '测试增加通告内容', 'Sun Jun 02 23:50:49 CST 2019');
INSERT INTO `t_notice` VALUES (6, 2, '测试增加通告标题', '测试增加通告内容', 'Mon Jun 03 01:15:18 CST 2019');
INSERT INTO `t_notice` VALUES (7, 2, '测试增加通告标题', '测试增加通告内容', 'Mon Jun 03 01:16:08 CST 2019');
INSERT INTO `t_notice` VALUES (9, 1, 'undefined', 'undefined', 'Mon Jun 03 14:54:00 CST 2019');
INSERT INTO `t_notice` VALUES (10, 1, '嘿嘿嘿', '改改改改', 'Mon Jun 03 14:56:59 CST 2019');
INSERT INTO `t_notice` VALUES (11, 1, '软导期末考试通知', '测试', 'Mon Jun 03 15:26:15 CST 2019');

-- ----------------------------
-- Table structure for t_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper`  (
  `paperId` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷编号Id（唯一）',
  `paperName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试卷名称',
  PRIMARY KEY (`paperId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_paper
-- ----------------------------
INSERT INTO `t_paper` VALUES (1, '啊啊啊');
INSERT INTO `t_paper` VALUES (2, '2019年数据结构期末考试题');
INSERT INTO `t_paper` VALUES (3, '2015高等数学上试卷（A1）带答案');
INSERT INTO `t_paper` VALUES (4, '2017英语考研真题');
INSERT INTO `t_paper` VALUES (5, '2015英语考研模拟题');

-- ----------------------------
-- Table structure for t_paperdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_paperdetail`;
CREATE TABLE `t_paperdetail`  (
  `paperDetailId` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷详细表Id（唯一）',
  `paperId` int(255) DEFAULT NULL COMMENT '试卷编号Id',
  `exerciseId` int(11) DEFAULT NULL COMMENT '题目编号',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题目内容',
  `typeA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项A',
  `typeB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项B',
  `typeC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项C',
  `typeD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项D',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '正确答案',
  `exerciseType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题目类型',
  `score` int(255) DEFAULT NULL COMMENT '分值',
  PRIMARY KEY (`paperDetailId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_paperdetail
-- ----------------------------
INSERT INTO `t_paperdetail` VALUES (2, 2, 1, '长度为n的线性表采用顺序存储结构，在其第i个位置插入一个新元素的算法时间复杂度为？', 'O(0)', 'O(1)', 'O(n)', 'O(n2)', 'B', '单选题', 10);
INSERT INTO `t_paperdetail` VALUES (3, 2, 2, '将{5, 2, 7, 3, 4, 1, 6}依次插入初始为空的二叉搜索树。则该树的后序遍历结果是？', '1, 4, 3, 2, 6, 7, 5', '1, 2, 3, 4, 6, 7, 5', '1, 4, 2, 6, 3, 7, 5', '5, 4, 3, 7, 6, 2, 1', 'C', '单选题', 10);
INSERT INTO `t_paperdetail` VALUES (4, 2, 3, '设一段文本中包含字符{a, b, c, d, e}，其出现频率相应为{3, 2, 5, 1, 1}。则经过哈夫曼编码后，文本所占字节数为？', '40', '36', '25', '12', 'A', '单选题', 10);
INSERT INTO `t_paperdetail` VALUES (5, 2, 4, '在一个不带头结点的非空链式队列中,假设f和r分别为队头和队尾指针,则插入s所指的结点运算是( )？', 'f->next=s; f=s', 'r->next=s; r=s', 's->next=s; r=s', 's->next=f; f=s', 'D', '单选题', 10);
INSERT INTO `t_paperdetail` VALUES (6, 2, 5, '在单链表中，若p所指的结点不是最后结点，在p之后插入s所指结点，则执行？', 's->next=p->next; p->next=s', 's->next=p; p->next=s', 's->next=p->next; p=s', 'p->next=s; s->next=p', 'B', '单选题', 10);
INSERT INTO `t_paperdetail` VALUES (7, 2, 6, '对最小堆（小顶堆）{1,3,2,12,6,4,8,15,14,9,7,5,11,13,10} 进行三次删除最小元的操作后，结果序列为', '4,6,5,12,7,10,8,15,14,9,13,11', '4,5,6,12,7,10,8,15,14,13,9,11', '4,5,6,7,8,9,10,11,12,13,14,15', '4,6,5,13,7,10,8,15,14,12,9,11', 'A', '单选题', 10);
INSERT INTO `t_paperdetail` VALUES (8, 2, 7, '编译好的Servlet应该与JSP文件放在同一个文件夹下？', '对', '错', NULL, NULL, 'B', '判断题', 2);
INSERT INTO `t_paperdetail` VALUES (9, 2, 8, '使用response的sendRedirect()方法页面跳转会导致地址栏改变？', '对', '错', NULL, NULL, 'A', '判断题', 2);
INSERT INTO `t_paperdetail` VALUES (10, 1, 2, '模块的内聚性最高的是？', '逻辑内聚', '时间内聚', '偶然内聚', '功能内聚', 'D', '单选题', 4);
INSERT INTO `t_paperdetail` VALUES (11, 1, 3, '结构化程序设计的一种基本方法是？', '筛选法', '迭代法', '逐步求精法', '递归法', 'C', '单选题', 4);
INSERT INTO `t_paperdetail` VALUES (13, 1, 4, '下列属于度量效益方法的是？', '货币的时间价值 ', '投资回收期', '收入', '投资回报率', 'ABC', '多选题', 6);
INSERT INTO `t_paperdetail` VALUES (14, 1, 5, '下面哪些测试属于白盒测试？', '基本路径测试', '等价类划分', '逻辑覆盖测试', '边界值分析', 'AC', '多选题', 6);
INSERT INTO `t_paperdetail` VALUES (33, 11111, 111111, '11111111111', '11111', '1111', '111111', '1111111111', 'A', '多选题', 10);

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩Id（唯一）',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号',
  `paperId` int(11) DEFAULT NULL COMMENT '试卷编号',
  `mark` int(255) DEFAULT NULL COMMENT '成绩',
  `paperName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试卷名称',
  PRIMARY KEY (`scoreId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES (1, 1, 2, 15, '考研线性代数试题');
INSERT INTO `t_score` VALUES (25, 3, 2, 12, '2015英语考研模拟题');
INSERT INTO `t_score` VALUES (26, 2, 1, 0, '考研线性代数试题');
INSERT INTO `t_score` VALUES (27, 2, 2, 14, '2019年数据结构期末考试题');
INSERT INTO `t_score` VALUES (28, 2, 3, 0, '2015高等数学上试卷（A1）带答案');
INSERT INTO `t_score` VALUES (29, 2, 2, 0, '2019年数据结构期末考试题');
INSERT INTO `t_score` VALUES (30, 2, 1, 0, '考研线性代数试题');
INSERT INTO `t_score` VALUES (31, 2, 2, 24, '2019年数据结构期末考试题');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id（唯一）',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名不允许重复',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `power` int(255) DEFAULT NULL COMMENT '权限（0为用户，1为管理员）',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123', '19990316', '女', 1, 'aaaaaaa');
INSERT INTO `t_user` VALUES (2, 'student', '123', '19990316', '女', 0, 'aaaaaaa');
INSERT INTO `t_user` VALUES (3, 'ahaha', '123', '19800316', '男', 0, 'aaaaaaa');
INSERT INTO `t_user` VALUES (16, 'test', '123', NULL, NULL, 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
