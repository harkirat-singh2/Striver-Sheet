package Arrayss;

import java.util.*;

public class ArrayUtils {

    // 🔹 Largest Element
    int largestEl(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int el : arr) {
            if (el > max) max = el;
        }
        return max;
    }

    // 🔹 Second Largest Element
    int secondLargestEl(int[] arr) {
        int largest = largestEl(arr);
        int secondLargest = Integer.MIN_VALUE;

        for (int el : arr) {
            if (el != largest && el > secondLargest) {
                secondLargest = el;
            }
        }
        return secondLargest;
    }

    // 🔹 Check if Sorted and Rotated
    boolean isSortedAndRotated(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
                if (count > 1) return false;
            }
        }
        return true;
    }

    // 🔹 Remove Duplicates (Sorted Array) - In Place
    int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    // 🔹 Remove Duplicates using ArrayList
    ArrayList<Integer> removeDuplicatesWithArrayList(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr.length == 0) return result;

        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    // 🔹 Reverse Helper
    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 🔹 Rotate Right by K
    void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    // 🔹 Move Zeroes to End
    void moveZeroesToEnd(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    // 🔹 Linear Search
    int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // 🔹 Merge Sorted Arrays (Leetcode style)
    void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
    }

    // 🔹 Union of Sorted Arrays
    ArrayList<Integer> union(int[] arr1, int m, int[] arr2, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            int val;

            if (arr1[i] < arr2[j]) val = arr1[i++];
            else if (arr1[i] > arr2[j]) val = arr2[j++];
            else {
                val = arr1[i];
                i++;
                j++;
            }

            if (result.isEmpty() || result.get(result.size() - 1) != val) {
                result.add(val);
            }
        }

        while (i < m) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }

        while (j < n) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }

        return result;
    }

    // 🔹 Missing Number (0 to n)
    int missingNo(int[] arr) {
        int n = arr.length;
        int expected = (n * (n + 1)) / 2;

        int actual = 0;
        for (int el : arr) actual += el;

        return expected - actual;
    }

    // 🔹 Max Consecutive Ones
    int findMaxConsecutiveOnes(int[] arr) {
        int max = 0, count = 0;

        for (int el : arr) {
            if (el == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    // 🔹 Single Number (XOR)
    int singleNumber(int[] arr) {
        int ans = 0;
        for (int el : arr) {
            ans ^= el;
        }
        return ans;
    }

    // 🔹 Longest Subarray with Sum K (Brute)
    int longestSubarray(int[] arr, int k) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    // 🔹 Longest Subarray with Sum K (Optimal)
    int longestSubarrayPrefixSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                maxLength = i + 1;
            }

            if (map.containsKey(prefixSum - k)) {
                int len = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, len);
            }

            map.putIfAbsent(prefixSum, i);
        }
        return maxLength;
    }

    // 🔹 Number of  Subarray with Sum K (Optimal)
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1); // important
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 🔹 Longest SubString without repeating characters (Optimal)
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public int lengthOfLongestSubstringPractice(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen=0;
        int left=0;
        for (int right = 0;  right <s.length() ; right++) {
            char ch =s.charAt(right);
            if (map.containsKey(ch)){
                left=Math.max(left,map.get(ch)+1);
            }
            map.put(ch,right);
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println("Array Utils Ready 🚀");
    }
}