# CREATE USER 'workStudy'@'localhost' IDENTIFIED BY '123456';
# GRANT ALL ON db_workstudy.* TO 'workStudy'@'localhost';

INSERT INTO db_workstudy.t_todo(id,content, isfinish) VALUES
  ('1', 'aaaaaaa', FALSE),
  ('2', 'bbbbbbb', FALSE),
  ('3', 'ccccccc', FALSE);

INSERT INTO db_workstudy.class(academy, major, class, teacherId) VALUES
  ('杭州国际服务工程学院', '软件工程', 151, '2345'),
  ('杭州国际服务工程学院', '软件工程', 152, '2345'),
  ('杭州国际服务工程学院', '软件工程', 141, '2345'),
  ('杭州国际服务工程学院', '软件工程', 142, '2345'),
  ('杭州国际服务工程学院', '软件工程', 161, '2345'),
  ('杭州国际服务工程学院', '软件工程', 162, '2345'),
  ('杭州国际服务工程学院', '计算机科学与技术', 151, '2345'),
  ('杭州国际服务工程学院', '计算机科学与技术', 152, '2345'),
  ('杭州国际服务工程学院', '计算机科学与技术', 141, '2345'),
  ('杭州国际服务工程学院', '计算机科学与技术', 142, '2345'),
  ('杭州国际服务工程学院', '计算机科学与技术', 161, '2345'),
  ('杭州国际服务工程学院', '计算机科学与技术', 162, '2345');

INSERT INTO db_workstudy.user (userId, name, password, email, phone, academy, major, className, type) VALUES
  ('1234', '1234', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234', '1234', '杭州国际服务工程学院', '软件工程', '152', 0),
  ('2345', '2345', '9a938f51c7298d328a2801b01b21ed9e9840a0a1c43da289504cb23beeedf65a31a255653b8fc44e20eacefcb316e13fb4b5a2ef55ce312f629fd07c373c79f3', '2345', '2345', '杭州国际服务工程学院', '软件工程', '152', 1),
  ('3456', '3456', '99c552a2f9d880b40e3ec981c995f1a679b3b734827003363643ad025f4c8ed395227d0d361e798a6c558711ec1533f3f9bb87594efe6453b23c35b801014f91', '3456', '3456', '杭州国际服务工程学院', '软件工程', '152', 2);

INSERT INTO db_workstudy.user (userId, name, password, email, phone, academy, major, className, type) VALUES
  ('2015210405001', 'aaa1', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '151', 0),
  ('2015210405002', 'aaa2', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '151', 0),
  ('2015210405003', 'aaa3', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '151', 0),
  ('2015210405004', 'aaa4', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '151', 0),
  ('2015210405005', 'aaa5', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '151', 0),
  ('2015210405006', 'aaa6', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '152', 0),
  ('2015210405007', 'aaa7', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '152', 0),
  ('2015210405008', 'aaa8', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '152', 0),
  ('2015210405009', 'aaa9', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '152', 0),
  ('2015210405010', 'aaa10', 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', '1234@1234.com', '18012345678', '杭州国际服务工程学院', '软件工程', '152', 0);

INSERT INTO db_workstudy.admitapply(studentId, tableYear, sex, birthYear, birthMonth, nation, politicalStatus, birthPlace, phone, isContinue, isRender, workAndStudy, socialActivity, finance, otherFinance, financeNumber, reason,teacherResult,adminResult) VALUES
  ('1234', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2016-2017', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2015-2016', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2014-2015', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2013-2014', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2012-2013', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2011-2012', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2010-2011', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2009-2010', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2008-2009', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('1234', '2007-2008', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405001', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405002', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405003', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405004', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405005', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405006', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405007', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405008', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405009', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1),
  ('2015210405010', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '浙江省温州市', '13588737694', 0, 0, '勤工助学活动情况', '公益活动情况', '0000001', '其他说明', 1000, '申请理由', -1, -1);


INSERT INTO db_workstudy.award(studentId, awardName, awardNumber) VALUES
  ('1234', 'XXX奖', '1000'),
  ('1234', 'XXX奖', '2000'),
  ('1234', 'XXX奖', '3000'),
  ('1234', 'XXX奖', '4000'),
  ('1234', 'XXX奖', '5000'),
  ('2015210405001', 'XXX奖', '1000'),
  ('2015210405001', 'XXX奖', '2000'),
  ('2015210405001', 'XXX奖', '3000'),
  ('2015210405001', 'XXX奖', '4000'),
  ('2015210405001', 'XXX奖', '5000'),
  ('2015210405002', 'XXX奖', '1000'),
  ('2015210405002', 'XXX奖', '2000'),
  ('2015210405002', 'XXX奖', '3000'),
  ('2015210405002', 'XXX奖', '4000'),
  ('2015210405002', 'XXX奖', '5000'),
  ('2015210405003', 'XXX奖', '1000'),
  ('2015210405003', 'XXX奖', '2000'),
  ('2015210405003', 'XXX奖', '3000'),
  ('2015210405003', 'XXX奖', '4000'),
  ('2015210405003', 'XXX奖', '5000'),
  ('2015210405004', 'XXX奖', '1000'),
  ('2015210405004', 'XXX奖', '2000'),
  ('2015210405004', 'XXX奖', '3000'),
  ('2015210405004', 'XXX奖', '4000'),
  ('2015210405004', 'XXX奖', '5000'),
  ('2015210405005', 'XXX奖', '1000'),
  ('2015210405005', 'XXX奖', '2000'),
  ('2015210405005', 'XXX奖', '3000'),
  ('2015210405005', 'XXX奖', '4000'),
  ('2015210405005', 'XXX奖', '5000'),
  ('2015210405006', 'XXX奖', '1000'),
  ('2015210405006', 'XXX奖', '2000'),
  ('2015210405006', 'XXX奖', '3000'),
  ('2015210405006', 'XXX奖', '4000'),
  ('2015210405006', 'XXX奖', '5000'),
  ('2015210405007', 'XXX奖', '1000'),
  ('2015210405007', 'XXX奖', '2000'),
  ('2015210405007', 'XXX奖', '3000'),
  ('2015210405007', 'XXX奖', '4000'),
  ('2015210405007', 'XXX奖', '5000'),
  ('2015210405008', 'XXX奖', '1000'),
  ('2015210405008', 'XXX奖', '2000'),
  ('2015210405008', 'XXX奖', '3000'),
  ('2015210405008', 'XXX奖', '4000'),
  ('2015210405008', 'XXX奖', '5000'),
  ('2015210405009', 'XXX奖', '1000'),
  ('2015210405009', 'XXX奖', '2000'),
  ('2015210405009', 'XXX奖', '3000'),
  ('2015210405009', 'XXX奖', '4000'),
  ('2015210405009', 'XXX奖', '5000'),
  ('2015210405010', 'XXX奖', '1000'),
  ('2015210405010', 'XXX奖', '2000'),
  ('2015210405010', 'XXX奖', '3000'),
  ('2015210405010', 'XXX奖', '4000'),
  ('2015210405010', 'XXX奖', '5000');

INSERT INTO db_workstudy.discountfee (studentId, tableYear, sex, birthYear, birthMonth, nation, politicalStatus, phone, residence, incomeSource, incomePerMonth, peopleNumber, isLoan, reason, teacherResult, adminResult)VALUES
  ('1234', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2016-2017', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2015-2016', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2014-2015', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2013-2014', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2012-2013', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2011-2012', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2010-2011', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2009-2010', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2008-2009', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('1234', '2007-2008', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405001', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405002', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405003', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405004', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405005', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405006', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405007', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405008', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405009', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1),
  ('2015210405010', '2017-2018', '男', '1997', '11', '汉族', '共青团员', '13588737694', 0, '收入来源', '1234', '3', '1', '申请理由', -1, -1);


INSERT INTO db_workstudy.encouragement(studentId, tableYear, sex, birthYear, birthMonth, nation, startYear, startMonth, politicalStatus, phone, identityCardId, grade, courseNum, passNum, rank, residence, incomeSource, incomePerMonth, peopleNumber, address, postcode, reason) VALUES
  ('1234','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2016-2017',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2015-2016',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2014-2015',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2013-2014',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2012-2013',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2011-2012',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2010-2011',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2009-2010',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2008-2009',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('1234','2007-2008',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405001','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405002','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405003','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405004','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405005','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405006','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405007','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405008','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405009','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉'),
  ('2015210405010','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '18005801234', '330902123456780000', '12/40', '12','12',1,1,'收入来源',1234,3,'家庭地址',123456,'申请原因巴拉巴拉');


INSERT INTO db_workstudy.family_member (studentId, name, age, appellation, workCeremony, health, study) VALUES
  ('1234', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('1234', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('1234', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('1234', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405001', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405001', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405001', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405001', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405002', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405002', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405002', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405002', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405003', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405003', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405003', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405003', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405004', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405004', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405004', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405004', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405005', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405005', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405005', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405005', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405006', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405006', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405006', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405006', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405007', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405007', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405007', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405007', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405008', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405008', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405008', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405008', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405009', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405009', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405009', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405009', 'DDD', 70, '奶奶', '单位', 2, 2),
  ('2015210405010', 'AAA', 40, '爸爸', '单位', 2, 2),
  ('2015210405010', 'BBB', 40, '妈妈', '单位', 2, 2),
  ('2015210405010', 'CCC', 70, '爷爷', '单位', 2, 2),
  ('2015210405010', 'DDD', 70, '奶奶', '单位', 2, 2);


INSERT INTO db_workstudy.help(studentId, helpName, helpNumber) VALUES
  ('1234','XXX帮助',100),
  ('1234','XXX帮助',200),
  ('1234','XXX帮助',300),
  ('1234','XXX帮助',400),
  ('2015210405001','XXX帮助',100),
  ('2015210405001','XXX帮助',200),
  ('2015210405001','XXX帮助',300),
  ('2015210405001','XXX帮助',400),
  ('2015210405002','XXX帮助',100),
  ('2015210405002','XXX帮助',200),
  ('2015210405002','XXX帮助',300),
  ('2015210405002','XXX帮助',400),
  ('2015210405003','XXX帮助',100),
  ('2015210405003','XXX帮助',200),
  ('2015210405003','XXX帮助',300),
  ('2015210405003','XXX帮助',400),
  ('2015210405004','XXX帮助',100),
  ('2015210405004','XXX帮助',200),
  ('2015210405004','XXX帮助',300),
  ('2015210405004','XXX帮助',400),
  ('2015210405005','XXX帮助',100),
  ('2015210405005','XXX帮助',200),
  ('2015210405005','XXX帮助',300),
  ('2015210405005','XXX帮助',400),
  ('2015210405006','XXX帮助',100),
  ('2015210405006','XXX帮助',200),
  ('2015210405006','XXX帮助',300),
  ('2015210405006','XXX帮助',400),
  ('2015210405007','XXX帮助',100),
  ('2015210405007','XXX帮助',200),
  ('2015210405007','XXX帮助',300),
  ('2015210405007','XXX帮助',400),
  ('2015210405008','XXX帮助',100),
  ('2015210405008','XXX帮助',200),
  ('2015210405008','XXX帮助',300),
  ('2015210405008','XXX帮助',400),
  ('2015210405009','XXX帮助',100),
  ('2015210405009','XXX帮助',200),
  ('2015210405009','XXX帮助',300),
  ('2015210405009','XXX帮助',400),
  ('2015210405010','XXX帮助',100),
  ('2015210405010','XXX帮助',200),
  ('2015210405010','XXX帮助',300),
  ('2015210405010','XXX帮助',400);

INSERT INTO db_workstudy.prize(studentId, date, priceName, awardCeremony) VALUES
  ('1234','2015年9月','AAA奖','XXX比赛XX单位'),
  ('1234','2016年9月','VVV奖','XXX比赛XX单位'),
  ('1234','2017年1月','SSS奖','XXX比赛XX单位'),
  ('1234','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405001','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405001','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405001','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405001','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405002','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405002','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405002','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405002','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405003','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405003','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405003','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405003','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405004','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405004','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405004','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405004','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405005','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405005','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405005','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405005','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405006','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405006','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405006','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405006','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405007','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405007','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405007','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405007','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405008','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405008','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405008','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405008','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405009','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405009','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405009','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405009','2017年2月','XXX奖','XXX比赛XX单位'),
  ('2015210405010','2015年9月','AAA奖','XXX比赛XX单位'),
  ('2015210405010','2016年9月','VVV奖','XXX比赛XX单位'),
  ('2015210405010','2017年1月','SSS奖','XXX比赛XX单位'),
  ('2015210405010','2017年2月','XXX奖','XXX比赛XX单位');

INSERT INTO db_workstudy.questionary(studentId, tableYear, sex, birthYear, birthMonth, nation, residence, isOrphan, isDeformity, isSingleFamily, isMartyr, isDiffFamily, phone, identityCardId, address, salaryPerYear, indiOperPerYear, assetsIncome, agricultureIncome, sidelineIncome, otherIncome, peopleNumber, totalIncomePerYear, yearIncomePerPerson, workPeople, illnessFee, tuition, accommodation, naturalLoss, other) VALUES
  ('1234','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2016-2017',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2015-2016',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2014-2015',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2013-2014',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2012-2013',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2011-2012',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2010-2011',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2009-2010',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2008-2009',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('1234','2007-2008',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405001','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405002','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405003','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405004','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405005','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405006','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405007','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405008','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405009','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321),
  ('2015210405010','2017-2018',  '男', '1997', '11', '汉族','0','0', '0', '0', '0', '0', '18005801234','330902199612120990','家庭地址',123456,13213,1231,31321,3132,24234,4,1231,31321,2,313231,31321,123123,32131,321321);

INSERT INTO db_workstudy.scholarship(studentId, tableYear, sex, birthYear, birthMonth, politicalStatus, nation, startYear, startMonth, studyYears, phone, identityCardId, grade, courseNum, passNum, rank, reason) VALUES
  ('1234','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2016-2017',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2015-2016',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2014-2015',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2013-2014',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2012-2013',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2011-2012',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2010-2011',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2009-2010',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2008-2009',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('1234','2007-2008',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405001','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405002','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405003','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405004','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405005','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405006','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405007','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405008','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405009','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉'),
  ('2015210405010','2017-2018',  '男', '1997', '11','共青团员', '汉族','2015','09',  '肆年','18005801234', '330902123456780000', '12/40', '12','12',1,'申请原因巴拉巴拉');

INSERT INTO db_workstudy.stipend(studentId, tableYear, sex, birthYear, birthMonth, nation, startYear, startMonth, politicalStatus, identityCardId, phone, residence, incomeSource, incomePerMonth, peopleNumber, address, postcode, reason) VALUES
  ('1234','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2016-2017',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2015-2016',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2014-2015',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2013-2014',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2012-2013',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2011-2012',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2010-2011',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2009-2010',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2008-2009',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('1234','2007-2008',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405001','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405002','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405003','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405004','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405005','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405006','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405007','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405008','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405009','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉'),
  ('2015210405010','2017-2018',  '男', '1997', '11', '汉族','2015','09', '共青团员', '330902123456780000', '18005801234', 0,'收入来源',1234,3,'地址',123456,'申请原因巴拉巴拉');


INSERT INTO timecontrol (admitApplyTeacher, stipendTeacher, encouragementTeacher, scholarshipTeacher, discountFeeTeacher, admitApplySt, questionarySt, stipendSt, encouragementSt, scholarshipSt, discountFeeSt)
VALUES (0,0,0,0,0,0,0,0,0,0,0);