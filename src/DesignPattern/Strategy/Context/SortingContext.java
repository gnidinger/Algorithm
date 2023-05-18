package DesignPattern.Strategy.Context;

import DesignPattern.Strategy.Strategies.SortingStrategy;

public class SortingContext {

	private SortingStrategy sortingStrategy;

	public void setSortingStrategy(SortingStrategy sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}

	public void doSort(int[] arr) {
		sortingStrategy.sort(arr);
	}
}
