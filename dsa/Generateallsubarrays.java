public class Generateallsubarrays {
    public int[][] solve(int[] A) {
        int n = A.length;
        int ans[][] = new int[n*(n+1)/2][];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                ans[i][j] = A[j];
            }
        }
        return ans;
        
    }
}
/*You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array


Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105


Input Format
First argument A is an array of integers.


Output Format
Return a 2D array of integers


Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]


Example Output
Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ] */