package demo_jdbcpool;

import demo_jdbcpool.Utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class template_demo {
    //这里利用JDBCUtils工具类，获取datasource
    //1. 修改1号数据的 salary 为 10000
    @Test
    public void test1(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="UPDATE emp SET salary=10000 WHERE id=?";
        int re = template.update(sql, 1001);
        System.out.println(re);
    }
    //2. 添加一条记录
    @Test
    public void test2(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="INSERT INTO emp(id,ename,job_id) VALUES(?,?,?)";
        int re = template.update(sql, 1015, "张三", 4);
        System.out.println(re);
    }
    //3. 删除刚才添加的记录
    @Test
    public void test3(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="DELETE FROM emp WHERE id=?";
        int re = template.update(sql, 1015);
        System.out.println(re);
    }
    //4. 查询id为1的记录，将其封装为Map集合
    @Test
    public void test4(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="SELECT * FROM emp WHERE id=?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }
    //5. 查询所有记录，将其封装为List
    @Test
    public void test5(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="SELECT * FROM emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    //6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="SELECT * FROM emp";
        List<emp> query = template.query(sql, new BeanPropertyRowMapper<emp>(emp.class));
        for (emp e : query) {
            System.out.println(e);
        }
    }
    //7. 查询总记录数
    @Test
    public void test7(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="SELECT COUNT(id) FROM emp";
        Integer re = template.queryForObject(sql, int.class);
        System.out.println(re);
    }
}
