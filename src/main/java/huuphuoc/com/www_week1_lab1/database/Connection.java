package huuphuoc.com.www_week1_lab1.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/ten_csdl";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        java.sql.Connection connection = null;
        try {
            // Đăng ký trình quản lý JDBC
            Class.forName("org.mariadb.jdbc.Driver");
            // Tạo kết nối
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Không thể tìm thấy driver JDBC");
        }
        return (Connection) connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
