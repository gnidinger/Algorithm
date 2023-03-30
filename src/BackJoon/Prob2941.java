package BackJoon;

import java.util.Scanner;

public class Prob2941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] cStr = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        String str = sc.next();

        for (int i = 0; i < 8; i++) {
            str = str.replaceAll(cStr[i], "X");
        }

        System.out.println(str.length());
    }
}