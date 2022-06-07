-- 修改字符集
ALTER TABLE  db_shop.t_shop CHANGE  shop_name shop_name  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_shop.t_dict CHANGE  dict_value dict_value  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;

ALTER TABLE  db_product_0.t_dict CHANGE  dict_value dict_value  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_0.t_product_base_0 CHANGE  prod_name prod_name  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_0.t_product_base_1 CHANGE  prod_name prod_name  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_0.t_product_detail_0 CHANGE  prod_detail_info prod_detail_info  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_0.t_product_detail_1 CHANGE  prod_detail_info prod_detail_info  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;

ALTER TABLE  db_product_1.t_dict CHANGE  dict_value dict_value  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_1.t_product_base_0 CHANGE  prod_name prod_name  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_1.t_product_base_1 CHANGE  prod_name prod_name  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_1.t_product_detail_0 CHANGE  prod_detail_info prod_detail_info  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;
ALTER TABLE  db_product_1.t_product_detail_1 CHANGE  prod_detail_info prod_detail_info  VARCHAR( 50 ) CHARACTER SET utf8 COLLATE utf8_general_ci ;

-- 查看表字段字符集编码
show full columns from db_product_0.t_dict;
show full columns from db_product_1.t_dict;
show full columns from db_shop.t_dict;