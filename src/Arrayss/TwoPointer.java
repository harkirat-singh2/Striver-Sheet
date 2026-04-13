package Arrayss;

import java.util.*;

public class TwoPointer {

    public int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == target) {
                res[0] = start + 1; // 1-based index
                res[1] = end + 1;
                return res;
            }
            else if (sum < target) {
                start++;   // increase sum
            }
            else {
                end--;     // decrease sum
            }
        }

        return res; // (though problem guarantees solution)
    }

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Optimization: if current number > 0, no need to continue
            if (arr[i] > 0) break;

            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                int total = arr[i] + arr[start] + arr[end];

                if (total == 0) {
                    res.add(Arrays.asList(arr[i], arr[start], arr[end]));

                    start++;
                    end--;

                    // Skip duplicates for start
                    while (start < end && arr[start] == arr[start - 1]) start++;

                    // Skip duplicates for end
                    while (start < end && arr[end] == arr[end + 1]) end--;
                }
                else if (total < 0) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }

        return res;
    }

    public void sortColors(int[] arr) {
        int n = arr.length;
        int low =0;
        int mid = 0;
        int high=n-1;
        while (mid <= high) {
            // your conditions and swaps here
            if(arr[mid]==0){
                int temp =arr[mid];
                arr[mid]=arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if (arr[mid]==2){
                int temp =arr[mid];
                arr[mid]=arr[high];
                arr[high] = temp;
                high--;
            }
            else{mid++;}
        }
    }

    public static void main(String[] args) {

    }
}
