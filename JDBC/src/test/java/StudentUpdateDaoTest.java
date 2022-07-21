import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentUpdateDaoTest {
    static StudentUpdateDao stud;
    static SchoolUpdateDao  scud;
    static StudentDao       std;
    static SchoolDao        scd;
    static String           studentTableName;
    static String           schoolTableName;

    @BeforeAll
    static void setUp() throws SQLException, ClassNotFoundException {
        stud = new StudentUpdateDao();
        scud = new SchoolUpdateDao();
        std = new StudentDao();
        scd = new SchoolDao();
        studentTableName = "student";
        schoolTableName = "school";

        var schools = Arrays.asList(new School("Green Oaks High School"),
                                                new School("school 2"),
                                                new School("school 3"));
        scud.createTable(schoolTableName);
        scud.insertSchools(schoolTableName, schools);
    }

    @Test
    @Order(1)
    void createTable() throws SQLException, ClassNotFoundException {
        System.out.println("Create Table Test ------");

        System.out.println("\t1) No table named '" + studentTableName + "'");
        assertFalse(stud.tableExists(studentTableName));

        System.out.println("\t2) Create table '" + studentTableName + "'");
        assertTrue(stud.createTable(studentTableName));

        System.out.println("\t3) Create duplicate table '" + studentTableName + "'");
        assertFalse(stud.createTable(studentTableName));

        System.out.println("\t4) Table '" + studentTableName + "' confirmed");
        assertTrue(stud.tableExists(studentTableName));
    }

    @Test
    @Order(2)
    void insertStudents() throws SQLException, ClassNotFoundException {
        System.out.println("Insert Students Test ------");

        System.out.println("\t1) Empty table '" + studentTableName + "'");
        var tableStudents = std.getStudents(studentTableName);
        assertTrue(tableStudents == null || tableStudents.isEmpty());

        System.out.println("\t2) Insert students");
        var students = Arrays.asList(new Student("Bob Anderson", 1),
                                                 new Student("Janet Collins", 1));
        stud.insertStudents(studentTableName, students);

        System.out.println("\t3) Verify Students");
        tableStudents = std.getStudents(studentTableName);
        for(int i = 0; i < tableStudents.size(); i++) {
            assertTrue(tableStudents.get(i).equals(students.get(i)));
        }
    }

    @AfterAll
    static void tearDown() throws SQLException, ClassNotFoundException {
        if(stud.tableExists(studentTableName))
            stud.dropTable(studentTableName);
        if(scud.tableExists(schoolTableName))
            scud.dropTable(schoolTableName);
    }
}