import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ashuwp
 */
public class WGHTNUM {

  private static final BigInteger MOD = BigInteger.valueOf(1000000007L);

  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int tc = Integer.parseInt(scan.nextLine());
    StringBuilder ans = new StringBuilder(123456);
    for (int t = 0; t < tc; t++) {
      long N = scan.nextLong();
      int W = scan.nextInt();
      BigInteger r = BigInteger.ZERO;
      if (W == 0) {
        r = BigInteger.valueOf(9);
      } else if (W > 0 && W < 9) {
        r = BigInteger.valueOf(9 - W);
      } else if (W > -10 && W < 0) {
        r = BigInteger.valueOf(9 + 1 + W);
      }
      ans = ans.append(r.multiply(BigInteger.TEN.modPow(BigInteger.valueOf(N - 2), MOD)).mod(MOD)).append('\n');
    }
    System.out.print(ans);
  }
}
