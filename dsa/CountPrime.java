public class CountPrime {
    public int factor(int A) {
        int fact = 0;
        for(int i = 1; i * i <= A; i++){
            if(A%i == 0){
                if(i*i == A){
                    fact++;
                }else{
                    fact = fact+2;
                }
            }
        }
        return fact;
    }
    public int solve(int A) {
        int count = 0;
        for(int i = 2; i <= A; i++){
            int cnt = factor(i);
            if (cnt == 2){
                count++;
            }
        }
        return count;
    }
}