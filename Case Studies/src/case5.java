import javax.swing.*;

class Student {
    String name;
    int rollno;
    int marks;

    public Student(String name, int rollno, int marks) {
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollno + ", Marks: " + marks);
    }
}

// Corrected GraduateStudent class
class GraduateStudent extends Student {
    String special;

    // Constructor must call super() with correct parameters
    public GraduateStudent(String name, int rollno, int marks, String special) {
        super(name, rollno, marks); // Pass values to Student constructor
        this.special = special;
    }

    // Correct placement of @Override
    @Override
    void display() {
        super.display(); // Calls the parent class's display method
        System.out.println("Specialization: " + special);
    }
}

// Main class
public class case5 {
    public static void main(String[] args) {
        GraduateStudent gs = new GraduateStudent("Dikshant", 12, 100, "AI-DS");
        gs.display(); // Call display method to show output
    }
}
