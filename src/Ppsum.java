import java.util.Scanner;

/***************
 **   @author: Hariom Singh
 **  Date: 02/02/22
 *****************/
public class Ppsum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while( t--> 0)
        {
            int d, n;
            d = in.nextInt();
            n = in.nextInt();

            int ans = getSum(d, n);
            System.out.println(ans);
        }
    }

    private static int getSum(int d, int n) {

        for(int i = 0; i < d; i ++)
        {
            int  temp = n;
            temp *= (n+1);
            temp /= 2;
            n = temp;
        }
        return n;
    }
}
