import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SchoolDao {
    public List<School> getSchools(String tableName) throws SQLException, ClassNotFoundException {
        List<School> schools = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select name from " + tableName + ";");
            while(rset.next()) {
                if(schools == null) schools = new ArrayList<>();
                String name = rset.getString(1);
                School school = new School(name);
                schools.add(school);
            }
        }

        finally {
            if(conn != null) conn.close();
        }

        return schools;
    }
}
