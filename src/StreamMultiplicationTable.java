
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class StreamMultiplicationTable {
    public static void main(String[] args) {

//        for(int i = 2; i < 10; i++) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = 1; j < 10; j++) {
//                list.add(i * j);
//            }
//            System.out.println(i + " Times Table = " + list);
//        }

        IntStream.rangeClosed(2, 9)
                .mapToObj(a -> IntStream.rangeClosed(1, 9)
                        .map(b -> a * b)
                        .boxed()
                        .collect(toList()))
                .forEach(a -> System.out.println(a.get(0) + " Times Table = " + a));
    }
}
