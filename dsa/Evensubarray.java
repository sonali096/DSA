public class Evensubarray {
    public String solve(int[] A) {
        int n = A.length;
        if(n%2!=0){
            return "NO";
        } 
        if(A[0]%2 == 0 && A[n-1]%2 == 0){
            return "YES";
        }
        return "NO";
    }

}
