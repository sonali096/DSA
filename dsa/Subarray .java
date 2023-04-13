public class Subarray  {
    public int[] solve(int[] A, int B, int C) {
        int n = A.length;
        int s = B;
        int e = C;
        int len = e - s + 1;
        int ans[] = new int[len];
        for(int i = 0 ; i < len; i++){
            if(s<=e){
                ans[i] = A[s];
            }
            s++;
        }
        return ans;
    }
}
/*Given an array A of length N, return the subarray from B to C.


Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109

0 <= B <= C < N



Input Format
The first argument A is an array of integers

The remaining argument B and C are integers.



Output Format
Return a subarray


Example Input
Input 1:
A = [4, 3, 2, 6]
B = 1
C = 3
Input 2:

A = [4, 2, 2]
B = 0
C = 1


Example Output
Output 1:
[3, 2, 6]
Output 2:

[4, 2] */