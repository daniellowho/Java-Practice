import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FirstProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr= new int [5];
        System.out.println("Enter 5 numbers: ");
        for (int i=0 ; i<5 ; i++) {
            arr [i]= Integer.parseInt (br.readLine());

        }

        int x= 0;
        for (int num : arr) {
            x = x + num;
        }
        System.out.println("Sum of all elements is: " + x);


    }
}
