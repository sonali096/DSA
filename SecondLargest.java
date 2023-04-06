/*You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


Problem Constraints
1 <= |A| <= 105

0 <= A[i] <= 109



Input Format
The first argument is an integer array A.



Output Format
Return the second largest element. If no such element exist then return -1.



Example Input
Input 1:

 A = [2, 1, 2] 
Input 2:

 A = [2]


Example Output
Output 1:

 1 
Output 2:

 -1  */
public class SecondLargest {
    public int solve(int[] A) {
        int max = 0, max_sec = 0;
        int n = A.length;
        for(int i = 0; i < n;i++){
            if(A[i] > max && max > max_sec){
                max_sec = max;
                max = A[i];
            }else if(A[i] > max){
                max = A[i];
            }else if(A[i] > max_sec && A[i] != max){
                max_sec = A[i];
            }
        }
        if (max_sec > 0){
            return max_sec;
        }
        return -1;
    }
}