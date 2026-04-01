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
        }return true;
    }
    int removeDuplicates(int[] arr){
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!=arr[j]) arr[i]=arr[j];
        }
        return i+1;
    } ArrayList<Integer> removeDuplicatesWithArrayList(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!=arr[j]) al.add(arr[j]);
        }
        return al;
    }



    public static void main(String[] args) {
        System.out.println();
    }
}
