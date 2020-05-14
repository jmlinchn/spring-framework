# 如何配置源码

1. 下载Spring源码（`git clone https://github.com/spring-projects/spring-framework.git`），切换到分支 5.1.x（`checkout 5.1.x`），再从中切换出自己的源码阅读分支（`checkout -b debug-5.1.x`）
    > 最好是 fork 到自己的仓库后再拉取下来，方便添加自定义代码注释后提交到自己的github上
2. 修改项目默认Gradle配置 `gradle/wrapper/gradle-wrapper.properties`
    ```properties
    distributionBase=GRADLE_USER_HOME
    distributionPath=wrapper/dists
    distributionUrl=https://services.gradle.org/distributions/gradle-5.6.4-bin.zip # 主要是修改这行gradle版本
    zipStoreBase=GRADLE_USER_HOME
    zipStorePath=wrapper/dists
    ```
3. 修改 IDEA 的 `File-Setting-Gradle user home` 配置，添加环境变量 `GRADLE_USER_HOME`，作为 gradle 依赖包默认存储地址。
4. 创建一个模块 `debug-spring`，在模块目录下添加一个 `debug-spring.gradle` 文件，其中引入 `spring-context` 依赖。
    ```
    description = "DebugSpring"
    dependencies {
    	compile(project(":spring-context"))
    }
    ```
5. 在根目录的 `settings.gradle` 的include中添加一个依赖
    ```
    include "debug-spring"
    ```
6. 打上断点，运行项目的启动类 `/spring-framework/debug-spring/src/main/java/cn/linjianming/spring5/SpringDebugApp.java`。

调试源码，由此开始！

# 其他问题

- Q1：下载 Gradle 依赖网速慢怎么办？

修改根目录下的 `build.gradle` 中的**两处**依赖配置为阿里镜像。
```
buildscript {
    ...
	repositories {
		maven { url "https://repo.spring.io/plugins-release" } // 第一处
	}
    ...
}
...
configure(allprojects) { project ->
    ...
    repositories {
		maven { url "https://repo.spring.io/libs-release" } // 第二处
		mavenLocal()
	}
    ...
}
```
修改链接为 
`https://maven.aliyun.com/repository/public`

- Q2：模块出现中文乱码怎么办？

在 IDEA 的 `Help-Edit Custom VM Options`，在文件最后添加参数 `-Dfile.encoding=UTF-8`，重启 IDEA。

- Q3：Spring中的所有类都报红，但是能正常启动 `SpringDebugApp.java`，怎么解决？

作者碰到过这个问题，这个是在引入项目时，IDEA的索引没有完全建立。这时候需要点击 `File-Invalid Cache/Restart`，选择`Invalid and Restart`清除缓存，重新进入项目后编译即可。


# <img src="src/docs/asciidoc/images/spring-framework.png" width="80" height="80"> Spring Framework

This is the home of the Spring Framework: the foundation for all [Spring projects](https://spring.io/projects). Collectively the Spring Framework and the family of Spring projects is often referred to simply as "Spring". 

Spring provides everything required beyond the Java programming language for creating enterprise applications for a wide range of scenarios and architectures. Please read the [Overview](https://docs.spring.io/spring/docs/current/spring-framework-reference/overview.html#spring-introduction) section as reference for a more complete introduction.

## Code of Conduct

This project is governed by the [Spring Code of Conduct](CODE_OF_CONDUCT.adoc). By participating, you are expected to uphold this code of conduct. Please report unacceptable behavior to spring-code-of-conduct@pivotal.io.

## Access to Binaries

For access to artifacts or a distribution zip, see the [Spring Framework Artifacts](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Artifacts) wiki page.

## Documentation

The Spring Framework maintains reference documentation ([published](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/) and [source](src/docs/asciidoc)), Github [wiki pages](https://github.com/spring-projects/spring-framework/wiki), and an
[API reference](https://docs.spring.io/spring-framework/docs/current/javadoc-api/). There are also [guides and tutorials](https://spring.io/guides) across Spring projects.

## Build from Source

See the [Build from Source](https://github.com/spring-projects/spring-framework/wiki/Build-from-Source) Wikipedia page and the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## Stay in Touch

Follow [@SpringCentral](https://twitter.com/springcentral), [@SpringFramework](https://twitter.com/springframework), and its [team members](https://twitter.com/springframework/lists/team/members) on Twitter. In-depth articles can be found at [The Spring Blog](https://spring.io/blog/), and releases are announced via our [news feed](https://spring.io/blog/category/news).

## License

The Spring Framework is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
