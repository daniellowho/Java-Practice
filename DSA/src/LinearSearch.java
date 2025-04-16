public class LinearSearch {
    public static int search (int[] arr, int target){
        for (int i=0; i<arr.length; i++){
            if (arr[i]<target){
                System.out.println(i);
            }
        }
        return -1;
    }
    public static void main (String[] args){
        int[] arr= {10, 20, 30, 40, 50, 60, 70};
            int target= 50;

            int result= search(arr, target);

            if (result!= -1){
                System.out.println("found at index: " + result);
        }
            else {
                System.out.println("number not found");
            }
    }

}

