># JDBC 之 "屌丝逆袭女神"
## 一.JDBC简介
>JDBC全称为 Java Data BaseConnectivity(java数据库链接) 可以为多个数据库提供统一访问方式,体现java"编写一次,处处运行"的高大上精神,通俗来说,JDBC是一种java连接数据库的工具,它是同一的标准,它是统一的标准,不同的数据库都会使用这个接口.

![结构图](https://github.com/MicroKibaco/jdbc_query_girl/blob/1cf79b04c43015f40b8ab9cdeccf4754c65827d8/docs/structure.png)


#### 我们举例说明一下
```
比如:登录,我们需要用户名和密码,就会传到我们应用的服务器里面, 服务器就会调用我们的JDBC,把用户名和密码传入过去,去查询用户名和密码是否匹配,当查询返回结果后,应用服务器来分析结果, 如果结果是正确的,那么,就会跳转到页面的首页,如果密码是错误的,那么我们就提示用户未注册或者密码错误,在整个流程中,参与用户名,用户名密码与数据库的流通就是我们要学习的JDBC
```

![举个栗子](https://github.com/MicroKibaco/jdbc_query_girl/blob/1cf79b04c43015f40b8ab9cdeccf4754c65827d8/docs/Example.png)

## 二.使用详解
> 1.工欲善其事必先利其器
 * 明确目的:需求(做什么)
  - 实现屌丝逆袭
  -  拥有女神禁区,享有查看,添加,修改,删除功能
* 指导思想:概样设计(怎么做)
* 工具准备 MySQL(数据库) ,IntelliJ IDEA(开发工具),Navicat(数据库管理工具)
1.JDBC常用接口
2.JDBC编辑步骤
* JDBC编程步骤
 - 加载驱动程序: Class.forName(diverClass)
  - 加载MySQL驱动: ClassforName("com.mysql.jdbc.Driver")
  - 加载Orcale驱动: ClassforName("orcal.jdbc.driver.OrcaleDriver")
* 获得数据库连接
```SQL
create table query_girl(
id int primary key auto_increment,
user_name varchar(30) not null,
sex int,
age int,
birthday date,
email varchar(30),
mobile varchar(11),
create_user varchar(30),
create_date date,
update_user varchar(30),
update_date date,
isdel int
)engine=innodb default charset=utf8 auto_increment=1;

alter database queryGirl default character set 'utf8';
SET character_set_client='utf8';
SET character_set_connection='utf8';
SET character_set_results='utf8';
```
![数据库表](https://github.com/MicroKibaco/jdbc_query_girl/blob/1cf79b04c43015f40b8ab9cdeccf4754c65827d8/docs/mydatabase.png)

 - DriverManager.getConnection("jdbc:mysql://localhost:port/Tables","userName","password") 

![我犯下的错](https://github.com/MicroKibaco/jdbc_query_girl/blob/1cf79b04c43015f40b8ab9cdeccf4754c65827d8/docs/myError.png)

* 创建statement对象:
 -  conn.createStatement();
3.执行SQL语句
4.管理结果集
5.事物管理
##三.高级应用
1.分页
2.高级查询
3.高级函数使用


