import com.sun.security.jgss.GSSUtil;

public class ClassPractice1 {
    public static void main (String[] args) {
//        char c = 0b1000001;
//        System.out.println(c); // Binary
//
//        c = 0101;
//        System.out.println(c); //Octal
//
//
//        c= 0x41;
//        System.out.println(c); //Hexadecimal


        // Formatting options
//        short s = 127;
//        byte b= (byte)s;
//        System.out.println(b); //contiguous memory locations
//
//        int x=1;
//        int r = --x+ x++ + ++x + x--;
//        System.out.println(x + " " + r);
//        int number=2;
//        switch (number) {
//
//            case 1:
//                System.out.println("ONE");
//                break;
//            case 2:
//                System.out.println("TWO");
//                break;
//            case 3:
//                System.out.println("THREE");
//                break;
//            default:
//                System.out.println("Not in 1,2 or 3");
//        }

        for (int i=0; i<12; i++){
        switch (i){
            case 0:
            case 1:
                case 2:
                    case 3:
                        case 4:
                            System.out.println("i is less than 5");
                            break;
                            case 5:
                                case 6:
                                    case 7:
                                        case 8:
                                            case 9:
                                                System.out.println("i is less than 10");
                                                break;
            default:
                System.out.println("i is greater than 10");

        }

        }
    }
}

