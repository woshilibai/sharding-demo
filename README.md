# sharding-demo
数据分片：分库策略、分表策略
读写分离

# mysql主从同步搭建踩坑：
1、公司加密软件导致mysql服务无法启动
2、主从server-uuid相同导致同步环境搭建失败
主从复制报错Fatal error:The slave I/O thread stops because master and slave have equal MySQL server UUIDs；
https://blog.csdn.net/cnds123321/article/details/117925881
3、mysql8.x密码加密规则更新为caching_sha2_password导致同步环境搭建失败
关于连接MySQL出现Authentication plugin ‘caching_sha2_password’ cannot be loaded的解决方法。
https://blog.csdn.net/weixin_44979475/article/details/120343042