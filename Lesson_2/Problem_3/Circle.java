package Lesson_2.Problem_3;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String display() {
        String display = "Shape: Circle\nradius: " + radius;
        return display;
    }
}
