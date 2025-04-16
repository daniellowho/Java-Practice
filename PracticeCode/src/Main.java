// interface Animal
interface Animal {
    void makeSound(); // method to be implemented
}

// Dog class implementing Animal
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Cat class implementing Animal
class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}

// main class to test
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound(); // prints Bark
        cat.makeSound(); // prints Meow
    }
}
