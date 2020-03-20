package com.nuwf.servicecenter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerImpl implements server {
    //方法注册
    private static HashMap<String,Class> server = new HashMap();
    //服务线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(30);
    //服务开启布尔值
    private static boolean isRunning = false;
    @Override
    public void start() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ServerSocket serverSocket = new ServerSocket(7979);

        isRunning = true;
        while (true){
            System.out.println("start server......");
            Socket socket = serverSocket.accept();
            executorService.execute(new ServiceTaskRunnable(socket));
        }

    }

    @Override
    public void stop() {
        isRunning = false;
        executorService.shutdown();
    }

    @Override
    public void register(Class name,Class Impl) {
        server.put(name.getName(),Impl);

    }
    //线程内部类
    class ServiceTaskRunnable  implements Runnable{
        Socket socket = null;

        public ServiceTaskRunnable(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ObjectOutputStream objectOutputStream = null;
            ObjectInputStream objectInputStream = null;

            try {
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                String name;
                name = objectInputStream.readUTF();

                String methodName = objectInputStream.readUTF();
                Class[] parameterTypes = (Class[])objectInputStream.readObject();
                Object[] args = (Object[])objectInputStream.readObject();

                //
                Class aClass =server.get(name);
                Method method1 = aClass.getMethod(methodName,parameterTypes);
                Object result = method1.invoke(aClass.newInstance(),args);

                //
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(result);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                if (objectOutputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }
}
