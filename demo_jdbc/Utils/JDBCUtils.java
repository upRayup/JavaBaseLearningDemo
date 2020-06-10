package demo_jdbc.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static{
        //创建Properties对象
        Properties pro=new Properties();
        //用类加载器获取jdbc.properties文件的输入流
        ClassLoader cl = JDBCUtils.class.getClassLoader();
        InputStream is = cl.getResourceAsStream("jdbc.properties");
        //获得文件内容
        try {
            pro.load(is);
            driver=pro.getProperty("driver");
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //连接资源
    public static Connection getConnection(){
        Connection conn=null;
        try {
             conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    //释放资源，这里有可能没有游标，所以写两种情况的重载
    public static void close(Connection conn, Statement st){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement st,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
