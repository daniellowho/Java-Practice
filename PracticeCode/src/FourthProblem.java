import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;

public class FourthProblem {

    public static void main(String[] args) throws Exception {

        // Create new instance for the class BufferedReader

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your Input: ");

        boolean isPalindrome = true;


        String ch = br.readLine();
        int count = ch.length();
        for (int i = 0; i < count; i++) {
            if (ch.charAt(i) != ch.charAt(count - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(ch + " is a palindrome.");
        } else {
            System.out.println(ch + " is not a palindrome.");
        }
    }
}
