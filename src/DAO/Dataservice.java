package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.jdbc.OracleTypes;

public class Dataservice {
    private static String url = "jdbc:oracle:thin:@localhost:1521:";
    public static String database = "";
    public static String user ="";
    public static String pass ="";
    public static Connection conn;
    public static boolean Connect(){
        try {
            if(user.equals("sys")||user.equals("SYS")){
                user += " as sysdba";
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url+database, user, pass);
            return true;
        }catch(ClassNotFoundException | SQLException e){
            return false;
        }
    }
    
    public static Connection Getconnect(){
        if(conn== null){
            Connect();
        }
        return conn;
    }

    // Method to get the last login time for a specific user
    public static java.sql.Timestamp getLastLoginTime(String username) {
        Timestamp lastLoginTime = null;
        try (Connection conn = DriverManager.getConnection(url + database, "sys as sysdba", "sys");
             CallableStatement cs = conn.prepareCall("{call Proc_GetUserLastLogin(?,?)}")) {
            // Set input parameter
            cs.setString(1, username.toUpperCase());
            // Register the output parameter
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            // Execute the stored procedure
            cs.execute();
            // Get the result set from the output parameter
            try (ResultSet rs = (ResultSet) cs.getObject(2)) {
                if (rs.next()) {
                    // Extract the last login time from the result set
                    lastLoginTime = rs.getTimestamp("last_login");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastLoginTime;
    }
    
    public static boolean logoutUser(String username) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(url+database, "sys as sysdba", "sys");
            
            // Gọi stored procedure logout_user với tên người dùng là tham số
            String sql = "{ call Proc_logout_related_users(?) }";
            cstmt = conn.prepareCall(sql);
            cstmt.setString(1, username);
            cstmt.execute();
            
            // Đóng kết nối và trả về true nếu thành công
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ và trả về false nếu không thành công
            return false;
        } finally {
            // Đảm bảo rằng tất cả các tài nguyên đã được giải phóng
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
