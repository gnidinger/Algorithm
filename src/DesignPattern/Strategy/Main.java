package DesignPattern.Strategy;

import java.util.Arrays;

import DesignPattern.Strategy.Context.SortingContext;
import DesignPattern.Strategy.Strategies.BubbleSortStrategy;
import DesignPattern.Strategy.Strategies.QuickSortStrategy;

public class Main {

	public static void main(String[] args) {

		int[] arr = {4, 16, 31, 5, 4, 17, 1, 10, 15, 3, 16, 6, 7, 2, 2, 1, 5, 13, 17, 14, 4, 0};

		SortingContext sortingContext = new SortingContext();

		sortingContext.setSortingStrategy(new BubbleSortStrategy());
		sortingContext.doSort(arr);

		System.out.println(Arrays.toString(arr));

		sortingContext.setSortingStrategy(new QuickSortStrategy());
		sortingContext.doSort(arr);

		System.out.println(Arrays.toString(arr));

	}
}
