import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecondProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 5 numbers: ");

        int[] arr = new int[5];

        for (int val : arr){
            int n = Integer.parseInt(br.readLine());
            arr[n] = val;
        }
        for (int val : arr) {
            for (int j= 0; j<val; j++){
                if (j==val){
                    System.out.println(j + "This number is a duplicate");
                }
            }
        }
    }
}
