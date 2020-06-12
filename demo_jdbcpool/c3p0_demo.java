package demo_jdbcpool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class c3p0_demo {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pst=null;
        ResultSet rs =null;
        try {
            //新建数据库连接池对象
            DataSource ds=new ComboPooledDataSource();
            conn = ds.getConnection();
            //定义sql语句
            String sql="SELECT * FROM account";
            //创建sql执行对象
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("NAME");
                double balance = rs.getDouble("balance");
                System.out.println("id:"+id+"name:"+name+"balance"+balance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(pst!=null){
                try {
                    pst.close();
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
}
