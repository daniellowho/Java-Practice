class Office {
    String name;
    int empId;
    double salary;

    // Parameterized Constructor
    public Office(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    // Method to display Employee details
    public void display() {
        System.out.println("Name: " + name + ", Emp ID: " + empId + ", Salary: " + salary);
    }


    public static class case8 {
        public static void main(String[] args) {
            // Creating Employee objects with different details
            Office emp1 = new Office("Alice Johnson", 101, 75000.50);
            Office emp2 = new Office("Bob Smith", 102, 82000.75);

            // Displaying Employee details
            emp1.display();
            emp2.display();
        }
    }
}

