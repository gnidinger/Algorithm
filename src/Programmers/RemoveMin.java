package Programmers;

import java.util.Arrays;

class RemoveMin {
    public int[] solution(int[] arr) {
        int[] answer = {};

        if (arr.length == 1) answer = new int[]{-1};

        else {
            int min = Arrays.stream(arr)
                    .min().getAsInt();

            answer = Arrays.stream(arr)
                    .filter(a -> a != min)
                    .toArray();
        }

        return answer;
    }
}