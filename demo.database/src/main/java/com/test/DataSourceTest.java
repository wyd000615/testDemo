package com.test;

import com.until.JdbcUtils_C3P0;
import org.junit.Test;

import java.sql.*;
//import me.gacl.util.JdbcUtils_C3P0;
//import me.gacl.util.JdbcUtils_DBCP;

public class DataSourceTest {

    private JdbcUtils_C3P0 JdbcUtils_C3P0_API;

    @Test
    public void c3p0DataSourceTest() {
        Connection conn = null;
        ResultSet rs = null;
        try {
            //获取数据库连接
            conn = JdbcUtils_C3P0.getConnection();
            String productStr = "";
            PreparedStatement stmt = null;
            String sql = " select product_id  from product p  where p.start_date < sysdate and p.end_date> sysdate   ";
            String productId = "";
            try {
                stmt = conn.prepareStatement(sql);
                //stmt.setString(1,"2");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    productId = rs.getString("product_id");
                    productStr += "'" + productId + "'" + ",";
                }
                rs.close();
                stmt.close();
                productStr = productStr.substring(0, productStr.length() - 1);
                System.out.println(productStr);
            } catch (Exception e) {
            } finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            //JdbcUtils_C3P0.release(conn, st, rs);
        }
    }

    @Test
    public void DataSourceTest() {
        Connection conn = null;
        ResultSet rs = null;
        try {
            //获取数据库连接
            JdbcUtils_C3P0 jdbcUtils_DBCP = null;
            conn = JdbcUtils_C3P0.getConnection();
            String productStr = "";
            PreparedStatement stmt = null;
            String sql = " select product_id  from product p  where p.start_date < sysdate and p.end_date> sysdate  and p.model_type=  ?  ";
            String productId = "";
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "2");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    productId = rs.getString("product_id");
                    productStr += "'" + productId + "'" + ",";
                }
                rs.close();
                stmt.close();
                productStr = productStr.substring(0, productStr.length() - 1);
                System.out.println(productStr);
            } catch (Exception e) {
            } finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            //JdbcUtils_C3P0.release(conn, st, rs);
        }
    }

    /**
     * 获取物联网开户三大资源
     */
    @Test
    public void c3p0DataSourceTest01() {
        Connection apiConn=null;
        Statement stmt = null;
        PreparedStatement imsiStmt = null;
        PreparedStatement iccidStmt = null;

        ResultSet rs = null;
        ResultSet imsiRs = null;
        ResultSet iccidRs = null;
        //定义要获取的开户需要的数据
        String iot_svc_number = "";
        String iot_imsi = "";
        String iot_iccid = "";
        try {
            //获取数据库连接
            Class.forName("oracle.jdbc.OracleDriver");
             apiConn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.87:1530:TDB", "dbvop", "dbvop");
            String svcNumberSql = "select  min(iot_svc_number) as iot_svc_number  from dbvop.iot_svc_number isn where isn.iot_svc_number_status='10' and mvno_business_mark='VOPI' and iot_svc_number like '152666663%'  ";
            String imsiSql = "select * from dbvop.iot_imsi ii where ii.iot_imsi_status='20' and ii.iot_segment=? ";
            String iccidSql = "select * from dbvop.iot_iccid iic where iic.iot_iccid_id=? ";

            try {
                stmt = apiConn.createStatement();
                rs = stmt.executeQuery(svcNumberSql);
                while (rs.next()) {
                    String iot_iccid_id = "";
                    //从数据源获取数据
                    iot_svc_number = rs.getString("iot_svc_number");
                    String svcNumber = iot_svc_number.substring(0, iot_svc_number.length() - 4);
                    //System.out.println("获取到的手机号为==" + iot_svc_number + ",查询条件为" + svcNumber);
                    imsiStmt = apiConn.prepareStatement(imsiSql);
                    imsiStmt.setString(1, svcNumber);
                    imsiRs = imsiStmt.executeQuery();
                    if (imsiRs.next()) {
                        iot_imsi = imsiRs.getString("iot_imsi");
                        iot_iccid_id = imsiRs.getString("iot_iccid_id");
                       // System.out.println("获取到的imsi号为==" + iot_imsi + "获取到的iccd_id号为==" + iot_iccid_id);
                    }
                    imsiRs.close();
                    imsiStmt.close();
                    iccidStmt = apiConn.prepareStatement(iccidSql);
                    iccidStmt.setString(1, iot_iccid_id);
                    iccidRs = iccidStmt.executeQuery();
                    if (iccidRs.next()) {
                        iot_iccid = iccidRs.getString("iot_iccid");
                       // System.out.println("获取到的iccid号为==" + iot_iccid);
                    }
                    iccidRs.close();
                    iccidStmt.close();
                }
                rs.close();
                stmt.close();
                apiConn.close();
                //从数据库获取完数据
                System.out.println("获取到物联网的手机号为");
                System.out.println(iot_svc_number);
                System.out.println("获取到的imsi为");
                System.out.println(iot_imsi);
                System.out.println("获取到的iccid为");
                System.out.println(iot_iccid);

            } catch (Exception e) {
            } finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            //JdbcUtils_C3P0.release(conn, st, rs);
        }
    }


    /**
     * 获取开户三大资源
     */
    @Test
    public void c3p0DataSourceTest02() {
        Connection apiConn=null;
        Statement stmt = null;
        PreparedStatement imsiStmt = null;
        PreparedStatement iccidStmt = null;

        ResultSet rs = null;
        ResultSet imsiRs = null;
        ResultSet iccidRs = null;
        //定义要获取的开户需要的数据
        String iot_svc_number = "";
        String iot_imsi = "";
        String iot_iccid = "";
        try {
            //获取数据库连接
            Class.forName("oracle.jdbc.OracleDriver");
            apiConn = DriverManager.getConnection("jdbc:oracle:thin:@10.161.50.87:1530:TDB", "dbvop", "dbvop");
            String svcNumberSql = "select  min(svc_number) as svc_number from dbvop.svc_number s where /*s.prov_code='36' and*/ s.mvno_business_mark='VOPI' and s.svc_number_status='10' and s.svc_number like'1675112%'  ";
            String imsiSql = "select * from dbvop.imsi i where  i.mvno_business_mark='VOPI' and i.imsi_status='20' and i.ten_thousand_segment=? ";
            String iccidSql = "select * from dbvop.iccid ic where ic.iccid_id=?";

            try {
                stmt = apiConn.createStatement();
                rs = stmt.executeQuery(svcNumberSql);
                while (rs.next()) {
                    String iot_iccid_id = "";
                    //从数据源获取数据
                    iot_svc_number = rs.getString("svc_number");
                    String svcNumber = iot_svc_number.substring(0, iot_svc_number.length() - 4);
                    //System.out.println("获取到的手机号为==" + iot_svc_number + ",查询条件为" + svcNumber);
                    imsiStmt = apiConn.prepareStatement(imsiSql);
                    imsiStmt.setString(1, svcNumber);
                    imsiRs = imsiStmt.executeQuery();
                    if (imsiRs.next()) {
                        iot_imsi = imsiRs.getString("imsi");
                        iot_iccid_id = imsiRs.getString("iccid_id");
                        // System.out.println("获取到的imsi号为==" + iot_imsi + "获取到的iccd_id号为==" + iot_iccid_id);
                    }
                    imsiRs.close();
                    imsiStmt.close();
                    iccidStmt = apiConn.prepareStatement(iccidSql);
                    iccidStmt.setString(1, iot_iccid_id);
                    iccidRs = iccidStmt.executeQuery();
                    if (iccidRs.next()) {
                        iot_iccid = iccidRs.getString("iccid");
                        // System.out.println("获取到的iccid号为==" + iot_iccid);
                    }
                    iccidRs.close();
                    iccidStmt.close();
                }
                rs.close();
                stmt.close();
                apiConn.close();
                //从数据库获取完数据
                System.out.println("获取到人联网的手机号为");
                System.out.println(iot_svc_number);
                System.out.println("获取到的imsi为");
                System.out.println(iot_imsi);
                System.out.println("获取到的iccid为");
                System.out.println(iot_iccid);

            } catch (Exception e) {
            } finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            //JdbcUtils_C3P0.release(conn, st, rs);
        }
    }

}
