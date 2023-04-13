public class AG {
    public long solve(String A) {
        int n = A.length();
        int c = 0;
        long ans = 0;
        for(int i = n-1; i <= 0; i--){
            //char c = A.charAt(i);
            if(A.charAt(i) == 'A' ){
                ans = ans + c;
            }else if(A.charAt(i) == 'G'){
                c++;
            }
        }
        return ans;
    }
}
