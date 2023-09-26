/*
version:1
*/
CREATE TABLE dcj_example (
id bigint(20) NOT NULL AUTO_INCREMENT,
code varchar(64) NOT NULL COMMENT '编码',
name varchar(64) NOT NULL COMMENT '名称',
object_version_number bigint(20),
created_by bigint(20),
creation_date datetime DEFAULT CURRENT_TIMESTAMP,
last_updated_by bigint(20),
last_update_date datetime DEFAULT CURRENT_TIMESTAMP,
UNIQUE KEY dcj_example_u1 (`code`), 
PRIMARY KEY(`id`)
)ENGINE=innodb  CHARSET=utf8mb4 COMMENT='创建表测试';

