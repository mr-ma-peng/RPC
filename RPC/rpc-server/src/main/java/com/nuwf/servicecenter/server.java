package com.nuwf.servicecenter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

//服务中心
public interface server {
    //开启服务
    public void start() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException;
    //关闭服务
    public void stop();
    //注册服务
    public void register(Class name,Class Impl);
}
