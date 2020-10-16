package demos;

import java.sql.*;

public class DBUtils {

    public static Connection conn = null;
    public static PreparedStatement state = null;
    public static ResultSet rs = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool", "root", "");
        return conn;
    }

    public static int update(String sql, Object... obs) {
        int result = 0;
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            for (int i = 0; i < obs.length; i++) {
                state.setObject(i + 1, obs[i]);
            }
            result = state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet query(String sql, Object... obs) {
        try {
            conn = getConnection();
            state = conn.prepareStatement(sql);
            for (int i = 0; i < obs.length; i++) {
                state.setObject(i + 1, obs[i]);
            }
            rs = state.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeObject() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (state != null) {
                state.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}