package utility;


import static utility.cons.IdentityInfo.DB_ID;
import static utility.cons.IdentityInfo.DB_PASSWORD;
import static utility.cons.IdentityInfo.DB_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_ID, DB_PASSWORD);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void close(AutoCloseable... closeables){
        for(AutoCloseable closeable : closeables){
            if(closeable != null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
