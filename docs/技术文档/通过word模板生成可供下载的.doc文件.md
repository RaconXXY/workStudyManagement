# 用Freemarker生成Word文档
参考链接:[Java Web项目中使用Freemarker生成Word文档](http://blog.csdn.net/jackfrued/article/details/39449021)  
  
本项目在上面的基础上，修改了模板文件路径为`resource/template`(因为作为Java的包不会出现在class编译目录下，我也不知道为啥...)  
  
效果演示，访问`/saveWordTest`路径  

代码基本照抄那个博客的，部分代码修改以适应本框架。  
  
测试文件：
```text
docs/表单生成/word/测试/测试.docx
docs/表单生成/word/测试/测试.xml
docs/表单生成/word/测试/resume.ftl
```
项目代码文件：
```text
src/main/resource/template/resume.ftl
src/main/java/com.workstudy.ssm/controller/SaveWordController
src/main/java/com.workstudy.ssm/utils/WordGenerator
```

## 操作步骤
1. 在word文档要填充的地方加上${变量名} 比如${name}
1. 全部加完后右键另存为.xml文件
1. .xml文件复制粘贴一份改后缀名为ftl
1. 打开ftl文件查看所有被拆开的变量名，吧他们之间的东西删除
1. 吧改好的文档复制到template目录并修改utils里的WordGenerator的静态代码块(put进去就好了)
  
举个例子：  
`${name}`生成xml的时候有可能被拆成了`${<xxx><xxx>name<xxx>}`
就要吧多余的`<xxx>`删除变成`${name}`
 因为最后我们的代码会读取这些变量名然后替换成我们想要的数据
 
 
# 完成后的总结
1. 因为最后字段实在是太多了，所以修改ftl部分简直是噩梦，研究了一天写了几个正则
1. 有些字段可以通过复制为空字符串达到不填的效果，但是字段要有不然会报错
1. ajax不能下载，所以只能用伪装form进行提交，还好jq的DOM操作还是很方便的
1. 对象数组后端Java那里会变成"Object"字符串所以选择前端写了个函数转为data的属性然后通过for in生成form
1. 测试可以不用自己填啊，直接弄个测试数据提交就好了。。。之前傻逼手动填写。。。
