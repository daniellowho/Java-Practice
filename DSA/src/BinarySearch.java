public class BinarySearch {
    public static int search(int[] arr, int target){
        int mid; int start; int end;
        start=0;
        end= arr.length-1;

        for (int i=0; i<arr.length ; i++){
            mid= start + end /2;
            if (arr[mid]== target){
                return mid;
            }
            else if (arr[mid]< target){
                start= mid+1;
            }
            else if (arr[mid]>target){
                end= mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr= {10,20,30,40,50,60,70};
        int target= 20;

        int result= search(arr, target);

        if (result!= -1){
            System.out.println("index: " + result);
        }
        else {
            System.out.println("not found in array");
        }
    }
}
