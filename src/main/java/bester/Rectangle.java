package bester;

public class Rectangle {
    private final double length;
    private final double breadth;

    public Rectangle(final double breadth, final double length) {
        this.breadth = breadth;
        this.length = length;
    }

    public double area() {
        return length * breadth;
    }
}