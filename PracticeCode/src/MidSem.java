

//Explain Encapsulation with an example.

    /*
     Encapsulation is the method of hiding "sensitive details" from the source code. This method is used to hide some parts of code so that it is not changeable by people.
     We start off by making the class private and setting 'get' and 'set' methods to retrieve information from the private class.
     */



//     private int id;  // Renamed variable to id (since it's a number)

//     // Setter method
//     public void set(int fname) {
//         id = fname;  // Corrected assignment
//     }

//     // Getter method
//     public int get() {
//         return id;  // Returns id
//     }
// }

// public class MidSem {
//     public static void main(String[] args) {
//         Student s = new Student();
//         s.set(1234);  // Setting value
//         System.out.println(s.get());  // Printing the value
//     }
// }






// Differentiate between method overloading and method overriding with proper syntax.
/*
 Method Overloading= It is the process of overloading the same variable of one data-type with another data-type.
 */


//Method Overloading
//  public class MidSem {
//     // Overloaded method with int parameters
//     static int method(int a, int b) {
//         return a + b;
//     }

//     // Overloaded method with double parameters
//     static double method(double a, double b) {
//         return a + b;
//     }

//     public static void main(String[] args) {
//         System.out.println("Method Overloading Example:");
//         System.out.println(method(8, 6));   // Calls method(int, int)
//         System.out.println(method(5.5, 2.2)); // Calls method(double, double)
//         System.out.println();



/*
 Method Overriding is the process of extending (inheriting) the behaviour of a child class from its parent class.
 */

//Method Overriding
// class Animal {
//     public void bark() {
//         System.out.println("barks.(?)");
//     }
//
//     public void sit() {
//         System.out.println("sits.");
//     }
// }
//
// class Dog extends Animal {
//     @Override
//     public void bark() {
//         System.out.println("woof");
//     }
//
//     @Override
//     public void sit() {
//         System.out.println("sipsipsip");
//     }
// }
//
// public class MidSem {
//     public static void main(String[] args) {
//         Animal anim = new Animal();
//         Dog acto = new Dog();
//
//         anim.bark();
//         anim.sit();
//
//         System.out.println();
//         System.out.println("whoa thats a line");
//
//         acto.bark();
//         acto.sit();
//     }
// }


//What is the significance of the super keyword in inheritance? Give example.

/* Inheritance is the process of inheriting methods of a parent class into a sub-class, called child class.
 These may also be referred as super class (parent class) and sub class (child class). The super keyword accounts for calling the parent class as a constructor in the child class
 and call its methods.
 */

//class Animal {
//    void bark(){
//        System.out.println("barks?");
//    }
//    void sit(){
//        System.out.println("sits.");
//    }
//}
//
//class Dog extends Animal {
//    void bark(){
//        System.out.println("woof");
//    }
//    void sit(){
//        System.out.println("wags tail");
//    }
//}
//
//
//public class MidSem {
//    public static void main(String[] args) {
//        Animal x = new Animal();
//        Dog y = new Dog();
//        x.bark();
//        x.sit();
//
//        System.out.println();
//        System.out.println();
//
//        y.bark();
//        y.sit();
//    }
//}
//
//


/*
Write a Java program to demonstrate function overloading by creating a
Calculator class with multiple add() methods: one that adds two integers, one that adds three integers, and one that adds two double values.
 */

//class Calculator{
//    static int num(int a, int b){
//        System.out.println("a+b: ");
//        return a+b;
//    }
//
//    static int num(int a, int b, int c){
//        System.out.println("a+b+c: ");
//        return a+b+c;
//    }
//
//    static double num (double a, double b, double c){
//        System.out.println("a+b+c: (doubles method) ");
//        return a+b+c;
//    }
//
//}
//
//
//public class MidSem{
//    public static void main(String[] args) {
//        Calculator calc = new Calculator();
//        System.out.println(calc.num(5,10));
//        System.out.println(calc.num(69,10));
//        System.out.println(calc.num(5.2, 4.3, 4.4 ));
//    }
//}


//Q5. Write a short note on interfaces in Java. Provide a simple example of an interface and its implementation.
/*
Interfaces is like a blueprint of a class. Using interface, you can specify what a class must do, but not how it does it. Instances are similar to classes,
except their method remains empty, which can be used later on to by using the 'implement' function.
 */
//interface Car {
//    void sound();
//    void drive();
//    void stop();
//    void brand();
//}
//
//class Car1 implements Car {
//    public void sound() {
//        System.out.println("vroom v6");
//    }
//
//    public void drive() {
//        System.out.println("brrrr");
//    }
//
//    public void stop() {
//        System.out.println("Screech");
//    }
//
//    public void brand() {
//        System.out.println("FORZA FERRARI SEMPRE");
//    }
//}
//
//public class MidSem {
//    public static void main(String[] args) {
//        Car c = new Car1();
//        c.drive();
//        c.sound();
//        c.stop();
//        c.brand();
//    }
//}


//Q6. Explain the difference between static and instance variables in Java with an example.
/*
Static variables are constant variables accessable by all classes and does not change. These variables belong to the class itself.
Instance variables are variables that change in every other object class. These variables belong to their respective objects.
 */



//Write a Java program to demonstrate type conversion from int to float and from double to int, showing both automatic and explicit casting.
//public class MidSem{
//    public static void main(String[] args) {
//        int val = 100;
//        float v = val; //Automatic Type Casting
//
//
//        double x = 100.567;
//        int y = (int) x; //Explicit Type Casting
//    }
//}


//Q8. Define polymorphism. How is runtime polymorphism achieved in Java? Give an example.
/*
Polymorphism, if broken into two words, breaks into poly and morphism where poly means many and morphism means morphing thus making morphing into many forms.
It occurs when many classes are interrelated to each other. Runtime polymorphism is achieved when a subclass overrides a method of its superclass.
 */

//class Animal {
//    void sound(){
//        System.out.println("boo");
//    }
//    void crack(){
//        System.out.println("breaks");
//    }
//}
//
//class Dog extends Animal {
//    @Override
//    void sound(){
//        System.out.println("woof");
//    }
//    @Override
//    void crack(){
//        System.out.println("breaks.");
//    }
//}
//
//public class MidSem{
//    public static void main(String[] args) {
//        Animal a= new Animal();
//        Dog d= new Dog();
//
//        d.sound();
//        d.crack();
//    }
//}




//Write a Java program to implement a switch-case where a user selects between Electronics, Clothing, and Groceries sections, and the appropriate message is displayed.
//
//import java.util.Scanner;
//
//public class MidSem {
//    public static void main(String[] args) {
//        Scanner sc= new Scanner (System.in);
//        System.out.println("Enter a number between 1-3: ");
//        int num= sc.nextInt();
//        switch(num){
//            case 1:
//                System.out.println("Electronics");
//                break;
//            case 2:
//                System.out.println("Clothing");
//                break;
//            case 3:
//                System.out.println("Groceries");
//                break;
//            default:
//                System.out.println("You selected a wrong number. Please choose a number between 0 and 3");
//        }
//    }
//}

//Q10. Write a Java program to check whether a number is prime using loops and conditional statements.

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MidSem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check whether it's prime: ");
        int n = sc.nextInt();

        boolean isPrime = true; // Assume number is prime initially

        // 0 and 1 are not prime numbers
        if (n <= 1) {
            isPrime = false;
        }
        else {
            // Check from 2 to sqrt(n)
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break; // Exit loop if divisor found
                }
            }
        }

        // Print result
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}


//Q11. Write a Java program to print the Fibonacci series up to a given number using loops.
//import java.util.Scanner;
//
//import java.util.Scanner;
////
//public class MidSem {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a number (N): ");
//        int limit = scanner.nextInt();
//
//        int a = 0, b = 1;
//        System.out.print("Fibonacci Series up to " + limit + ": ");
//
//        // Print first term (0)
//        System.out.print(a + " ");
//
//        // Generate terms until next term exceeds N
//        while (b <= limit) {
//            System.out.print(b + " ");
//            int nextTerm = a + b;
//            a = b;
//            b = nextTerm;
//        }
//    }
//}
//
//

//A company maintains salaries in different data types.
// Write a Java program to calculate total and annual salary using int, float, double, and long data types with proper conversions.


