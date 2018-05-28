-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE
IF
EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id`                       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `nick_name`                VARCHAR(64)         NOT NULL DEFAULT ''
  COMMENT '昵称',
  `username`                 VARCHAR(32)         NOT NULL
  COMMENT '用户名',
  `password`                 VARCHAR(64)         NOT NULL
  COMMENT '密码',
  `enabled`                  bit(1)              NOT NULL DEFAULT 1
  COMMENT '状态[0:未启用;1:启用]',
  `lock_status`              bit(1)              NOT NULL DEFAULT 0
  COMMENT '锁定状态[0:未锁定;1:锁定]',
  `expired_date`             DATETIME            NOT NULL DEFAULT '9999-12-31 23:59:59'
  COMMENT '过期时间',
  `credentials_expired_date` DATETIME            NOT NULL DEFAULT '9999-12-31 23:59:59'
  COMMENT '凭证过期时间',
  `create_time`              DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`                  BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time`              DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`                 BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_username_password` (`username`, `password`),
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Compact
  AUTO_INCREMENT = 10001
  COMMENT = '用户认证信息';

-- ----------------------------
-- Table structure for auth_user_detail
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_user_detail`;
CREATE TABLE `auth_user_detail` (
  `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `email`       VARCHAR(50)         NOT NULL
  COMMENT '邮箱',
  `mobile`      VARCHAR(20)         NOT NULL
  COMMENT '手机号',
  `name`        VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '姓名',
  `birthday`    DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '出生日期',
  `description` VARCHAR(255)        NOT NULL DEFAULT ''
  COMMENT '描述',
  `website`     VARCHAR(50)         NOT NULL DEFAULT ''
  COMMENT '主页',
  `favicon`     VARCHAR(150)        NOT NULL DEFAULT ''
  COMMENT '头像',
  `create_time` DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time` DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`    BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_email` (`email`),
  UNIQUE KEY `uniq_mobile` (`mobile`),
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Compact
  AUTO_INCREMENT = 10001
  COMMENT = '用户详细信息';

-- ----------------------------
-- Table structure for auth_organization
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_organization`;
CREATE TABLE `auth_organization` (
  `id`           BIGINT(20) UNSIGNED NOT NULL auto_increment
  COMMENT '主键',
  `name`         VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '名称',
  `code`         VARCHAR(20)         NOT NULL
  COMMENT '组织机构代码简拼（确保唯一）',
  `level`        INT(11)             NOT NULL
  COMMENT '级别',
  `sort`         INT(11)             NOT NULL DEFAULT 1
  COMMENT '默认排序字段',
  `parent_id`    BIGINT(20) UNSIGNED NOT NULL
  COMMENT '父级 id',
  `parent_codes` VARCHAR(300)        NOT NULL
  COMMENT '父级所有代码简称拼接[分割符;]',
  `create_time`  datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`      BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time`  datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_code` (`code`),
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  row_format = compact
  auto_increment = 10001
  COMMENT = '组织机构';

-- ----------------------------
-- Table structure for auth_organization
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_organization`;
CREATE TABLE `auth_organization` (
  `id`           BIGINT(20) UNSIGNED NOT NULL auto_increment
  COMMENT '主键',
  `name`         VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '名称',
  `code`         VARCHAR(20)         NOT NULL
  COMMENT '组织机构代码（确保唯一）',
  `level`        INT(11)             NOT NULL
  COMMENT '级别',
  `sort`         INT(11)             NOT NULL DEFAULT 1
  COMMENT '默认排序字段',
  `parent_id`    BIGINT(20) UNSIGNED NOT NULL
  COMMENT '父级 id',
  `parent_codes` VARCHAR(300)        NOT NULL
  COMMENT '父级所有代码简称拼接[分割符;]',
  `create_time`  datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`      BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time`  datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_code` (`code`),
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  row_format = compact
  auto_increment = 10001
  COMMENT = '组织机构';

-- ----------------------------
-- Table structure for auth_role_group
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_role_group`;
CREATE TABLE `auth_role_group` (
  `id`          BIGINT(20) UNSIGNED NOT NULL auto_increment
  COMMENT '主键',
  `name`        VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '名称',
  `code`        VARCHAR(20)         NOT NULL
  COMMENT '角色组代码',
  `sort`        INT(11)             NOT NULL DEFAULT 1
  COMMENT '默认排序字段',
  `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`    BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_code` (`code`),
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  row_format = compact
  auto_increment = 10001
  COMMENT = '角色组信息';

-- ----------------------------
-- Table structure for auth_role
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id`          BIGINT(20) UNSIGNED NOT NULL auto_increment
  COMMENT '主键',
  `name`        VARCHAR(20)         NOT NULL DEFAULT ''
  COMMENT '名称',
  `code`        VARCHAR(20)         NOT NULL
  COMMENT '角色代码',
  `sort`        INT(11)             NOT NULL DEFAULT 1
  COMMENT '默认排序字段',
  `group_id`    BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '角色组 id',
  `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`    BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_code` (`code`),
  KEY `idx_group_id` (`group_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  row_format = compact
  auto_increment = 10001
  COMMENT = '角色信息';

-- ----------------------------
-- Table structure for auth_user_role_group
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_user_role_group`;
CREATE TABLE `auth_user_role_group` (
  `id`          BIGINT(20) UNSIGNED NOT NULL auto_increment
  COMMENT '主键',
  `group_id`    BIGINT(20) UNSIGNED NOT NULL
  COMMENT '角色组 id',
  `user_id`     BIGINT(20) UNSIGNED NOT NULL
  COMMENT '用户 id',
  `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`    BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_id_group_id` (`user_id`, `group_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  row_format = compact
  auto_increment = 10001
  COMMENT = '用户角色组关联信息';

-- ----------------------------
-- Table structure for auth_user_role
-- ------------------------------
DROP TABLE
IF
EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role` (
  `id`          BIGINT(20) UNSIGNED NOT NULL auto_increment
  COMMENT '主键',
  `role_id`     BIGINT(20) UNSIGNED NOT NULL
  COMMENT '角色 id',
  `user_id`     BIGINT(20) UNSIGNED NOT NULL
  COMMENT '用户 id',
  `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`     BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '创建人',
  `modify_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`    BIGINT(20) UNSIGNED NOT NULL DEFAULT 1
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_user_id_role_id` (`user_id`, `role_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  row_format = compact
  auto_increment = 10001
  COMMENT = '用户角色关联信息';