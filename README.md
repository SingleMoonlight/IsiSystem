# 智慧工地检查系统

## 概述

智慧工地检查系统是利用信息化手段，使用Web通信技术，取代传统人工操作，构建施工项目信息化生态圈，并将此数据在服务端进行智能分析评判。实现工程施工可视化智能管理，以提高工程管理信息化水平，从而逐步实现绿色建造和生态建造。

此系统旨在接受委托方项目委托，进行工地项目派工检查，通过Android端采集数据，Web端进行管理，进行数据数字化采集和分析。

## 技术栈

+ SpringBoot
+ ...

## 系统功能

### 项目管理

### 人员管理

### 合同管理

### 检查管理


#  附录
##  交互数据定义

后端返回值为Json类型数据，包含三个字段code、content、payload。

**code**：自定义响应状态码

| 状态码 | 描述         |
| ------ | ------------ |
| 1      | 操作成功     |
| -1     | 操作失败     |
| -2     | 操作无法进行 |

**content**：响应信息

**payload**：负载

当前端需要返回某些类型数据时，如登录用户信息，使用payload封装。

##  接口清单

### 登录相关

| 描述     | 路径          | 参数                           | 请求类型 | 备注 |
| -------- | ------------- | ------------------------------ | -------- | ---- |
| 租户登录 | /login/tenant | id：租户id<br />password：密码 | POST     |      |
| 员工登录 | /login/staff  | id：员工id<br />password：密码 | POST     |      |

### 租户相关

| 描述         | 路径                   | 参数                             | 请求类型 | 备注 |
| ------------ | ---------------------- | -------------------------------- | -------- | ---- |
| 获取租户密码 | /tenant/getPassword    | id：租户id                       | GET      |      |
| 修改租户密码 | /tenant/changePassword | id：租户id<br />password：新密码 | POST     |      |

###  项目相关

####  项目管理

| 描述                           | 路径                        | 参数                                                         | 请求类型 | 备注 |
| ------------------------------ | --------------------------- | ------------------------------------------------------------ | -------- | ---- |
| 新建项目                       | /project/create             | name：项目名<br />description：项目描述<br />owner：项目负责人<br />ownerPhone：负责人电话<br />checkGroupId：检查小组id | POST     |      |
| 获取项目信息                   | /project/getById            | id：项目id                                                   | GET      |      |
| 修改项目                       | /project/edit               | id：项目id<br />name：项目名<br />description：项目描述<br />owner：项目负责人<br />ownerPhone：负责人电话<br />checkGroupId：检查小组id | POST     |      |
| 删除项目                       | /project/remove             | id：项目id                                                   |          |      |
| 获取所有项目信息               | /project/getAll             |                                                              | GET      |      |
| 获取指定小组指定状态的项目信息 | /project/getByGroupAndState | groupId：小组id<br />state：项目状态                         | POST     |      |
| 获取指定状态的项目             | /project/getByState         | state：项目状态                                              | GET      |      |
| 获取项目的检查体系             | /project/getCheckSystem     | id：项目id                                                   | GET      |      |
| 设置项目状态                   | /project/editState          | id：项目id<br />state：项目状态                              | POST     |      |
| 设置项目风险值                 | /project/editRiskValue      | id：项目id<br />riskValue：项目风险值                        | POST     |      |

####  委托方管理

| 描述           | 路径           | 参数                                          | 请求类型 | 备注 |
| -------------- | -------------- | --------------------------------------------- | -------- | ---- |
| 获取所有委托方 | /client/getAll |                                               | GET      |      |
| 新建委托方     | /client/create | name：委托方名称<br />description：委托方描述 | POST     |      |

####  合同管理

| 描述     | 路径             | 参数                                                         | 请求类型 | 备注                                                      |
| -------- | ---------------- | ------------------------------------------------------------ | -------- | --------------------------------------------------------- |
| 创建合同 | /contract/create | clientId：委托方id<br />projectId：项目id<br />checkSystemId：检查体系id | POST     | 由于检查体系可以选择多个，多个体系id之间用英文逗号`,`连接 |

###  员工相关

#### 员工管理

| 描述         | 路径                  | 参数                                                         | 请求类型 | 备注 |
| ------------ | --------------------- | ------------------------------------------------------------ | -------- | ---- |
| 录入员工     | /staff/add            | name：姓名<br />gender：性别<br />phone：电话<br />password：初始密码 | POST     |      |
| 批量录入     | /staff/batchAdd       | staffForm：员工信息excel表格<br />password：初始密码         | POST     |      |
| 获取员工信息 | /staff/getById        | id：员工id                                                   | GET      |      |
| 编辑员工信息 | /staff/edit           | id：员工id<br />name：姓名<br />gender：性别<br />phone：电话<br /> | POST     |      |
| 删除员工     | /staff/remove         | id：员工id                                                   | POST     |      |
| 修改密码     | /staff/changePassword | id：员工id<br />password：新密码                             | POST     |      |
| 查询密码     | /staff/getPassword |     id：员工id                                                    |   GET       |      |
| 查询指定小组的员工 | /staff/getByGroup | groupId：小组id | GET |      |
| 查询所有员工 | /staff/getAll | | GET | |


####  小组管理

| 描述         | 路径              | 参数                                                         | 请求类型 | 备注                                                |
| ------------ | ----------------- | ------------------------------------------------------------ | -------- | --------------------------------------------------- |
| 创建小组     | /group/create     | name：小组名字<br />leaderId：小组组长id<br />staffs：小组员工id集合 | POST     | 创建小组时员工可选择多个，员工id间用英文逗号`,`隔开 |
| 获取所有小组 | /group/getAll     |                                                              | GET      |                                                     |
| 修改小组名字 | /group/editName   | id：小组id<br />name：新名字                                 | POST     |                                                     |
| 修改小组组长 | /group/editLeader | id：小组id<br />leaderId：新组长id                           | POST     |                                                     |
| 删除小组     | /group/remove     | id：小组id                                                   | POST     |                                                     |

###  检查相关

#### 检查体系

| 描述                           | 路径                     | 参数                                                         | 请求类型 | 备注 |
| ------------------------------ | ------------------------ | ------------------------------------------------------------ | -------- | ---- |
| 获取指定结点的后继检查体系节点 | /checkSystem/getSubNodes | nodeId：检查体系节点                                         | GET      |      |
| 获取指定检查结点的信息         | /checkSystem/getNodeInfo | nodeId：检查体系节点                                         | GET      |      |
| 新增检查体系                   | /checkSystem/createNode  | preNodeId：前置节点id<br />description：节点说明<br />weight：权重 | POST     |      |
| 删除节点                       | /checkSystem/removeNode  | nodeId：检查体系节点                                         | POST     |      |
| 更新节点信息                   | /checkSystem/editNode    | curNodeId：节点id<br />description：节点说明<br />weight：权重 | POST     |      |

#### 检查记录

| 描述                           | 路径                            | 参数                                                         | 请求类型 | 备注                     |
| ------------------------------ | ------------------------------- | ------------------------------------------------------------ | -------- | ------------------------ |
| 提交检查记录                   | /checkRecord/add                | staffId：员工id<br />projectId：项目id<br />firstLevel：第一级检查id<br />secondLevel：第二级检查id<br />riskLevel：风险分数<br />picUrl：现场检查图片url<br />description：问题描述 | POST     | 风险分数0~100            |
| 获取某员工对某个项目的检查状态 | /checkRecord/getStaffCheckState | staffId：员工id<br />projectId：项目id                       | POST     | 0：未检查<br />1：已检查 |
| 获取某个项目的检查记录         | /checkRecord/getByProject       | projectId：项目id                                            | POST     |                          |
| 设置检查记录状态               | /checkRecord/editState          | checkRecordId：检查记录id<br />state：检查记录状态           |          |                          |

#### 检查统计

| 描述               | 路径                          | 参数                                                         | 请求类型 | 备注 |
| ------------------ | ----------------------------- | ------------------------------------------------------------ | -------- | ---- |
| 获取项目的检查结果 | /checkAnalysis/getCheckResult | projectId：项目id                                            | GET      |      |
| 添加项目检查结果   | /checkAnalysis/addCheckResult | projectId：项目id<br />firstId：第一级检查体系id<br />secondId：第二级检查体系id<br />riskLevel：风险值 | POST     |      |