
- 关于 jar 包依赖问题，请在自己的 maven 配置文件中添加以下配置。

```xml
 <profile>
    <id>maven-nexus</id>
    <repositories>
        <repository>
            <id>maven-nexus</id>
            <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
</profile>
```



Welcome to the auth-service wiki!
## 异常码说明

> 此处参见 framework 异常码说明

[ 异常错误码规范 ](https://github.com/hiColors/framework/wiki/%E5%BC%82%E5%B8%B8%E7%A0%81%E8%A7%84%E5%88%99%E8%AF%B4%E6%98%8E)


### auth-server 异常错误码 详细信息

#### 应用码 [002]

##### 模块码

- 公共 [002000]

    异常错误码 | 说明
    |- | :- |
    002000000 | 未知。
  
    
- 验证码 [002001]

    异常错误码 | 说明
    |- | :- |
    002001000 | 验证码处理器[{0}]不存在。
    002001001 | 验证码生成器{0}不存在。
    002001002 | request 请求中获取验证码参数失败。
    002001003 | {0} :验证码的值不能为空。
    002001004 | {0} :验证码不存在。
    002001005 | {0} :验证码已过期。
    002001006 | {0} :验证码不匹配。
    002001007 | type[{0}]：生成验证码 key 时出错，key 为 null。
    002001008 | 请在 %d 秒后尝试获取验证码！