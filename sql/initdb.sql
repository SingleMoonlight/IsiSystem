# 建库
CREATE DATABASE `isisystem`;
USE `isisystem`;


# 建表
# 委托方表
CREATE TABLE `client_info` (
    `client_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '委托方id',
    `client_name` varchar(16) NOT NULL COMMENT '委托方名称',
    `client_description` varchar(200) COMMENT '委托方描述',
    PRIMARY KEY (`client_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 项目信息表
CREATE TABLE `project_info` (
    `project_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '项目id',
    `project_name` varchar(16) NOT NULL COMMENT '项目名称',
    `project_description` varchar(200) COMMENT '项目描述',
    `project_owner` varchar(16) NOT NULL COMMENT '项目负责人姓名',
    `project_owner_phone` varchar(16) NOT NULL COMMENT '项目负责人电话',
    `project_state` bigint(2) NOT NULL COMMENT '项目状态',
    `project_risk_value` bigint(8) NOT NULL COMMENT '项目风险值',
    `project_create_time` timestamp NOT NULL COMMENT '项目创建时间',
    `check_group_id` bigint(8) NOT NULL COMMENT '检查小组id',
    PRIMARY KEY (`project_id`),
    FOREIGN KEY (`check_group_id`) REFERENCES `group_info` (`group_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

#委托方合同信息表
CREATE TABLE `client_contract_info` (
    `contract_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '合同id',
    `client_id` bigint(8) NOT NULL COMMENT '委托方id',
    `project_id` bigint(8) NOT NULL COMMENT '项目id',
    `check_system_id` bigint(8) NOT NULL COMMENT '检查体系第一级id，即委托方意向',
    `contract_create_time` timestamp NOT NULL COMMENT '合同创建时间',
    PRIMARY KEY (`contract_id`),
    FOREIGN KEY (`client_id`) REFERENCES `client_info` (`client_id`),
    FOREIGN KEY (`project_id`) REFERENCES `project_info` (`project_id`),
    FOREIGN KEY (`check_system_id`) REFERENCES `check_system` (`cur_node_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 检查记录表
CREATE TABLE `check_info` (
    `check_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '检查记录id',
    `project_id` bigint(8) NOT NULL COMMENT '项目id',
    `staff_id` bigint(8) NOT NULL COMMENT '检查人员id',
    `check_system_first_level` bigint(8) NOT NULL COMMENT '检查体系第一级id',
    `check_system_second_level` bigint(8) NOT NULL COMMENT '检查体系第二级id',
    `check_picture_url` varchar(200) COMMENT '检查现场图片url',
    `check_description` varchar(200) COMMENT '问题描述',
    `check_time` timestamp NOT NULL COMMENT '检查时间',
    `check_state` bigint(2) NOT NULL COMMENT '检查记录状态',
    PRIMARY KEY (`check_id`),
    FOREIGN KEY (`project_id`) REFERENCES `project_info` (`project_id`),
    FOREIGN KEY (`staff_id`) REFERENCES `staff_info` (`staff_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 检查体系表
CREATE TABLE `check_system` (
    `cur_node_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '当前结点id',
    `per_node_id` bigint(8) NOT NULL COMMENT '前置结点id',
    `node_description` varchar(16) NOT NULL COMMENT '当前节点描述',
    PRIMARY KEY (`cur_node_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 检查员工信息表
CREATE TABLE `staff_info` (
    `staff_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '员工id',
    `staff_name` varchar(8) NOT NULL COMMENT '员工姓名',
    `staff_gender` varchar(2) NOT NULL COMMENT '员工性别',
    `staff_phone` varchar(16) NOT NULL COMMENT '员工电话',
    PRIMARY KEY (`staff_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 小组信息表
CREATE TABLE `group_info` (
    `group_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '小组id',
    `group_name` varchar(16) NOT NULL COMMENT '小组名称',
    `group_leader_id` bigint(8) NOT NULL COMMENT '组长id',
    PRIMARY KEY (`group_id`),
    FOREIGN KEY (group_leader_id) REFERENCES `staff_info` (`staff_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 租户表
CREATE TABLE `tenant_info` (
    `tenant_id` bigint(8) NOT NULL AUTO_INCREMENT COMMENT '租户id',
    `tenant_name` varchar(16) NOT NULL COMMENT '租户名称',
    PRIMARY KEY (`tenant_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;

# 登录表
CREATE TABLE `login_info` (
    `user_id` bigint(8) NOT NULL COMMENT '用户id',
    `user_password` varchar(16) NOT NULL COMMENT '用户密码',
    `user_type` bigint(2) NOT NULL COMMENT '用户类型'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_bin;


