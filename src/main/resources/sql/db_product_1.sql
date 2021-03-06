create schema db_product_1 collate utf8_general_ci;

use db_product_1;

create table t_dict
(
	dict_code varchar(20) charset utf8 null comment '字典编码',
	dict_value varchar(50) null
)
comment '字典表' charset=utf8;

create table t_product_base_0
(
	prod_id bigint not null
		primary key,
	prod_name varchar(50) null,
	shop_id int not null comment '店铺id',
	prod_type varchar(20) charset utf8 null comment '商品分类'
)
comment '商品基础表' charset=utf8;

create table t_product_base_1
(
	prod_id bigint not null
		primary key,
	prod_name varchar(50) null,
	shop_id int not null comment '店铺id',
	prod_type varchar(20) charset utf8 null comment '商品分类'
)
comment '商品基础表' charset=utf8;

create table t_product_detail_0
(
	id bigint not null
		primary key,
	prod_id bigint not null,
	prod_detail_info varchar(50) null,
	shop_id int null
)
comment '商品详情表' charset=utf8;

create table t_product_detail_1
(
	id bigint not null
		primary key,
	prod_id bigint not null,
	prod_detail_info varchar(50) null,
	shop_id int null
)
comment '商品详情表' charset=utf8;

