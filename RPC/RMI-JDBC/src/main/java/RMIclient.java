import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * 客户端调用远程服务
 */
public class RMIclient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DBservice dBservice = (DBservice) Naming.lookup("//127.0.0.1:9999/dBservice");
            System.out.println("RMI远程数据库调用");
            while (true){
                System.out.println("1,create    "+"2,insert    "+"3,query   "+"4,exit");
                System.out.println("请输入您的操作选择：");
                switch (scanner.nextInt()){
                    case 1:
                        System.out.println("请输入tableName,clumnName,typename：");
                        String table = scanner.next();
                        String clumn = scanner.next();
                        String type = scanner.next();
                        dBservice.create(table,clumn,type);
                        break;
                    case 2:
                        System.out.println("请输入name和score:");
                        String name = scanner.next();
                        int score = scanner.nextInt();
                        dBservice.insert(name,score);
                        break;
                    case 3:
                        System.out.println("请输入tableName：");
                        String tablename = scanner.next();
                        dBservice.query(tablename);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("不能识别选项请重新输入：");
                }
            }

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
