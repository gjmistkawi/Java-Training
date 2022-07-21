import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SchoolUpdateDaoTest {
    static SchoolUpdateDao sud;
    static SchoolDao sd;
    static String tableName;
    static String wrongTableName;

    @BeforeAll
    static void setUp() {
        sud = new SchoolUpdateDao();
        sd = new SchoolDao();
        tableName = "school";
        wrongTableName = "noTable";
    }

    @Test
    @Order(1)
    void createTable() throws SQLException, ClassNotFoundException {
        System.out.println("Create Table Test ------");

        System.out.println("\t1) No table named '" + tableName + "'");
        assertFalse(sud.tableExists(tableName));

        System.out.println("\t2) Create table '" + tableName + "'");
        assertTrue(sud.createTable(tableName));

        System.out.println("\t3) Create duplicate table '" + tableName + "'");
        assertFalse(sud.createTable(tableName));

        System.out.println("\t4) Table '" + tableName + "' confirmed");
        assertTrue(sud.tableExists(tableName));
    }

    @Test
    @Order(2)
    void tableExists() throws SQLException, ClassNotFoundException {
        System.out.println("Table Exists Test ------");

        System.out.println("\t1) Table '" + tableName + "' exists");
        assertTrue(sud.tableExists(tableName));

        System.out.println("\t2) Table '" + tableName + "' doesn't exist");
        assertFalse(sud.createTable(tableName));
    }


    @Test
    @Order(3)
    void insertSchools() throws SQLException, ClassNotFoundException {
        System.out.println("Insert Schools Test ------");
        var schools = Arrays.asList(new School("school 1"),
                                                 new School("school 2"),
                                                 new School("school 3"));

        System.out.println("\t1) Insert schools '" + tableName + "' exists");
        sud.insertSchools(tableName, schools);

        System.out.println("\t2) Checking inserted schools");
        var loadedSchools = sd.getSchools(tableName);

        int i = 1;
        for(School s: loadedSchools) {
            assertTrue(s.getName().equals("school " + i));
            i++;
        }
    }

    @Test
    @Order(4)
    void deleteSchool() throws SQLException, ClassNotFoundException {
        System.out.println("Delete School Test ------");

        System.out.println("\t1) Checking schools exist");
        var schools = sd.getSchools(tableName);
        assertFalse(schools.isEmpty());

        System.out.println("\t2) Delete school");
        sud.deleteSchool(tableName, schools.get(0).getName());
        var updatedSchools = sd.getSchools(tableName);
        assertEquals(schools.size()-1, updatedSchools.size());
    }

    @Test
    @Order(5)
    void deleteAllSchools() throws SQLException, ClassNotFoundException {
        System.out.println("Delete All Schools Test ------");

        System.out.println("\t1) Checking schools exist");
        var schools = sd.getSchools(tableName);
        assertFalse(schools.isEmpty());

        System.out.println("\t2) Delete schools");
        sud.deleteAllSchools(tableName);
        schools.clear();
        schools = sd.getSchools(tableName);
        assertTrue(schools == null || schools.isEmpty());
    }

    @Test
    @Order(6)
    void dropTable() throws SQLException, ClassNotFoundException {
        System.out.println("Drop Table Test ------");

        System.out.println("\t1) Table '" + tableName + "' exists");
        assertTrue(sud.tableExists(tableName));

        System.out.println("\t2) Drop table '" + tableName + "'");
        sud.dropTable(tableName);
        assertFalse(sud.tableExists(tableName));
    }

    @AfterAll
    static void tearDown() throws SQLException, ClassNotFoundException {
        if(sud.tableExists(tableName))
            sud.dropTable(tableName);
    }
}