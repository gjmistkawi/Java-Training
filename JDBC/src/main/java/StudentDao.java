import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    public List<Student> getStudents(String tableName) throws SQLException, ClassNotFoundException {
        List<Student> students = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select name, schoolId from " + tableName + ";");
            while(rset.next()) {
                if(students == null) students = new ArrayList<>();
                String name = rset.getString(1);
                int schoolId = rset.getShort(2);
                Student student = new Student(name, schoolId);
                students.add(student);
            }
        }

        finally {
            if(conn != null) conn.close();
        }

        return students;
    }

    public List<String> getColumnNames(String table) throws SQLException {
        List<String> colNames = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select * from " + table + " limit 1;");
            ResultSetMetaData rsmd = rset.getMetaData();
            for(int i = 0; i < rsmd.getColumnCount(); i++) {
                if(colNames == null) colNames = new ArrayList<>();
                colNames.add(rsmd.getColumnName(i+1));
            }
        }

        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            if(conn != null) conn.close();
        }

        return colNames;
    }
}
