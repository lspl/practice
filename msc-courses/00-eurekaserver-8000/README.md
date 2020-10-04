## 项目介绍
简单应用springcloud中的eureka组件进行服务发现和注册
- 00-uerekaserver-8000: eureka服务
- 01-consumer-8080: springboot的consumer
- 01-provider-8081: sprintboot的provider
- 02-consumer-8080: springcloud的consumer
- 02-provider-8081: springcloud的provider

## 项目启动
1. 00-uerekaserver-8000
2. 02-provider-8081
3. 02-consumer-8080

## 测试url:
1. 查看eureka效果：http://localhost:8000/
2. 查看数据库中的元素：http://localhost:8080/consumer/depart/list
其他支持的方法都在msc-courses/02-consumer-8080/src/main/java/com/abc/controller/SomeController.java中
3. 查看服务注册的方法(代码中也有日志)：http://localhost:8081/provider/depart/discovery