/**'
 * This program will solve the rod cutting problem using an iterative top down approach.
 * This program will write to the console the values of the array, followed by price index
 * of each array. The third line is supposed to be the optimal size i of the first piece to
 * cut off, but it needs a little more work.
 *
 * @author Luis Cortez
 * @version 0622192300
 *
 */
public class RodCuttingWithCutCost {

    static int bottomUpCutRodAndCutCost(int[] p, int n, int c) {

        // both arrays initialized
        int memoizationArray[] = new int[n + 1];
        int sArray[] = new int[n + 1];

        // iterative top down approach to finding the maximum value
        for (int j = 1; j <= n; j++) {
            int q = -1;
            for (int i = 1; i < j; i++) {

                q = Math.max(q, p[i] + memoizationArray[j - i - 1] - c);
                sArray[i] = j;
            }
            memoizationArray[j] = q;
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n_______________________________");
        for (int i = 0; i <= n; i++) {
            System.out.print(memoizationArray[i] + " ");
        }
        System.out.println("\n_______________________________");
        for (int i = 1; i <= n; i++) {
            System.out.print(sArray[i] + " ");
        }
        System.out.println(" ");

        return memoizationArray[n];

//        while (n > 0) {
//            System.out.println(sArray[n]);
//            n = n - sArray[n];
//
//        }

    }

    /**
     * This method is the driver method for the above function
     * @param args - not used
     */
    public static void main(String[] args) {


        int ppTestArray[] = new int[] { 0, 1, 5, 8, 10, 13, 17, 18, 22, 25, 30 };

        System.out.println("\nMax Revenue Possible is " + bottomUpCutRodAndCutCost(ppTestArray, ppTestArray.length, 0));


    }

}
