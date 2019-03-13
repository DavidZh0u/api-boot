
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://github.com/weibocom/motan/blob/master/LICENSE) ![](https://img.shields.io/badge/JDK-1.8+-green.svg) ![](https://img.shields.io/badge/SpringBoot-1.4+_1.5+_2.0+-green.svg)

`ApiBoot`是一款基础的接口服务框架的整合，开箱即用，对于接口服务的开发者而言可以很大的提高开发效率，之前在`SpringBoot`系列文章内也有很多同学让我出一个整合的示例，这个也可以当做结合我编写的文章的示例来看，每个版本的迭代都会把之前文章的内容加入进去，当然也会有很多的扩展，让使用者运用自如。



### 最新版本

当前版本集成如下所示：

- SpringSecurity
- Oauth2
- Jwt
- 统一返回格式
- Swagger2 文档生成
- Mybatis-Enhance
- Code-Builder
- Profile
- Lombok
- FastJson

详细的版本功能介绍访问[最新Wiki]()

### 版本规划

下一个版本的迭代主要是集成第三方依赖如下所示：

- 七牛云上传/下载
- 阿里云OSS上传/下载
- 阿里云短信服务
- 内置事件发布（Spring Event）

### 目录概述

```
. framework
├── converter
├── enums
├── event
├── model
├── security
│   ├── delegate
│   ├── jdbc
│   ├── properties
│   └── userdetails
└── tools
```

`ApiBoot`集成框架相关的代码实现都在`com.github.hengboy.api.boot.framework`目录下，如果你需要编写自己的业务尽可能的在`framework`的同级目录创建`package`来进行编写，`ApiBoot`默认扫描`com.github.hengboy.api.boot`目录下的所有类。

### 开源许可

`ApiBoot`采用`Apache2`开源许可。
