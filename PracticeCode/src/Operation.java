interface Shape {
    void area();
    void perimeter();
}

class Rectangle implements Shape {
    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public void area() {
        System.out.println("Rectangle Area: " + (length * width));
    }

    public void perimeter() {
        System.out.println("Rectangle Perimeter: " + (2 * (length + width)));
    }
}

class Circle implements Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    public void area() {
        System.out.println("Circle Area: " + (Math.PI * radius * radius));
    }

    public void perimeter() {
        System.out.println("Circle Perimeter: " + (2 * Math.PI * radius));
    }
}

public class Operation {
    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 3);
        Shape circ = new Circle(4);

        rect.area();
        rect.perimeter();

        circ.area();
        circ.perimeter();
    }
}
