package demo_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc_demo1 {
    public static void main(String[] args) {
        List<emp> list=new jdbc_demo1().findall();
        for (emp em : list) {
            System.out.println(em);
        }
    }

    public List<emp> findall(){
        Connection conn =null;
        Statement st=null;
        ResultSet rs =null;
        List<emp> list=null;
        try {
            //注册驱动，MySQL5.0之后可不写
            Class.forName("com.mysql.jdbc.Driver");
            //获得数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //定义sql语句
            String sql="SELECT * FROM emp";
            //创建一个sql执行对象
            st = conn.createStatement();
            //执行sql命令，返回结果集
            rs = st.executeQuery(sql);
            //游标获取数据
            list=new ArrayList<emp>();
            emp e=null;
            while(rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                e=new emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id);
                list.add(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
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
        return list;
    }
}
