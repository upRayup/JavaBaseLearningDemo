package demo_jdbc;

import demo_jdbc.Utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class jdbc_demologin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        boolean login = new jdbc_demologin().login(username, password);
        if(login){
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }
    public boolean login(String username,String password){
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs =null;
        if(username==null && password==null){
            return false;
        }
        try {
            //获得数据库的连接
            conn= JDBCUtils.getConnection();
            //定义sql语句
            String sql="SELECT * FROM USER WHERE username=? AND PASSWORD=?";
            //创建sql执行对象
            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pst,rs);
        }
        return false;
    }
}
