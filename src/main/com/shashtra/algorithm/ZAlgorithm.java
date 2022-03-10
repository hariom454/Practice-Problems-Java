package com.shashtra.algorithm;

/***************
 **   @author: Hariom Singh
 **  Date: 09/03/22
 *****************/
public class ZAlgorithm {
    String inputString;
    private int inputLen;

    public ZAlgorithm(String inputString) {
        this.inputString = inputString;
        inputLen = inputString.length();
    }

    int[] calculateZ() {
        int z[] = new int[inputLen];
        int l = 0, r = 0;
        z[0] = 0;
        for (int i = 1; i < inputLen; i++) {
            if (i > r) {
                l = r = i;
                while (r < inputLen && (inputString.charAt(r) == inputString.charAt(r - l))) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l; //offset
                if (z[k] < r - i + 1)
                    z[i] = z[k];
                else {
                    l = i;
                    while (r < inputLen && (inputString.charAt(r) == inputString.charAt(r - l)))
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
    }

    public static void main(String[] args) {

        //Scanner in = new Scanner(System.in);
        //String inputString = in.next();
        String inputString = "abcabcab";
        ZAlgorithm zalgo = new ZAlgorithm(inputString);

        int ans[] = new int[inputString.length()];
        ans = zalgo.calculateZ();

        for (int i = 0; i < inputString.length(); i++)
            System.out.printf("%d ", ans[i]);
        System.out.println();
    }
}
