package nwafu.corba;

import java.sql.*;

public class DBmanager {
    private static Connection conn;
    private static Statement sta;
    private static ResultSet result;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static float score;
 
    public static Connection getcon() {
        Connection con = null;
        try {
            Class.forName(driver);// 注册驱动
        } catch (ClassNotFoundException e) {
            System.out.println("未完成注册驱动");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, "root", "123456");// 建立连接
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("未完成数据连接");
            e.printStackTrace();
        }
        return con;
    }
 
    public static void insert(String stuName, String StuNo, float score) {
        try {
            conn = getcon();
            String sql = "insert into cobra(stuName,stuNo,score) values(?,?,?)";
            
            conn.prepareStatement(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, stuName);
			ps.setString(2, StuNo);
			ps.setFloat(3,score);
			
			ps.executeUpdate();	
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public static float search(String StuNo) {
        try {
            conn = getcon();
            String sql = "select * from cobra where StuNo=" + StuNo;
            sta = conn.createStatement();
            result = sta.executeQuery(sql);
            if (result.next()) {
                String stuName = result.getString(1);
                String stuNo = result.getString(2);
                score = result.getFloat(3);
            }
            sta.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return score;
    }
}