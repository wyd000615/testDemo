package com.test.realm;

import com.test.pojo.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.sql.*;

public class MyRealm implements Realm {
    //返回一个唯一的Realm名字
    @Override
    public String getName() {
        return "myRealm";
    }

    //判断此Realm是否支持此Token
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }
    //根据Token获取认证信息

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();  //得到用户名
        String password = new String((char[]) token.getCredentials()); //得到密码
        //从数据库中获取用户名和密码
        UserInfo userInfos = null;
        try {
            userInfos = qryUserInfo(username);
            if (userInfos == null) {
                throw new UnknownAccountException(); //如果用户名错误
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (!"123".equals(userInfos.getPassword())) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    public UserInfo qryUserInfo(String username) throws SQLException, ClassNotFoundException {
        //List<UserInfo> userInfoList= new ArrayList<UserInfo>();
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirodb?serverTimezone=UTC", "root", "root");
        //3.操作数据库，实现增删改查

        String sql = "select t.id, t.username,t.password from users t where t.username= ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        //如果有数据，rs.next()返回true
        UserInfo userInfo = new UserInfo();
        while (rs.next()) {
            System.out.println(rs.getString("username") + " 密码：" + rs.getString("password"));
            userInfo.setId(rs.getString("id"));
            userInfo.setName(rs.getString("username"));
            userInfo.setPassword(rs.getString("password"));
            //userInfoList.add(userInfo);
        }
        return userInfo;
    }
}
