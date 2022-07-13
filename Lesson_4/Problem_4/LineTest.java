package Lesson_4.Problem_4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    int[] p1 = {0,0};
    int[] p2 = {3,3};
    int[] p3 = {4,3};
    int[] p4 = {4,3};
    int[] p5 = {1,0};

    Line l1 = new Line(p1, p2);
    Line l2 = new Line(p1, p4);
    Line l3 = new Line(p5,p3);


//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void getSlope() {
        assertEquals(1.0, l1.getSlope(), 0.0001);
    }

    @Test
    void getDistance() {
        assertEquals(5.0, l2.getDistance(),0.0001);
    }

    @Test
    void parrallelTo() {
        assertTrue(l1.parrallelTo(l3));
    }
}