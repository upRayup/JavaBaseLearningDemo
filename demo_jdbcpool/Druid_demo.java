package demo_jdbcpool;


import demo_jdbcpool.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Druid_demo {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pst=null;
        ResultSet rs =null;
        try {
            //新建数据库连接池对象
            conn = JDBCUtils.getconnection();
            //定义sql语句
            String sql="INSERT INTO account VALUES(null,?,?)";
            //创建sql执行对象
            pst = conn.prepareStatement(sql);
            pst.setString(1,"wangwu");
            pst.setDouble(2,3000);
            int re = pst.executeUpdate();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pst,conn);
        }

    }
}
