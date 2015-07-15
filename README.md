
#Log4j 1.x  #

##Log4j的三大组件：  ##
	1. Loggers 日志写出器
	2. Appenders 日志目的地
	3. Layouts 日志格式化

## 1 Loggers ##
### 1.1 Loggers级别设置 ###
	在org.apache.log4j.Level中定义了以下级别
		1. TRACE
		2. DEBUG
		3. INFO
		4. WARN
		5. ERROR
		6. FATAL
	我们可以通过继承org.apache.log4j.Level这个类来自定义级别(不推荐)
	
### 1.2 Loggers 继承关系 ###
	如果一个Logger没有明确指定级别，它的级别将从最近的指定级别的祖先类继承。
	为了保证每个类都能继承到级别，作为最顶层logger，root logger通常需要明确的指定级别。
### 1.3 Loggers 级别关系 ###
	FATAL>ERROR>WARN>INFO>DEBUG
	Log4j通过调用debug，info，warn，error，fatal，log等方法生成log信息。不同的打印方法对应不同的级别。例如：logger.info("xxx")对应INFO级别。	
	基本原则：
	当打印级别 >= logger的级别时，log信息才会被打印
	例如：logger 级别: INFO
		   打印方法级别：DEBUG 不打印（DEBUG < INFO）
		   打印方法级别：INFO 打印（INFO >= INFO）
		   打印方法级别：ERROR 打印（ERROR > INFO）

### 1.4 Loggers的名称 ###
	Loggers的名称具有全局唯一性，通过getLogger方法获取相同名称的logger实例，得到的将是同一个logger的引用。
	通过类的权限定名称来命名logger是个比较好的命名策略。

## 2 Appenders #
	Log4j支持将log打印到不同的目的地中，包括：Console，File，GUI组件，远程socket服务器，JMS, NT Event Loggers等，并且支持异步打印日志。
	一个Logger身上可以绑定多个Appender。并且Appender也会跟随Logger的继承关系叠加下去。可以通过设置logger的additivity属性，改变appender的叠加性。
	一个logger会将日志信息打印到其自身及其祖先所绑定的所有appender去。如果其祖先中某个logger设置了additivity：false，与该logger祖先相关的appender将不会被考虑在内。

## 3 Layouts ##
	Layouts用于格式化输出。

## 4 参数配置 ##
	Log4j通过参数文件来配置Logger，Appender，Layout的基本信息。主要有xml和properties两种文件格式。
### 4.1 配置文件的基本组成元素 ###
#### 4.1.1 Logger的配置 ####
	- level：fatal，error，warn，info，debug
	- AppenderName1，AppenderName2...  
	例如：log4j.rootLogger=[level],AppenderName1,AppenderName2...
#### 4.1.2 Appender的配置 ####
	- name
	- class：Appender的全限定类名，Log4j提供的Appender有以下几种：
		-  org.apache.log4j.ConsoleAppender 输出到控制台
		-  org.apache.log4j.FileAppender 输出到文件中
		-  org.apache.log4j.DailyRollingFileAppender 每天产生一个日志文件
		-  org.apache.log4j.RollingFileAppender 文件大小达到指定大小生成新文件
		-  org.apache.log4j.WriterAppender 以流的形式输出到任何地方
	- param：param1，param2...
	- layout：见下面layout配置
#### 4.1.3 Layout的配置 ####
	- class：Layout的全限定类名，Log4j提供的Layout有以下几种：
		- org.apache.log4j.HTMLLayout 以HTML表格形式布局
		- org.apache.log4j.PatternLayout 根据Pattern灵活地指定布局模式
		- org.apache.log4j.SimpleLayout 包含日志信息的级别和信息字符串
		- org.apache.log4j.TTCCLayout 包含日志产生的时间、线程、类别等等信息

