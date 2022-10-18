package Solution;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.cuttingRope(10));
    }
    int cuttingRope(int n){
        int model = 1000000007;
        long result = 1;
        if (n<=3) return n-1;
        int remain = n%3;
        while (n>4){
            result *= 3;
            result %= model;
            n -=3;
        }
        return (int) (result*n %model);
    }
}

