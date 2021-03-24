package com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;
//import me.gacl.util.JdbcUtils_C3P0;
//import me.gacl.util.JdbcUtils_DBCP;

public class DataSourceTest {

    @Test
    public void c3p0DataSourceTest() {
        Connection conn = null;
        ResultSet rs = null;
        try{
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
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            //JdbcUtils_C3P0.release(conn, st, rs);
        }
    }
    @Test
    public void DataSourceTest() {
        Connection conn = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = jdbcUtils_DBCP.getConnection();
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
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            //JdbcUtils_C3P0.release(conn, st, rs);
        }
    }
}
