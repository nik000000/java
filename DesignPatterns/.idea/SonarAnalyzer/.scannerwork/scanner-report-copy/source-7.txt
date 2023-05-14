package solid.openclosed;

public class AreaCalculatorBad {
    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getLength() * rectangle.getWidth();
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else {
            throw new IllegalArgumentException("Unsupported shape type");
        }
    }
}
