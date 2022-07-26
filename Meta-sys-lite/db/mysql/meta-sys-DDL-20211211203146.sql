DROP TABLE IF EXISTS sys_account;
CREATE TABLE sys_account(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    account_id INT(32)    COMMENT '用户id' ,
    account_number VARCHAR(32)    COMMENT '账户' ,
    password VARCHAR(255)    COMMENT '用户密码' ,
    account_email VARCHAR(32)    COMMENT '邮箱' ,
    email_status int(1)    COMMENT '邮箱状态' ,
    account_status int(1)    COMMENT '用户状态' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS sys_account_info;
CREATE TABLE sys_account_info(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    account_id INT(32) NOT NULL   COMMENT '用户id' ,
    account_name VARCHAR(32)    COMMENT '用户名' ,
    account_icon VARCHAR(255)    COMMENT '用户头像' ,
    account_address VARCHAR(255)    COMMENT '用户地址' ,
    online_sum_time VARCHAR(255)    COMMENT '用户在线总时间' ,
    register_time DATETIME    COMMENT '注册时间' ,
    register_ip VARCHAR(64)    COMMENT '注册IP地址' ,
    last_login_time DATETIME    COMMENT '最后一次登陆时间' ,
    last_login_ip VARCHAR(64)    COMMENT '最后一次登录ip' ,
    location_time_zone VARCHAR(32)    COMMENT '用户时区' ,
    mobile_phone VARCHAR(32)    COMMENT '用户手机号' ,
    mobile_phone_status INT(1)    COMMENT '手机号状态' ,
    personal_signature VARCHAR(900)    COMMENT '用户签名' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS sys_org;
CREATE TABLE sys_org(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    org_id INT(32)    COMMENT '组织id' ,
    org_name VARCHAR(32)    COMMENT '组织名' ,
    parent_org_id INT(32)    COMMENT '父组织id' ,
    org_status int(1)    COMMENT '组织状态' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    role_id INT(32)    COMMENT '角色id' ,
    role_name VARCHAR(32)    COMMENT '角色名' ,
    parent_role_id INT(32)    COMMENT '父角色id' ,
    role_status INT(1)    COMMENT '角色状态' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    menu_id INT(32)    COMMENT '菜单id' ,
    menu_name VARCHAR(32)    COMMENT '菜单名' ,
    parent_menu_id INT(32)    COMMENT '父菜单名' ,
    menu_url VARCHAR(80)    COMMENT '菜单URL' ,
    menu_label VARCHAR(32)    COMMENT '菜单标签' ,
    menu_status INT(1)    COMMENT '菜单状态' ,
    menu_sort INT(10)    COMMENT '菜单排序' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS sys_auth;
CREATE TABLE sys_auth(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    auth_id INT(32)    COMMENT '权限id' ,
    auth_name VARCHAR(32)    COMMENT '权限名' ,
    auth_status INT(1)    COMMENT '权限状态' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS account_org_relation;
CREATE TABLE account_org_relation(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    account_id INT(32)    COMMENT '用户id' ,
    org_id INT(32)    COMMENT '组织id' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS account_role_relation;
CREATE TABLE account_role_relation(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    account_id INT(32)    COMMENT '用户id' ,
    role_id INT(32)    COMMENT '角色id' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS org_role_relation;
CREATE TABLE org_role_relation(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    org_id INT(32)    COMMENT '组织id' ,
    role_id INT(32)    COMMENT '角色id' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS role_menu_relation;
CREATE TABLE role_menu_relation(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    role_id INT(32)    COMMENT '角色id' ,
    menu_id INT(32)    COMMENT '菜单id' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

DROP TABLE IF EXISTS menu_auth_relation;
CREATE TABLE menu_auth_relation(
    id INT(32) NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    create_by VARCHAR(32)    COMMENT '创建人' ,
    create_time DATETIME    COMMENT '创建时间' ,
    update_by VARCHAR(32)    COMMENT '更新人' ,
    update_time DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '';

