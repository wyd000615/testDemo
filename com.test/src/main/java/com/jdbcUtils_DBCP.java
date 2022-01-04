package com;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class jdbcUtils_DBCP {}/*{

    *//**
     * 在java中，编写数据库连接池需实现java.sql.DataSource接口，每一种数据库连接池都是DataSource接口的实现
     * DBCP连接池就是java.sql.DataSource接口的一个具体实现
     *//*
    private  static DataSource ds = null;


    static {
        InputStream in = jdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
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

        try {
            prop.load(in);
            //创建数据源
            ds = BasicDataSourceFactory.createDataSource(prop);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();

    }
    //释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
    public static void release(Connection conn,PreparedStatement ps ,ResultSet rs) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rs = null;
        }
    }


}*/
