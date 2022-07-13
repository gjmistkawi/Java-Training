package Lesson_2.Problem_3;

public class Triangle implements Shape{
    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double calculateArea() {
        return height * base * 0.5;
    }

    @Override
    public String display() {
        String display = "Shape: Triangle\nheight: " + height + "\nbase: " + base;
        return display;
    }
}
