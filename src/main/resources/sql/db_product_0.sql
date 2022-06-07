create schema if not exists db_product_0 collate latin1_swedish_ci;

create table if not exists t_dict
(
	dict_code varchar(20) charset latin1 null comment '字典编码',
	dict_value varchar(50) null
)
comment '字典表' charset=utf8;

create table if not exists t_product_base_0
(
	prod_id varchar(30) charset latin1 not null
		primary key,
	prod_name varchar(50) null,
	shop_id int not null comment '店铺id',
	prod_type varchar(20) charset latin1 null comment '商品分类'
)
comment '商品基础表' charset=utf8;

create table if not exists t_product_base_1
(
	prod_id varchar(30) charset latin1 not null
		primary key,
	prod_name varchar(50) null,
	shop_id int not null comment '店铺id',
	prod_type varchar(20) charset latin1 null comment '商品分类'
)
comment '商品基础表' charset=utf8;

create table if not exists t_product_detail_0
(
	prod_id varchar(30) charset latin1 not null
		primary key,
	prod_detail_info varchar(50) null,
	shop_id int null
)
comment '商品详情表' charset=utf8;

create table if not exists t_product_detail_1
(
	prod_id varchar(30) charset latin1 not null
		primary key,
	prod_detail_info varchar(50) null,
	shop_id int null
)
comment '商品详情表' charset=utf8;

