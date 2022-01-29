# sharding-jdbc 目录结构

sjdbc-read-write-springboot：Spring Boot版 Sharding JDBC 读写分离示列

sjdbc-db-sharding-springboot：Spring Boot版 Sharding JDBC 垂直拆分（不同的表在不同的库中）

sjdbc-db-read-write-sharding-springboot：Spring Boot版 Sharding JDBC 垂直拆分（不同的表在不同的库中）+ 读写分离

sjdbc-sharding-table-springboot：Spring Boot版 Sharding JDBC 不分库，只分表案例

sjdbc-sharding-table-read-write-springboot：Spring Boot版 Sharding JDBC 不分库，只分表+读写分离案例

sjdbc-db-sharding-table-springboot：Spring Boot版 Sharding JDBC 分库分表案例

sjdbc-db-sharding-table-read-write-springboot：Spring Boot版 Sharding JDBC 分库分表+读写分离案例

sjdbc-db-sharding-table-read-write-range-group-springboot：Spring Boot版 Sharding JDBC 分库分表+读写分离案例(范围分表+取模=无限扩容)

# sharding-jdbc 相关文章

[Sharding-JDBC:查询量大如何优化？](https://mp.weixin.qq.com/s/kp2lJHpTMz4bDWkJYjVbOQ)

[Sharding-JDBC:垂直拆分怎么做？](https://mp.weixin.qq.com/s/wl8h6LIQUHztVuVbjfsU3Q)

[Sharding-JDBC:单库分表的实现](http://cxytiandi.com/blog/detail/36400)

[一致性hash](https://mp.weixin.qq.com/s/yflzIQFiNa3tDJm7U9P8ig)

# 扩容数据迁移问题
1、停机发布：好处是简单，风险小；缺点是业务有损。
2、平滑迁移：从某一点开始设置checkpoint , 然后执行数据双写，最后修改路由，删除旧数据，完成扩容。

# 事务问题
1、分布式事务：比如seata分布式框架
2、程序+业务逻辑：业务逻辑按照一定规则将涉及的表操作都落到同一个库上，避免了数据库锁竞争和分布式事务；对于金融属性的强一致要求，采用了非常重的侵入式TCC来保证全局支付事务的一致。

# 查询问题
之前一个库就能搞定的join，count等各种联合查询，将不复存在，老老实实调接口在代码层面实现吧。

[ZDAL中间件]：可以在分布式环境下看上去像传统数据库一样提供海量数据服务，是一种通用的分库分表数据库访问框架。