package Array;

import java.util.ArrayList;
import java.util.HashMap;

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
                arr[i]=arr[j];
                i++;
            }
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
     void union(int[] arr1, int m, int[] arr2, int n) {
            ArrayList<Integer> arr = new ArrayList<>();
            int i = 0, j = 0;
            // Main loop
            while (i < m && j < n) {
                int val;
                if (arr1[i] < arr2[j]) {
                    val = arr1[i];
                    i++;
                }
                else if (arr1[i] > arr2[j]) {
                    val = arr2[j];
                    j++;
                }
                else {
                    val = arr1[i];
                    i++;
                    j++;
                }
                // Add only if not duplicate
                if (arr.isEmpty() || arr.get(arr.size() - 1) != val) {
                    arr.add(val);
                }
            }
            // Remaining elements of arr1
            while (i < m) {
                if (arr.isEmpty() || arr.get(arr.size() - 1) != arr1[i]) {
                    arr.add(arr1[i]);
                }
                i++;
            }
            // Remaining elements of arr2
            while (j < n) {
                if (arr.isEmpty() || arr.get(arr.size() - 1) != arr2[j]) {
                    arr.add(arr2[j]);
                }
                j++;
            }
            // Print result (optional)
            System.out.println(arr);
        }
     int missingNo(int[] arr){
        int n = arr.length;
        int sum = 0;
        int netSum =(n*(n+1))/2;
         for (int i = 0; i < arr.length; i++) {
             sum+=arr[i];
         }
         return netSum-sum;
     }

    int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
    int findMaxConsecutiveOnesAlter(int[] arr) {
        int maxCount=0;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                if (maxCount<count){
                    maxCount=count;
                }
                count=0;
            }
            else {
                count++;
                if (maxCount<count) maxCount=count;

            }
        }
        return maxCount;
    }

    int singleNumberWithHashMap(int[] arr) {
        int singleFreq=-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int el : arr){
            map.put(el, map.getOrDefault(el,0)+1);
        }
        for (int key: map.keySet()){
            if (map.get(key)==1)singleFreq= key;
        }
        return singleFreq;
    }
    int singleNumber(int[] arr) {
        int ans = 0;
        for (int el : arr) {
            ans = ans ^ el;
        }
        return ans;
    }
//
//    int longestSubarray(int[] arr, int k) {
//
//    }

    public static void main(String[] args) {
        System.out.println();
    }
}
