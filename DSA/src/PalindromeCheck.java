public class PalindromeCheck {
    public static void checker (String word){
        int n= word.length();
        for (int i=0; i<(n-i-1); i++){
            if (word.charAt(i)!= word.charAt(n-i-1)){
                System.out.println("Not Palindrome");
                return;
            }
        }
        System.out.println("Palindrome");
    }

    public static void main(String[] args) {
        checker ("madam");
        checker ("chodohc");
    }
}