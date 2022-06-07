create schema if not exists db_shop collate latin1_swedish_ci;

create table if not exists t_dict
(
	dict_code varchar(20) charset latin1 null comment '字典编码',
	dict_value varchar(50) null
)
comment '字典表' charset=utf8;

create table if not exists t_shop
(
	shop_id int not null
		primary key,
	shop_name varchar(50) null,
	shop_type varchar(20) charset latin1 null comment '店铺类型'
)
comment '店铺表' charset=utf8;

