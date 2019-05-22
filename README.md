# 勤工项目

- 架构
    - jsp
    - servlet
    - MySQL
- 框架
    - Spring MVC
    - MyBatis
- 环境
    - jdk 1.8
    - Tomcat 8.0
    - Maven 3
- 运行
    - 部署tomcat
    - 执行src/main/Java/SQL/init.sql
    - 若第一次运行执行下面分配user的sql语句
    - 命令行进入src/main/webapp/WEB-INF/lib目录执行`bower install`(若未安装bower，执行`npm i -g bower`)
    - 浏览器打开运行
- 部署
    - 安装jdk
    - 安装Tomcat
    - 根据docs/fonts/README.md安装fonts下的字体文件
    - 把war文件改为ROOT.war放到Tomcat的webapp下
    - 启动Tomcat

  
分配user的sql语句
```sql
CREATE USER 'workStudy'@'localhost' IDENTIFIED BY '123456';
GRANT ALL ON db_workstudy.* TO 'workStudy'@'localhost';
```

要引入js，css文件路径一律用"/js/xxx.js","/css/xxx.css"(其他静态资源相同)  
  
后端接口在Java/com.workstudy.ssm下，数据库SQL写在resource/mapping下，对应一个接口写一套数据结构(model/dao)然后在mapping文件夹下新建xml写SQL  

根据相应业务逻辑写controller/service以及service的实现类
## WARNING!上线时注意
使用的数据库是MySQL，库名db_workstudy，并创建了用户'workStudy'@'localhost'密码123456  

务必修改：
- `/src/main/java/com.workstudy.ssm/utils/JWT`文件里面的` private static final String SECRET`字段的值
- `/src/main/resources/jdbc.properties`文件里面的` username=workStudy`和`password=123456`(连同init.sql一起修改，保持一致)

