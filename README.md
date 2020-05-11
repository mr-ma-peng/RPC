# 1，RPC-java实现

rpc-server：服务端模块
com.nuwf.servicecenter包下为服务中心模块，负责服务的注册，开启和关闭
通过一个hashmap存储已注册的服务，接收客户端发来的请求，通过反射技术执行对应的方法
为提高并发性，使用线程池，为每一个socket连接，创立单独的线程
com.nuwf.seviceimpl包下为服务模块，计算服务的实现

rpc-client：客户端模块
com.nuwf.client包下为客户端模块
使用java自带的 proxy类，实现请求的动态代理

注：各自运行 src/main/java/com/nuwf/App.java



# 2，RMI+JDBC


DBmanager.java：jdbc-mysql数据库dao层
DBservice.java：服务接口
DBserviceImpl.java：服务层
DeployServer.java：RMI注册中心
RMIclient.java：远程调用客户端

# cobra 

应用软件：omniORB4.1.0
mysql 5.7.20

java和c++编程模拟客户端与服务端远程对象调用

