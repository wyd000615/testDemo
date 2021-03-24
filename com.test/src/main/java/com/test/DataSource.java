package com.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.*;

public class DataSource {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 动态加载mysql驱动
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.88:1530:TDB", "dbvop", "dbvop");
        String sql = " select code_catg from d_code_map";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String str = resultSet.getString("code_catg");
            System.out.println(str);
        }
    }
    @Test
    public void test22() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 动态加载mysql驱动
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.87:1530:TDB", "dbvop", "dbvop");
        String sql = "        select sysdate  from dual ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Timestamp timestamp = resultSet.getTimestamp(1);
            System.out.println(timestamp);
        }
    }
    @Test
    public void test222() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 动态加载mysql驱动
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.87:1530:TDB", "dbvop", "dbvop");
        String sql = "        select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')  from dual ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String str = resultSet.getString(1);
            System.out.println(str);
        }
    }

    @Test
    public void test2222() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 动态加载mysql驱动
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.87:1530:TDB", "dbvop", "dbvop");
        String sql = "      insert into i_main_deputy " +
                "            (I_MAIN_DEPUTY_ID,DEPUTY_USER_ID,MVNO_BUSINESS_MARK)  values (I_MAIN_DEPUTY_ID_SEQ.nextval,'123456','LLLL')";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    @Test
    public void test22222() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 动态加载mysql驱动
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.87:1530:TDB", "dbvop", "dbvop");
        String sql = "        select  *  from i_main_deputy i where i.MVNO_BUSINESS_MARK='LLLL' ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String str = resultSet.getString(1);
            System.out.println(str);
        }
    }
    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        druidDataSource.setUrl("jdbc:oracle:thin:@10.161.50.107:1530:TDB");
        druidDataSource.setUsername("tongjij_vopds");
        druidDataSource.setPassword("tj_vopds");
        //
        // druidDataSource.setUsername("dbvop");  tj_vopds
        //        druidDataSource.setPassword("dbvop");
        druidDataSource.setMaxActive(150);
        druidDataSource.setMinIdle(50);
        druidDataSource.setInitialSize(0);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setRemoveAbandoned(false);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setMaxWait(5000);
        druidDataSource.setMinEvictableIdleTimeMillis(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);

        DruidPooledConnection conn = druidDataSource.getConnection();
        String sql = " select code_catg from d_code_map";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String str = resultSet.getString("code_catg");
            System.out.println(str);
        }
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }


    /*
     * 往ss表中插入数据
     * */
    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        druidDataSource.setUrl("jdbc:oracle:thin:@10.161.50.87:1530:TDB");
        druidDataSource.setUsername("dbvop");
        druidDataSource.setPassword("dbvop");
        druidDataSource.setMaxActive(150);
        druidDataSource.setMinIdle(50);
   /*     druidDataSource.setInitialSize(0);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setRemoveAbandoned(false);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setMaxWait(5000);
        druidDataSource.setMinEvictableIdleTimeMillis(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000)*/
        ;

        DruidPooledConnection conn = druidDataSource.getConnection();
        String sql = " insert into dbvop.secretary_synch(secretary_synch_id,order_id, " +
                "                   create_time,mvno_business_mark,synch_status,upd_time,busi_type,service_id, " +
                "                  product_id,mvno_user_id,svc_number) values  " +
                "                  (SECRETARY_SYNCH_SEQ.nextval,?,sysdate,?,'0',null,?,?,?,?,?) ";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        for (long i = 9620070779925979L; i < 962007077992597900L; i++) {
            System.out.println("====" + i);
            preparedStatement.setString(1, String.valueOf(i));
            preparedStatement.setString(2, "VOPI");
            preparedStatement.setString(3, "order");
            preparedStatement.setString(4, "PR_0007");
            preparedStatement.setString(5, "PR_0007");
            preparedStatement.setString(6, "1234567");
            preparedStatement.setString(7, "1234567");
            preparedStatement.executeUpdate();
        }
        System.out.println("结束");
        preparedStatement.close();
        conn.close();
    }

    @Test
    public void test4() throws ClassNotFoundException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        druidDataSource.setUrl("jdbc:oracle:thin:@10.161.50.87:1530:TDB");
        druidDataSource.setUsername("dbvop");
        druidDataSource.setPassword("dbvop");
        druidDataSource.setMaxActive(150);
        druidDataSource.setMinIdle(50);
        druidDataSource.setInitialSize(0);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setRemoveAbandoned(false);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setMaxWait(5000);
        druidDataSource.setMinEvictableIdleTimeMillis(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);

        DruidPooledConnection conn = druidDataSource.getConnection();
        String sql = " select code_catg from d_code_map";
        conn.close();
    }

    /*@Test
    public void test5() throws ClassNotFoundException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/imooc", "root", "root");
        druidDataSource.setUsername("dbvop");
        druidDataSource.setPassword("dbvop");
        druidDataSource.setMaxActive(150);
        druidDataSource.setMinIdle(50);
        druidDataSource.setInitialSize(0);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setRemoveAbandoned(false);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setMaxWait(5000);
        druidDataSource.setMinEvictableIdleTimeMillis(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);

        DruidPooledConnection conn = druidDataSource.getConnection();
        String sql = " select code_catg from d_code_map";
        conn.close();
    }*/

    @Test
    public void test6() throws ClassNotFoundException, SQLException {
        //加载MySql驱动
        Class.forName("com.mysql.jdbc.Driver");
        //加载Oracle驱动
       // Class.forName("oracle.jdbc.driver.OracleDriver");
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imooc", "root", "root");
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" 年龄："+rs.getInt("age"));
        }

    }
}
