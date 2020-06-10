package demo_jdbc;

import demo_jdbc.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc_demoshiwu {
    public static void main(String[] args) {
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        Connection conn= null;
        try {
            conn= JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql="UPDATE account SET balance=balance - ? WHERE id=?";
            String sql2="UPDATE account SET balance=balance + ? WHERE id=?";
            pst1 = conn.prepareStatement(sql);
            pst2 = conn.prepareStatement(sql2);
            pst1.setDouble(1,500);
            pst1.setInt(2,1);
            pst2.setDouble(1,500);
            pst2.setInt(2,2);
            pst1.executeUpdate();
            //手动制造异常
            int i=1/0;
            pst2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst1);
            JDBCUtils.close(null,pst2);
        }

    }
}
