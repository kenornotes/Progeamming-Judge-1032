import java.util.Scanner;
public class Combination {
    static int weight,result = 0; //result 紀錄是否有解，為 0 則無解，為 1 則有解
    static int[] s;
    public static void comb(int[] s, int m, int n, int pos, int got) {
        int i, tmp, sum;
        if (n == got) {
            sum = 0;
            for (i = 0; i < n; i++) {
                sum = sum + s[i];
            }
            if(weight == sum) {
                for (i = 0; i < n; i++) {
                    System.out.print(s[i] + " ");
                }
                result = 1;
                System.out.println();
            }
            return;
        }
        for (i = pos; i < m; i++) {
            // swap solution
            tmp = s[i];
            s[i] = s[got];
            s[got] = tmp;
            comb(s, m , n, i + 1, got + 1);
            tmp = s[i];
            s[i] = s[got];
            s[got] = tmp;
        }

    }

    public static void main(String[] argv) {
        int m, n, i, tmp, sum = 0;
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        s = new int[m];
        if(m > 0) {
            int liststatus = 0;
            for(i = 0; i < m; i++) {
                tmp = input.nextInt();
                if(tmp > 0) {
                    s[i] = tmp;
                    sum = sum + tmp;
                } else {
                    liststatus = 1;
                    break;
                }
            }
            if(liststatus == 0) {
                n = input.nextInt();
                weight = n;
                if(n > sum) {
                    System.out.println("error");
                } else {
                    for(i = 1; i <= m; i++) {
                        comb(s, m, i, 0, 0);
                    }
                }
            } else {
                System.out.println("error");
            }
            if(result == 0) {
                System.out.println("無組合");
            }
        }
    }
}
