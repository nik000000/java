import solid.liskovssubstitition.RectangleBad;
import solid.liskovssubstitition.Shape;
import solid.liskovssubstitition.Square;
import solid.liskovssubstitition.SquareBad;

import static java.lang.System.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter.
// You can now see space characters in your code.
public class Main {
    public static void main(String[] args) {
        //empty method because not running anything
        RectangleBad rectangle = new SquareBad();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        out.println(rectangle.getArea());

        //code that uses liskov's substitution
        Shape shape = new Square(5);
        out.println(shape.getArea());
    }
}