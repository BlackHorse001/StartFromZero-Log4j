#Common logging
##简介
common-logging是apache提供的通用log接口，目的在于统一log入口，开发时只需要面向common-logging编程，而不需要考虑具体实现。通过动态查找的方式，在运行时确定如log4j，jdk logging等具体实现。此外，common-logging也有自己的实现SimpleLog，只不过功能简单，不建议使用  

##内部机理
一般通过LogFacotry创建或获取log对象：  
```java
private static Log log = LogFactory.getLog(TestCommonLog.class);
```
通过阅读源码可以发现，确定具体的log实现需经过以下步骤：  
- 读取commons-logging.properties属性文件中org.apache.commons.logging.Log的配置，存在即实例化
- 在System property中查找org.apache.commons.logging.Log，存在即实例化
- 在class path中查找是否存在Log4j依赖，如果有，则使用对应的包装类org.apache.commons.logging.impl.Log4JLogger
- 同上，使用org.apache.commons.logging.impl.Jdk14Logger
- 如果都没有找到，则使用自带的默认实现org.apache.commons.logging.impl.SimpleLog