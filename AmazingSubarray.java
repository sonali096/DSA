public class AmazingSubarray {
    public int solve(String S) {
        int n = S.length();
        S = S.toUpperCase();
        int cntVowels = 0;
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (S.charAt(i) == 'A' || S.charAt(i) == 'E' || S.charAt(i) == 'I' || S.charAt(i) == 'O' || S.charAt(i) == 'U'){
                cntVowels++;
                ans = (ans % 10003 + cntVowels % 10003) %10003;
            } else {
                ans = (ans % 10003 + cntVowels % 10003) %10003;
            }
        }
        return ans;
    }
}
/*You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints

1 <= length(S) <= 1e6
S can have special characters */