create schema db_shop collate utf8_general_ci;

use db_shop;

create table t_dict
(
	dict_code varchar(20) charset utf8 null comment '字典编码',
	dict_value varchar(50) null
)
comment '字典表' charset=utf8;

create table t_shop
(
	shop_id int not null
		primary key,
	shop_name varchar(50) null,
	shop_type varchar(20) charset utf8 null comment '店铺类型'
)
comment '店铺表' charset=utf8;

