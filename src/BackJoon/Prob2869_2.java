package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2869_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int x = (int) (Math.ceil((v - a) / (a - b)) + 1);

        System.out.println(x);
    }
}