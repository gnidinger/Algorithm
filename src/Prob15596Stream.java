import java.util.Arrays;

public class Prob15596Stream {
    long sum(int[] a) {
        long ans = Arrays.stream(a)
                .mapToLong(Long::valueOf)
                .sum();
        return ans;
    }
}