import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ashuwp
 */
public class AVGPR {

  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int tc = Integer.parseInt(scan.nextLine());
    for (int t = 0; t < tc; t++) {
      int n = scan.nextInt();
      
      long arr[] = new long[2048 + 16];
      HashSet<Integer> dp = new HashSet<>(n + 1);
      
      for (int i = 0; i < n; i++) {
        int x = scan.nextInt();
        x += 1024;
        arr[x]++;
        dp.add(x << 1);
      }
      
      long ans = 0L;
      for (int i = 0; i <= 2048; i++) {
        for (int j = i + 1; j <= 2048; j++) {
          if (dp.contains(i + j)) {
            ans += arr[i] * arr[j];
          }
        }
        if (dp.contains(i << 1)) {
          ans += arr[i] * (arr[i] - 1) >> 1L;
        }
      }
      System.out.println(ans);
    }
  }
}
