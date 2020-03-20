package com.nuwf;

import com.nuwf.client.Client;
import com.nuwf.serviceimpl.ComPutingServices;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {
        ComPutingServices comPutingServices = Client.getRemoteProxyObj(Class.forName("com.nuwf.serviceimpl.ComPutingServices"),
                "127.0.0.1",7979);
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----RPC远程过程调用-----");
        System.out.println("1,add(double a,doubleb b)   "+
                "2,subtract(double a,double b)    " +
                "3,log(String str)  " +
                "......     " +
                "9,exit");

        while (true){
            System.out.println("请输入您需要的服务：");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("请输入两个参数：");
                    System.out.println("result = "+ comPutingServices.add(scanner.nextDouble(),scanner.nextDouble()));
                    break;
                case  2:
                    System.out.println("请输入两个参数：");
                    System.out.println("result = "+ comPutingServices.subtract(scanner.nextDouble(),scanner.nextDouble()));
                    break;
                case 3:
                    System.out.println("请输入所要打印的语句");
                    System.out.println(comPutingServices.log(scanner.next()));
                    break;
                case 9:
                    return;
                default:
                    System.out.println("未开放");
            }

        }
    }
}
