import java.util.Scanner;

/***************
 **   @author: Hariom Singh
 **  Date: 02/02/22
 *****************/
public class Remiss {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        //System.out.println(t);

        while( t --> 0)
        {
            int a = in.nextInt(), b = in.nextInt();
            //in.next();

            System.out.printf("%d %d\n", Math.max(a, b), a + b);
        }
    }
}
