import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 服务端接口，继承Remote
 */
public interface DBservice extends Remote {
    public void create(String table,String column,String type) throws RemoteException;
    public void insert(String name,int score) throws RemoteException;
    public void query(String table) throws RemoteException;
}
