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

# Sharding事务支持
## 本地事务(默认)
### 支持项
1、非跨库事务，完全支持
2、因逻辑异常导致跨库事务，完全支持
### 不支持项
1、不支持网络、硬件异常导致的跨库事务
## XA事务
实现了两阶段协议，严格保证ACID特性。适用于短事务，不适用于长事务，会锁定全部资源，不适合高并发场景。
## SEATA柔性事务
严格遵守ACID特性的事务是刚性事务，则遵守BASE理论的事务称为柔性事务。将资源的互斥锁操作上移到业务逻辑层面处理，
强调数据的最终一致性，放宽对于强一致性的要求，从而达到更高的并发和吞吐量。

