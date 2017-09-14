package bester;

public class Rectangle implements Bestable<Rectangle> {
    private final double length;
    private final double breadth;

    public Rectangle(final double breadth, final double length) {
        this.breadth = breadth;
        this.length = length;
    }

    double area() {
        return length * breadth;
    }

    @Override
    public boolean isBetterThan(Rectangle opponent) {
        return this.area() > opponent.area();
    }
}