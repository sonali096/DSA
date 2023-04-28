public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;
        int mx = -1;
        for(int i = 0 ; i < n ; i++){
            mx = Math.max(mx, A[i]);
        }
        int[] freq = new int[mx + 1];
        for(int i = 0 ; i < n ; i++){
            freq[A[i]] += 1;
        }
        int k = 0;
        for(int i = 0 ; i <= mx ; i++){
            for(int j = 0 ; j < freq[i] ; j++){
                A[k] = i;
                k++;
            }
        }
        return A;
    }
}

//We will keep the count of frequency of each of the
// elements of the array using a frequency array. Then
// we will move from 1 to size of the the frequency array
// and insert them in our final sorted array.

// Time Complexity : O(N + K)
// Space Complexity : O(K)
// where N is the size and K is the maximum 
// value of the given array
// Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.


// Problem Constraints
// 1 <= |A| <= 105
// 1 <= A[i] <= 105


// Input Format
// The first argument is an integer array A.


// Output Format
// Return an integer array that is the sorted array A.


// Example Input
// Input 1:
// A = [1, 3, 1]
// Input 2:
// A = [4, 2, 1, 3]


// Example Output
// Output 1:
// [1, 1, 3]
// Output 2:
// [1, 2, 3, 4]


// Example Explanation
// For Input 1:
// The array in sorted order is [1, 1, 3].
// For Input 2:
// The array in sorted order is [1, 2, 3, 4].