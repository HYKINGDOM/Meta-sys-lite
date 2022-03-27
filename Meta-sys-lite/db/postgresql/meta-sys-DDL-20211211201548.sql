DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
    id INT(32) NOT NULL AUTO_INCREMENT,
    user_id INT(32),
    user_acount VARCHAR(32),
    user_name VARCHAR(32),
    user_email VARCHAR(32),
    email_status int(1),
    account_status int(1),
    user_password VARCHAR(255),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sys_user IS '';
COMMENT ON COLUMN sys_user.id IS 'id';
COMMENT ON COLUMN sys_user.user_id IS '用户id';
COMMENT ON COLUMN sys_user.user_acount IS '账户';
COMMENT ON COLUMN sys_user.user_name IS '用户名';
COMMENT ON COLUMN sys_user.user_email IS '邮箱';
COMMENT ON COLUMN sys_user.email_status IS '邮箱状态';
COMMENT ON COLUMN sys_user.account_status IS '用户状态';
COMMENT ON COLUMN sys_user.user_password IS '用户密码';
COMMENT ON COLUMN sys_user.create_by IS '创建人';
COMMENT ON COLUMN sys_user.create_time IS '创建时间';
COMMENT ON COLUMN sys_user.update_by IS '更新人';
COMMENT ON COLUMN sys_user.update_time IS '更新时间';

DROP TABLE IF EXISTS sys_user_info;
CREATE TABLE sys_user_info(
    id INT(32) NOT NULL AUTO_INCREMENT,
    user_id INT(32) NOT NULL,
    user_icon VARCHAR(255),
    user_address VARCHAR(255),
    online_sum_time VARCHAR(255),
    register_time DATE,
    register_ip VARCHAR(64),
    last_login_time DATE,
    last_login_ip VARCHAR(64),
    localtion_time_zone VARCHAR(32),
    user_phone VARCHAR(32),
    user_phone_status INT(1),
    personal_signature VARCHAR(900),
    PRIMARY KEY (id)
);

COMMENT ON TABLE sys_user_info IS '';
COMMENT ON COLUMN sys_user_info.id IS 'id';
COMMENT ON COLUMN sys_user_info.user_id IS '用户id';
COMMENT ON COLUMN sys_user_info.user_icon IS '用户头像';
COMMENT ON COLUMN sys_user_info.user_address IS '用户地址';
COMMENT ON COLUMN sys_user_info.online_sum_time IS '用户在线总时间';
COMMENT ON COLUMN sys_user_info.register_time IS '注册时间';
COMMENT ON COLUMN sys_user_info.register_ip IS '注册IP地址';
COMMENT ON COLUMN sys_user_info.last_login_time IS '最后一次登陆时间';
COMMENT ON COLUMN sys_user_info.last_login_ip IS '最后一次登录ip';
COMMENT ON COLUMN sys_user_info.localtion_time_zone IS '用户时区';
COMMENT ON COLUMN sys_user_info.user_phone IS '用户手机号';
COMMENT ON COLUMN sys_user_info.user_phone_status IS '手机号状态';
COMMENT ON COLUMN sys_user_info.personal_signature IS '用户签名';

DROP TABLE IF EXISTS sys_org;
CREATE TABLE sys_org(
    id INTEGER NOT NULL AUTO_INCREMENT,
    org_id INT(32),
    org_name VARCHAR(32),
    parent_org_id INT(32),
    org_status int(1),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sys_org IS '';
COMMENT ON COLUMN sys_org.id IS 'id';
COMMENT ON COLUMN sys_org.org_id IS '组织id';
COMMENT ON COLUMN sys_org.org_name IS '组织名';
COMMENT ON COLUMN sys_org.parent_org_id IS '父组织id';
COMMENT ON COLUMN sys_org.org_status IS '组织状态';
COMMENT ON COLUMN sys_org.create_by IS '创建人';
COMMENT ON COLUMN sys_org.create_time IS '创建时间';
COMMENT ON COLUMN sys_org.update_by IS '更新人';
COMMENT ON COLUMN sys_org.update_time IS '更新时间';

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
    id INTEGER NOT NULL AUTO_INCREMENT,
    role_id INT(32),
    role_name VARCHAR(32),
    parent_role_id INT(32),
    role_status INT(1),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sys_role IS '';
COMMENT ON COLUMN sys_role.id IS 'id';
COMMENT ON COLUMN sys_role.role_id IS '角色id';
COMMENT ON COLUMN sys_role.role_name IS '角色名';
COMMENT ON COLUMN sys_role.parent_role_id IS '父角色id';
COMMENT ON COLUMN sys_role.role_status IS '角色状态';
COMMENT ON COLUMN sys_role.create_by IS '创建人';
COMMENT ON COLUMN sys_role.create_time IS '创建时间';
COMMENT ON COLUMN sys_role.update_by IS '更新人';
COMMENT ON COLUMN sys_role.update_time IS '更新时间';

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
    id INT(32) NOT NULL AUTO_INCREMENT,
    menu_id INT(32),
    menu_name VARCHAR(32),
    parent_menu_id INT(32),
    menu_url VARCHAR(80),
    menu_label VARCHAR(32),
    menu_status INT(1),
    menu_sort INT(10),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sys_menu IS '';
COMMENT ON COLUMN sys_menu.id IS 'id';
COMMENT ON COLUMN sys_menu.menu_id IS '菜单id';
COMMENT ON COLUMN sys_menu.menu_name IS '菜单名';
COMMENT ON COLUMN sys_menu.parent_menu_id IS '父菜单名';
COMMENT ON COLUMN sys_menu.menu_url IS '菜单URL';
COMMENT ON COLUMN sys_menu.menu_label IS '菜单标签';
COMMENT ON COLUMN sys_menu.menu_status IS '菜单状态';
COMMENT ON COLUMN sys_menu.menu_sort IS '菜单排序';
COMMENT ON COLUMN sys_menu.create_by IS '创建人';
COMMENT ON COLUMN sys_menu.create_time IS '创建时间';
COMMENT ON COLUMN sys_menu.update_by IS '更新人';
COMMENT ON COLUMN sys_menu.update_time IS '更新时间';

DROP TABLE IF EXISTS sys_auth;
CREATE TABLE sys_auth(
    id INT(32) NOT NULL AUTO_INCREMENT,
    auth_id INT(32),
    auth_name VARCHAR(32),
    auth_status INT(1),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE sys_auth IS '';
COMMENT ON COLUMN sys_auth.id IS 'id';
COMMENT ON COLUMN sys_auth.auth_id IS '权限id';
COMMENT ON COLUMN sys_auth.auth_name IS '权限名';
COMMENT ON COLUMN sys_auth.auth_status IS '权限状态';
COMMENT ON COLUMN sys_auth.create_by IS '创建人';
COMMENT ON COLUMN sys_auth.create_time IS '创建时间';
COMMENT ON COLUMN sys_auth.update_by IS '更新人';
COMMENT ON COLUMN sys_auth.update_time IS '更新时间';

DROP TABLE IF EXISTS user_org_relation;
CREATE TABLE user_org_relation(
    id INT(32) NOT NULL AUTO_INCREMENT,
    user_id INT(32),
    org_id INT(32),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE user_org_relation IS '';
COMMENT ON COLUMN user_org_relation.id IS 'id';
COMMENT ON COLUMN user_org_relation.user_id IS '用户id';
COMMENT ON COLUMN user_org_relation.org_id IS '组织id';
COMMENT ON COLUMN user_org_relation.create_by IS '创建人';
COMMENT ON COLUMN user_org_relation.create_time IS '创建时间';
COMMENT ON COLUMN user_org_relation.update_by IS '更新人';
COMMENT ON COLUMN user_org_relation.update_time IS '更新时间';

DROP TABLE IF EXISTS user_role_relation;
CREATE TABLE user_role_relation(
    id INT(32) NOT NULL AUTO_INCREMENT,
    user_id INT(32),
    role_id INT(32),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE user_role_relation IS '';
COMMENT ON COLUMN user_role_relation.id IS 'id';
COMMENT ON COLUMN user_role_relation.user_id IS '用户id';
COMMENT ON COLUMN user_role_relation.role_id IS '角色id';
COMMENT ON COLUMN user_role_relation.create_by IS '创建人';
COMMENT ON COLUMN user_role_relation.create_time IS '创建时间';
COMMENT ON COLUMN user_role_relation.update_by IS '更新人';
COMMENT ON COLUMN user_role_relation.update_time IS '更新时间';

DROP TABLE IF EXISTS org_role_relation;
CREATE TABLE org_role_relation(
    id INT(32) NOT NULL AUTO_INCREMENT,
    org_id INT(32),
    role_id INT(32),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE org_role_relation IS '';
COMMENT ON COLUMN org_role_relation.id IS 'id';
COMMENT ON COLUMN org_role_relation.org_id IS '组织id';
COMMENT ON COLUMN org_role_relation.role_id IS '角色id';
COMMENT ON COLUMN org_role_relation.create_by IS '创建人';
COMMENT ON COLUMN org_role_relation.create_time IS '创建时间';
COMMENT ON COLUMN org_role_relation.update_by IS '更新人';
COMMENT ON COLUMN org_role_relation.update_time IS '更新时间';

DROP TABLE IF EXISTS role_menu_relation;
CREATE TABLE role_menu_relation(
    id INT(32) NOT NULL AUTO_INCREMENT,
    role_id INT(32),
    menu_id INT(32),
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE role_menu_relation IS '';
COMMENT ON COLUMN role_menu_relation.id IS 'id';
COMMENT ON COLUMN role_menu_relation.role_id IS '角色id';
COMMENT ON COLUMN role_menu_relation.menu_id IS '菜单id';
COMMENT ON COLUMN role_menu_relation.create_by IS '创建人';
COMMENT ON COLUMN role_menu_relation.create_time IS '创建时间';
COMMENT ON COLUMN role_menu_relation.update_by IS '更新人';
COMMENT ON COLUMN role_menu_relation.update_time IS '更新时间';

DROP TABLE IF EXISTS menu_auth_relation;
CREATE TABLE menu_auth_relation(
    id INT(32) NOT NULL AUTO_INCREMENT,
    create_by VARCHAR(32),
    create_time DATE,
    update_by VARCHAR(32),
    update_time DATE,
    PRIMARY KEY (id)
);

COMMENT ON TABLE menu_auth_relation IS '';
COMMENT ON COLUMN menu_auth_relation.id IS 'id';
COMMENT ON COLUMN menu_auth_relation.create_by IS '创建人';
COMMENT ON COLUMN menu_auth_relation.create_time IS '创建时间';
COMMENT ON COLUMN menu_auth_relation.update_by IS '更新人';
COMMENT ON COLUMN menu_auth_relation.update_time IS '更新时间';

