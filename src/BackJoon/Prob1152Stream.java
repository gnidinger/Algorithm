package BackJoon;

import java.util.Scanner;

public class Prob1152Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().strip();

        if(str.length() == 0) System.out.println(0);

        else {
            System.out.println(str.split(" ").length);
        }
    }
}




//    Scanner sc = new Scanner(System.in);
//
//    String str = sc.nextLine().trim();
//
//        if(str.length() == 0) System.out.println(0);
//
//                else {
//                List<String> list = new ArrayList<>();
//
//        list.add(str);
//
//        Long result = list.stream()
//        .flatMap(a -> Arrays.stream(a.split(" ")))
//        .count();
//
//        System.out.println(result);
//        }