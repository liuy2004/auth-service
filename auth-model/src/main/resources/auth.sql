-- 删除 auth_user 表
DROP TABLE `auth_user`;
CREATE TABLE `auth_user` (
  `id`                       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '主键',
  `nick_name`                VARCHAR(64)         NOT NULL
  COMMENT '昵称',
  `username`                 VARCHAR(32)         NOT NULL
  COMMENT '用户名',
  `password`                 VARCHAR(64)         NOT NULL
  COMMENT '密码',
  `enabled`                  bit(1)              NOT NULL DEFAULT 1
  COMMENT '状态',
  `lock_status`              bit(1)              NOT NULL DEFAULT 0
  COMMENT '锁定状态',
  `expired_date`             TIMESTAMP(0)        NOT NULL DEFAULT '2038-01-01 00:00:00'
  COMMENT '过期时间',
  `credentials_expired_date` TIMESTAMP(0)        NOT NULL DEFAULT '2038-01-01 00:00:00'
  COMMENT '凭证过期时间',
  `create_time`              TIMESTAMP(0)        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`                  BIGINT(20)          NOT NULL DEFAULT 0
  COMMENT '创建人',
  `modify_time`              TIMESTAMP(0)        NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`                 BIGINT(20)          NOT NULL DEFAULT 0
  COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uniq_username` (`username`),
  KEY `idx_create_time` (`create_time`) USING BTREE
)
  ENGINE = INNODB
  CHARACTER
  SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Compact
  AUTO_INCREMENT = 10001
  COMMENT = '用户认证信息'; -- 删除 auth_user_detail 表
DROP TABLE `auth_user_detail`;
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
  `create_time` TIMESTAMP(0)        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `creator`     BIGINT(20)          NOT NULL DEFAULT 0
  COMMENT '创建人',
  `modify_time` TIMESTAMP(0)        NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `modifier`    BIGINT(20)          NOT NULL DEFAULT 0
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