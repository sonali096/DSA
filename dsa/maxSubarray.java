public class maxSubarray {
    public int maxSubarray(int A, int B, int[] C) {
        int maxSum = 0;
        for (int i=0; i<A; i++) {
            int sum = 0;
            for (int j=i; j<A; j++) {
                sum = sum + C[j];
                if (sum <= B && sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
/*You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B. */