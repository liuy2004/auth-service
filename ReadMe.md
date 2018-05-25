关于 jar 包依赖问题，请在自己的 maven 配置文件中添加以下配置。

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