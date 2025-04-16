class Operation {

    void Selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //arr.length ensures that by the time we run i till the last element, the last element is already sorted
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }
}

class SelectionSort {
    public static void main(String[] args) {
        int[] arr= {3,6,5,2,1,8,9};
        Operation op= new Operation();
        op.Selection(arr);
        for (int i: arr){
            System.out.println(i + ",");
        }
    }
}