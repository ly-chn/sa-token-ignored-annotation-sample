## sa-token 如何根据不同的注解适应不同鉴权操作场景

[来源sa-token issue230](https://github.com/dromara/Sa-Token/issues/230)

#### 第一步, 选择适合自己的集成方式
> 示例中为[官方文档](https://sa-token.dev33.cn/doc/index.html#/start/example)快速入门集成方式

#### 第二步, 不想写这么详细了, 自己看看吧, 一共没多少代码

主要逻辑就在`kim.nzxy.satokenignoredannotationsample.configuration.SaTokenConfiguration`这个类中判断了一下注解

主要用法在`kim.nzxy.satokenignoredannotationsample.controller.UserController`中

注: 接口500是因为没做异常拦截