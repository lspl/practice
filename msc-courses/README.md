## 项目介绍
简单应用springcloud中的eureka组件进行服务发现和注册
> from: [开课吧-JAVA架构师之微服务和分布式](https://learn.kaikeba.com/catalog/211176?type=1)
- 00-eurekaserver-8000: eureka服务
- 01-consumer-8080: springboot的consumer
- 01-provider-8081: sprintboot的provider
- 02-consumer-8080: springcloud的consumer
- 02-provider-8081: springcloud的provider

## 项目启动
1. 00-eurekaserver-8000
2. 02-provider-8081
3. 02-consumer-8080

## 测试url:
1. 查看eureka效果：http://localhost:8000/
2. 查看数据库中的元素：http://localhost:8080/consumer/depart/list
其他支持的方法都在msc-courses/02-consumer-8080/src/main/java/com/abc/controller/SomeController.java中
3. 查看服务注册的方法(代码中也有日志)：http://localhost:8081/provider/depart/discovery

## 关注点
1. springboot项目控制日志级别：msc-courses/02-provider-8081/src/main/resources/application.yml
2. rest中post和put区别：https://blog.csdn.net/maxmao1024/article/details/79591726
3. 使用eureka时，consumer的RestTemplate要配置`LoadBalanced`，见msc-courses/02-consumer-8080/src/main/java/com/abc/configure/DepartCodeConfig.java