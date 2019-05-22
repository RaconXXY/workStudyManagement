# linux上安装字体
1. 在/usr/share/fonts目录下建立一个子目录，例如win，命令如下：  
    `# mkdir /usr/share/fonts/win`  
1. xxx.ttf复制到该目录下，例如这两个文件放在/root/Desktop下，使用命令：  
    `# cd /root/Desktop`  
    `# cp msyh.ttf msyhbd.ttf  /usr/share/fonts/win/`  
    或者我是用pscp结合ssh上传的，文件放在ppk文件目录下的fonts下  
    `# pscp -i ./dreamhuan.ppk -l ubuntu ./fonts/* ubuntu@123.206.111.244:/usr/share/fonts/win`  
    pscp+ssh上传基本命令格式`# pscp -i ppk文件路径 -l 目的主机登录名 本地文件路径 远程主机名@IP:远程路径名`
1. 建立字体索引信息，更新字体缓存：  
    `# cd /usr/share/fonts/win`  
    `# mkfontscale`  
    `# mkfontdir`  
    `# fc-cache`  
至此，字体已经安装完毕！