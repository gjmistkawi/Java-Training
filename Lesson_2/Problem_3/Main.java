package Lesson_2.Problem_3;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4.0, 5.0);
        System.out.println(r.display());
        System.out.println("area: " + r.calculateArea());
        System.out.println();

        Triangle t = new Triangle(3.0, 6.0);
        System.out.println(t.display());
        System.out.println("area: " + t.calculateArea());
        System.out.println();

        Circle c = new Circle(4.5);
        System.out.println(c.display());
        System.out.println("area: " + c.calculateArea());
    }
}
