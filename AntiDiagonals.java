public class AntiDiagonals {
    public int[][] diagonal(int[][] A) {
        int n = A.length;   //length of the input Array
        int[][] ans = new int[2*n-1][n];    //defination of Ans Array

        for (int col=0; col<n; col++) { //iterating the columns as 1st element of each diagonal start from 0th row.
            int i=0;    //row iteration variable
            int j=col;  //col iteration variable
            while (i<n && j>=0) {   //OutOfBound conidtion checking
                ans[col][i] = A[i][j];      
                i++;
                j--;
            }
        }
        for (int row=1; row<n; row++) { //iterating the row as 1st element of each diagonal start from n-1 col.
            int i=row;
            int j=n-1;
            while (i<n && j>=0) {
                ans[i+j][i-row] = A[i][j];
                i++;
                j--;
            }
        }
        return ans;
    }
}
