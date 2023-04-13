public class RowtoColumnZero {
    public int[][] solve(int[][] A) {
        int[][] out=new int[A.length][A[0].length];
        int n=A.length;
        int m=A[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                out[i][j]=A[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j]==0){
                    for(int col=0;col<m;col++){
                        out[i][col]=0;
                    }
                    for(int row=0;row<n;row++){
                        out[row][j]=0;
                    }
                }
            }
        }
        return out;
    }
}
