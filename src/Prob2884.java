import java.util.Scanner;

public class Prob2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        if(m >= 45) {
            h = h;
            m = m - 45;
        } else if (m < 45) {
            if(h == 0) {
                h = 23;
                m += 15;
            } else {
                h = h - 1;
                m += 15;
            }
        }
        System.out.printf("%d %d", h, m);
//        System.out.print(h);
//        System.out.print(" ");
//        System.out.print(m);
    }
}
