import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author ashuwp
 */
class Solution {
 
  private static final double PREC = 0.001f;
 
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
 
    int tc = Integer.parseInt(scan.nextLine());
    for (int t = 0; t < tc; t++) {
      double[] T = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
      double[] V = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
      double[] D = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
      double[] P = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
      double[] C = Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
 
      int N = (int) T[0];
      double res = T[2] / T[1], ans = 0.0;
 
      for (int i = 0; i < N; i++) {
        if (D[i] != 1) {
          P[i] -= ans * V[i];
          if (P[i] <= 0) {
            if (C[i] + P[i] > -PREC) {
              ans += (C[i] + P[i] + PREC) / V[i];
            }
          } else if (P[i] - res * V[i] < PREC) {
            ans += (C[i] + P[i] + PREC) / V[i];
          }
        } else {
          P[i] += ans * V[i];
          if (P[i] <= 0) {
            if (P[i] + res * V[i] > -PREC) {
              ans += (C[i] - P[i] + PREC) / V[i];
            }
          } else if (P[i] - C[i] < PREC) {
            ans += (C[i] - P[i] + PREC) / V[i];
          }
        }
        ans += res;
      }
      System.out.printf("%.3f\n", ans);
    }
  }
}
