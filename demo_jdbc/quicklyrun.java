package demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class quicklyrun {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象，第一个为数据库名称，第二个为用户名，第三个为用户密码
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
        //设置sql语句
        String sql="UPDATE account SET balance=10 WHERE id=1";
        //获取sql的执行对象
        Statement st = conn.createStatement();
        //执行sql语句
        int result = st.executeUpdate(sql);
        //查看sql语句的影响行数
        System.out.println(result);
        //释放资源
        st.close();
        conn.close();
    }
}
