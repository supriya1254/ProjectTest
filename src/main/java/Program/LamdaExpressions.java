package Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    /*public static PerformOperation is_odd() {
        return n -> (n & 1) == 1;
    }

    public static PerformOperation is_prime() {
        return n -> {
            if (n < 2) {
                return false;
            }
            int sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public static PerformOperation is_palindrome() {
        return n -> {
            String original = Integer.toString(n);
            String reversed = new StringBuilder(Integer.toString(n)).reverse().toString();
            return original.equals(reversed);
        };
    }*/

    public static PerformOperation is_odd(){
        return (int a) -> a % 2 != 0;
    }

    public static PerformOperation is_prime(){
        return (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
    }

    public static PerformOperation is_palindrome(){
        return (int a) ->  Integer.toString(a).equals( new StringBuilder(Integer.toString(a)).reverse().toString() );
    }
}

public class LamdaExpressions {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.is_odd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.is_prime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.is_palindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
