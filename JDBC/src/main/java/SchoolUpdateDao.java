import java.sql.*;
import java.util.List;

public class SchoolUpdateDao {
    /**
     * This method only should be executed within a connection wrapper.
     * @param conn
     * @param tableName
     * @return
     * @throws SQLException
     */

    private boolean tableExistsOnConn(Connection conn, String tableName) throws SQLException, ClassNotFoundException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet resultSet = dbmd.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }

    public boolean tableExists(String tableName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");
            return tableExistsOnConn(conn, tableName);
        }

        finally {
            if(conn != null) conn.close();
        }
    }

    public void dropTable(String tableName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");
            boolean tableExists = tableExistsOnConn(conn, tableName);
            if (tableExists) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("drop table " + tableName);
            }
        }

        finally {
            if(conn != null) conn.close();
        }
    }

    public boolean createTable(String tableName) throws SQLException, ClassNotFoundException {
        /*
         CREATE TABLE `school` (
         `id` int(11) NOT NULL AUTO_INCREMENT,
         `name` varchar(45) DEFAULT NULL,
         PRIMARY KEY (`id`),
         ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1
         */
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");
            boolean tableExists = tableExistsOnConn(conn, tableName);
            if(tableExists) return false;

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE `" + tableName + "` (\n" +
                    "             `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "             `name` varchar(45) DEFAULT NULL,\n" +
                    "             PRIMARY KEY (`id`)\n" +
                    "           ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1");
            return true;
        }

        finally {
            if(conn != null) conn.close();
        }
    }

    public void insertSchools(String tableName, List<School> schools) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            for (School school : schools) {
                stmt.executeUpdate("insert into " + tableName + " " +
                        "              set name = '" + school.getName() + "'");
            }
        }

        finally {
            if (conn != null) conn.close();
        }
    }

    public void updateSchool(String tableName, String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update " + tableName + " set name = '" + name +
                    "' where name = '" + name + "'");
        }

        finally {
            if (conn != null) conn.close();
        }
    }

    public void deleteSchool(String tableName, String name) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from " + tableName + " where name = '" + name + "'");
        }

        finally {
            if (conn != null) conn.close();
        }
    }

    public void deleteAllSchools(String tableName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test_database?" +
                    "user=geoscow&password=password");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from " + tableName);
        }

        finally {
            if(conn != null) conn.close();
        }
    }
}