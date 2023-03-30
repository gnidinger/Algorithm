package BackJoon;

import java.util.Scanner;

public class Prob8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String arr[] = new String[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < arr.length; i++) {
            int result = 0;
            int count = 0;

            for (int j = 0; j < arr[i].length(); j++) {

                if (arr[i].charAt(j) == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                result += count;
            }
            System.out.println(result);
        }
    }
}
