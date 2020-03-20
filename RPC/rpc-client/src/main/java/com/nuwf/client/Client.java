package com.nuwf.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Client {
    public static <T> T getRemoteProxyObj(final Class name, String ip, int port){
        return (T) Proxy.newProxyInstance(name.getClassLoader(), new Class<?>[]{name}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = new Socket("127.0.0.1",7979);
                        ObjectInputStream objectInputStream = null;
                        ObjectOutputStream objectOutputStream = null;

                        try {
                            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            objectOutputStream.writeUTF(name.getName());
                            objectOutputStream.writeUTF(method.getName());
                            objectOutputStream.writeObject(method.getParameterTypes());
                            objectOutputStream.writeObject(args);

                            //
                            objectInputStream = new ObjectInputStream(socket.getInputStream());
                            return objectInputStream.readObject();
                        }catch (Exception e){
                            e.printStackTrace();
                            return null;
                        }finally {
                            if (objectOutputStream != null)
                                objectOutputStream.close();
                            if (objectInputStream != null)
                                objectInputStream.close();
                        }
                    }
                });
    }
}
