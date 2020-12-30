package cn.yh.user.cn.yh.user.dao;

import cn.yh.user.cn.yh.user.domain.User;

import java.sql.*;

public class UserDao {
    User users = new User();
    public User findByUsername(String username) {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "1qaz!QAZ";
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;

        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, user, password);
                st = con.createStatement();
                String sql = String.format("select * from user where username = '%s' ",  username);
                rs = st.executeQuery(sql);

                if (rs == null) return null;
                if (!rs.next()) return null;

                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return null;

    }

    public void addUser(User users) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "1qaz!QAZ";
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        Connection con = null;
        Statement st = null;
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            String sql = String.format("insert into user (username,password) VALUES('%s','%s')",users.getUsername(),users.getPassword());
            int num = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

