import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * DBservice的实现类
 * 要继承UnicastRemoteObject
 */
public class DBserviceImpl extends UnicastRemoteObject implements DBservice {

    public DBserviceImpl() throws RemoteException {
        super();
    }

    public void create(String table,String column,String type) throws RemoteException{
        DBmanager.create(table,column,type);
    }

    public void insert(String name, int score) throws RemoteException{
        DBmanager.insert(name,score);
    }

    public void query(String table) throws RemoteException{
        DBmanager.query(table);
    }
}
