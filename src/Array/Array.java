package Array;

import java.util.ArrayList;

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
        }
        return true;
    }
    int removeDuplicates(int[] arr){
        if(arr.length==0) return 0;
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!=arr[j]) {
                i++;
                arr[i]=arr[j];}
        }
        return i+1;
    }
    ArrayList<Integer> removeDuplicatesWithArrayList(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        if(arr.length==0) return al;
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!=arr[j]) {
                i++;
                arr[i]=arr[j];}
        }
        return al;
    }

    void rotateArray(int[] arr){
        int i = 0;
        int j= arr.length-1;
        while (i<j){
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
