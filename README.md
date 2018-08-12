# annotation-aspect-example
自定义注解及切面使用的例子

### 如何运行这个例子

 1. 创建数据库：


```sql
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `username` varchar(16) DEFAULT NULL COMMENT '用户名',
  `password` varchar(16) DEFAULT NULL COMMENT '密码',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标识：0：已删除 1：未删除',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
```


 2 . 修改配置文件`application.properties`,配置合适的端口和正确的数据库信息。

 3 . 运行 `DemoApplication.java`，启动项目，成功启动后浏览器打开`http://localhost:8008/swagger-ui.html`,便可以看到swagger API展示界面，进行API调试
