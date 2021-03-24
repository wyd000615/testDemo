package com.until;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: JdbcUtils_C3P0
 * @Description: 数据库连接工具类
 * @author: 孤傲苍狼
 * @date: 2014-10-4 下午6:04:36
 *
 */
public class JdbcUtils_C3PO_API {

    private static ComboPooledDataSource ds = null;
    //在静态代码块中创建数据库连接池
    static{
        try{
            //通过代码创建C3P0数据库连接池
            ds = new ComboPooledDataSource();
            ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
            ds.setJdbcUrl("jdbc:oracle:thin:@10.161.50.87:1530:TDB");
            ds.setUser("dbvop");
            //ds.setConnectionTesterClassName("oracle.jdbc.driver.OracleDriver");
            ds.setPassword("dbvop");
            ds.setInitialPoolSize(10);
            ds.setMinPoolSize(5);
            ds.setMaxPoolSize(20);

            //通过读取C3P0的xml配置文件创建数据源，C3P0的xml配置文件c3p0-config.xml必须放在src目录下
           // ds = new ComboPooledDataSource();//使用C3P0的默认配置来创建数据源
            //ds = new ComboPooledDataSource("Oracle");//使用C3P0的命名配置来创建数据源
          /*  InputStream in = jdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("c3p0-config.xml");
            Properties prop = new Properties();
            prop.put("driverClassName","oracle.jdbc.driver.OracleDriver");
            prop.put("url","jdbc:oracle:thin:@10.161.50.88:1530:TDB");
            prop.put("username","dbvop");
            prop.put("password","dbvop");
            prop.put("jdbcPoolInitSize","10");
            prop.put("maxActive","50");
            prop.put("maxIdle","20");
            prop.put("minIdle","5");
            prop.put("maxWait","60000");
            prop.load(in);
*/
            // System.out.println(ds);
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }



    /**
     * @Method: getConnection
     * @Description: 从数据源中获取数据库连接
     * @Anthor:孤傲苍狼
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        //从数据源中获取数据库连接
        return ds.getConnection();
    }

    /**
     * @Method: release
     * @Description: 释放资源，
     * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
     * @Anthor:孤傲苍狼
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
