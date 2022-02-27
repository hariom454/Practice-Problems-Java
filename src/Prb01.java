import java.util.Scanner;

/***************
 **   @author: Hariom Singh
 **  Date: 02/02/22
 *****************/
public class Prb01 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while( t --> 0)
        {
            int n= in.nextInt();
            System.out.println( isPrime(n) ? "yes" : "no");
        }
    }

    private static boolean isPrime(int n) {

        if( n <= 1)
        {
            return false;
        }
        for(long i = 2; i * i <= n; i ++)
        {
            if( n % i == 0)
                return false;
        }
        return true;
    }
}
