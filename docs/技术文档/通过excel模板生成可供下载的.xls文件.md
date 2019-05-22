# POI 实现Excel按模板导出
参考链接:[SpringMVC+POI 实现Excel按模板方式简单导出功能](http://blog.csdn.net/onepersontz/article/details/50034501)  
  
maven
```text
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.16</version>
</dependency>
```
本项目在上面的基础上，修改了模板文件路径为`resource/template`(与word统一)  
  
效果演示，访问`/exportExcelTest`路径  

代码基本照抄那个博客的，部分代码修改以适应本框架。  
  
测试文件：
```text
docs/表单生成/excel/测试模板.xlsx
```
项目代码文件：
```text
src/main/resource/template/测试模板.xlsx
src/main/java/com.workstudy.ssm/controller/ExportExcelController
src/main/java/com.workstudy.ssm/utils/ExportExcelUtil
src/main/java/com.workstudy.ssm/vo/InfoVo
```

## 操作步骤
1. 吧Excel文件放到template目录
1. 根据填充数据域


# 完成后的总结
1. 别人的代码总归是别人的。。。吧demo改成自己的情况就各种问题，所以又做了几个封装，查文档写代码真酸爽。。。
1. 导出excel唯一的好处就是文件不需要预处理，直接吧文件放进template文件夹就好（为了写名字方便我重命名了一下）
1. 为了操作方便行对象弄了个抽象函数，之后每个excel对应的vo（每个字段对应excel的一列）继承抽象函数并实现抽象方法就好了
1. 代码都有详细注释。
