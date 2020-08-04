import java.sql.*;

public class DBHelper {

    public static final String URL = "jdbc:mysql://47.112.112.79:3306/TestDB";
    public static final String USER = "root";
    public static final String PASSWORD = "amberlo89631139";

    public static void main(String[] args) {
        connect();
    }

    public static void connect() {
        Connection conn = null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USER_TABLE");
            while (rs.next()){
                System.out.println(rs.getString("_username"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
