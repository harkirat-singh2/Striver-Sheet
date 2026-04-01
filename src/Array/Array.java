package Array;

public class Array {
    int largestEl(int[] arr){
        int minVal = Integer.MIN_VALUE;
        for (int el:arr){
            if (el>minVal) minVal = el;
        }
        return minVal;
    }
    int secondLargestEl(int[] arr){
        int largest = largestEl(arr);
        int minVal = Integer.MIN_VALUE;
        for (int el:arr){
            if (el!=largest || el>minVal) minVal = el;
        }
        return minVal;
    }
    boolean isSorted(int[] arr){
        for (int i = 0;i<arr.length;i++){
            if (arr[i]>arr[i+1]) return false;
        }return true;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}
