package Lesson_2.Problem_3;

public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String display() {
        String display = "Shape: Rectangle\nlength: " + length + "\nwidth: " + width;
        return display;
    }
}
