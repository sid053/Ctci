public class Array {

    public static void main(String[] args) {
        System.out.println("Arrays problems");

    }

        public static int removeDuplicates ( int[] nums){
            int count = 0;
            int prev = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > prev) {
                    count++;
                    prev = nums[i];
                    nums[count] = nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
            return ++count;
        }    //remove duplicates from an array without using arbritrary array

        public static int[] mergeSort ( int[] arr, int low, int high){
            if (low == high) {
                int[] temp = new int[1];
                temp[0] = arr[low];
                return temp;
            }
            int[] left = mergeSort(arr, low, low + (high - low) / 2);
            int[] right = mergeSort(arr, low + (high - low) / 2 + 1, high);
            int[] sortedArray = sort(left, right);
            return sortedArray;
        }    // merge sort

        public static int[] sort ( int[] left, int[] right){
            int[] sorted = new int[left.length + right.length];
            int l = 0;
            int r = 0;
            if (left.length == 0) {
                return right;
            }
            if (right.length == 0) {
                return left;
            }

            for (int i = 0; i < sorted.length; i++) {
                if (left[l] > right[r]) {
                    sorted[i] = right[r];
                    r++;
                    if (r == right.length) {
                        i++;
                        for (int j = i; j < sorted.length; j++) {
                            sorted[j] = left[l];
                            l++;
                        }
                        i = sorted.length;
                    }
                } else {
                    sorted[i] = left[l];
                    l++;
                    if (l == left.length) {
                        i++;
                        for (int j = i; j < sorted.length; j++) {
                            sorted[j] = right[r];
                            r++;
                        }
                        i = sorted.length;
                    }
                }
            }
            return sorted;

        }   // helper for merge sort

        public static int lengthOfLIS(int[] nums) {
            int max = 1;
            int [] arr  = new int [nums.length];
               for(int i = 0 ; i < nums.length ; i++){
                   arr[i]=1;
                   for(int j = 0  ; j < i ; j++ ){
                       if(nums[j]<nums[i]){
                           if(arr[i] <= arr[j]){
                               arr[i]=arr[j]+1;
                           }
                       }
                   }
                   if(max < arr[i]){
                       max = arr[i];
                   }
               }
            return max;
        }   // longest increasing subsequence

}
