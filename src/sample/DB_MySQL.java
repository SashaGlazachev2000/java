package sample;
import java.sql.*;


public class DB_MySQL {

        private final String HOST = "localhost";
        private final String PORT = "3306";
        private final String DB_NAME = "mysong_db";
        private final String LOGIN = "root";
        private final String PASS = "";

        private Connection dbConn = null;

        private Connection getDbConnection() throws ClassNotFoundException, SQLException {
            String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;//для подкличения к базе данных
            Class.forName("com.mysql.cj.jdbc.Driver");

            dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
            return dbConn;
        }

//        public void isConnected() throws ClassNotFoundException, SQLException{
//            dbConn = getDbConnection();
//            System.out.println(dbConn.isValid(1000));
//        }

        public void createTable(String tableName) throws ClassNotFoundException, SQLException{
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                    + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))"
                    + " ENGINE = MYISAM;";

            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate(sql);
        }

        public void addToTable(String title, String text) throws ClassNotFoundException, SQLException{
            String sql = "INSERT INTO `song` (title, text) VALUES (?, ?)";
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, title);
            prSt.setString(2, text);

            prSt.executeUpdate();
        }


}
