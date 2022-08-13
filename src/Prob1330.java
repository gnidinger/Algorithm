import java.util.Scanner;

public class Prob1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // 삼항 연산자 이중으로 쓰기
        System.out.println((a>b) ? ">" : ((a<b) ? "<" : "==" ));
        }
}
