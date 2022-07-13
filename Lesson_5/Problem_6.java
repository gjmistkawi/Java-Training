package Lesson_5;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Problem_6 {
    public static class SampleSingleton{
        private static Connection conn = null;
        private static SampleSingleton instance = null;

        private SampleSingleton(Connection c) {
            conn = c;
        }

        public static SampleSingleton getInstance(Connection c) {
            if(instance == null) {
                synchronized (SampleSingleton.class) {
                    if(instance == null)
                        instance = new SampleSingleton(c);
                }
            }

            return instance;
        }
    }
}
