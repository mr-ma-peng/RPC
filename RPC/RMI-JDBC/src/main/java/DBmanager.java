import java.sql.*;

/**
 * 数据库连接
 * 实现创建表，录入成绩，查询成绩等操作
 */
public class DBmanager {
    private final static String userName = "root";
    private final static String passWord = "123456";
    private final static String dbUrl = "jdbc:mysql://localhost:3306/user";
    private final static String driverName = "com.mysql.jdbc.Driver";

    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    public static Connection setConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbUrl,userName,passWord);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到数据库驱动程序");
            return null;
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
            return null;
        }
    }
    public static void create(String table,String column,String type){
        String sqlStatement = "create table "+table+"("+column+"    "+type+")";
        try {
            connection = setConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
            statement.close();
            connection.close();
            System.out.println(sqlStatement+"   已执行成功");
        } catch (SQLException e) {
            System.out.println("表创建失败");
        }
    }
    public static void insert(String name,int score){
        String sqlStatement = "insert into student values('"+name+"','"+score+"')";

        try {
            connection = setConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
            statement.close();
            connection.close();
            System.out.println("已成功插入一条新数据");
        } catch (SQLException e) {
            System.out.println("数据插入失败");
        }
    }
    public static void query(String table){
        String sqlStatement = "select * from "+table;
        try {
            connection = setConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()){
                System.out.println(resultSet.getString("name")+":"+resultSet.getInt("score"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("查询失败");
        }
    }

}
