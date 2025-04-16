class Chuchi{
    String name;
    int age;

    public Chuchi(){
        this.name= "Unknown";
        this.age= 0;
    }

   public void name(String name){
        System.out.println(name);
    }

    public void age(int age){
        System.out.println(age);
    }

}

public class case7 {
    public static void main(String[] args) {
        Chuchi balak = new Chuchi();
        balak.name("Dikshant");
        balak.age(20);
    }
}
