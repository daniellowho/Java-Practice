
class employee{
    String name ;
    double salary;

    public employee(String name, double salary){
        this.name= name;
        this.salary=salary;



    }
    public void display(){
        System.out.println("Employee name: " +name+ "  salary "+salary );
    }

}

class manager extends employee {
    String department;

    public manager(String name, double salary, String department) {
        super(name, salary);                                          // super is used to access the salary and name in the above class which is give in above
        this.department = department;
    }


    @Override
    public void display() {
        System.out.println("Manager Name: " + name + ", Salary : " + salary + ", Department : " + department);
    }
}

public class    case1 {
    public static void main(String[] args) {
        employee emp = new employee("dikshant", 500000);
        manager mgr = new manager("chodu", 80000, "IT");

        emp.display();
        mgr.display();
    }
}
