class Circle {
double radius;
    final double PI = 3.14159;

    final double calculateArea(double radius) {
        return PI * radius * radius;
    }
}

public class case6 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        double radius = 5.0;
        System.out.println("Area of circle with radius " + radius + " is: " + circle.calculateArea(radius));

    }
}
