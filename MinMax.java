public class MinMax {
    public int solve(int[] A) {
        int n = A.length;
        //FIne Min Max Value
        int minval = A[0], maxval = A[0];
        for(int i = 1; i < n; i++){
            minval = Math.min(minval,A[i]);
            maxval = Math.max(maxval,A[i]);
        }
        if(minval==maxval){
            return 1;
        }
        int min_i = -1, max_i = -1;
        int ans = n;//length
        for(int i = n-1; i >= 0; i--){
            if(A[i] == minval){
                min_i = i;
                if(max_i != -1){
                    int len = max_i - min_i + 1;
                    ans = Math.min(ans,len);
                }
            }else if(A[i] == maxval){
                max_i = i;
                if(min_i != -1){
                    int len = min_i - max_i + 1;
                    ans = Math.min(ans,len);
                }

            }
        }
        return ans;
    }
}

/*Closest MinMax
Solved
character backgroundcharacter
Stuck somewhere?
Use any given hint and get it resolved
Use Hint.
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [2, 6, 1, 6, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:

 Take the last 3 elements of the array. */
