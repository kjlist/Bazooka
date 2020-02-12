CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT '2020-01-01 00:00:00',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(40) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(45) NOT NULL DEFAULT '' COMMENT '登录密码',
  `realname` varchar(40) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `status` tinyint(4) NOT NULL COMMENT '当前是否可用，即状态,1启用2暂停3被删除',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';