import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 注册中心
 */
public class DeployServer {
    public DeployServer() {
    }

    public static void main(String[] args) {
        try {
            //创建远程对象
            DBservice dBservice = new DBserviceImpl();
            //启动注册服务
            LocateRegistry.createRegistry(9999);

            //远程对象绑定服务
            Naming.rebind("//localhost:9999/dBservice",dBservice);

            System.out.println("RMI服务器正常运行......");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
