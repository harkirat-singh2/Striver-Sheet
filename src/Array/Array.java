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
    boolean isSortedAndRotated(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0;i<arr.length;i++){
            if (arr[i] > arr[(i+1) % n]) {
                count++;
                if (count>1)return false;
            }
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
    void rotateArray(int[] arr,int start, int end){
        while (start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    void rotateRight(int[] arr , int k){
        int n = arr.length;
        k=k%n;
        rotateArray(arr,0,n-1);
        rotateArray(arr,0,k-1);
        rotateArray(arr,k,n-1);

    }
    void moveZeroesToEnd(int[] arr){
        int j= 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0) {
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }
    
    int linearSearch(int[] arr , int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

     void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m-1;
        int j= n-1;
        int k = m+n-1;

        while (i>=0 && j>=0){
            if (arr2[j]>arr1[i]) {
                arr1[k] = arr2[j];
                j--;
                k--;
            }
            else {
                arr1[k] = arr1[i];
                i--;
                k--;
            }
        }
         while (j>=0) {
             arr1[k] = arr2[j];
             j--;
             k--;
         }
    }


    public static void main(String[] args) {
        System.out.println();
    }
}
