package com.kobold.listutils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ListUtils {

	public static List<List<Object>> getPartitional(List<?> list, int size) {
		List<List<Object>> results = new ArrayList<>();
		int j = 0;
		List<Object> tempList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == size * j) {
				if (i != 0)
					results.add(tempList);
				tempList = new ArrayList<>();
				j++;
			}
			tempList.add(list.get(i));
		}
		results.add(tempList);
		return results;
	}

	/**
	 * find the min number by used max heap with PriorityQueue
	 * @param numbers the data source
	 * @param k the size you want to find
	 * @return a list you want
	 */
	public static List<Integer> getMinKNumber(int[] numbers, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		var length = numbers.length;
		if (k > length || k == 0) return result;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
		for (int i = 0; i < length; i++) {
			if (maxHeap.size() != k) {
				maxHeap.offer(numbers[i]);
			} else if (maxHeap.peek() > numbers[i]) {
				maxHeap.poll();
				maxHeap.offer(numbers[i]);
			}
		}
		for (Integer integer : maxHeap) {
			result.add(integer);
		}
		return result;

	}

	/**
	 * the min heap to find the max k number with  PriorityQueue ,
	 * it is so simple to write and use
	 * good lucky
	 * @param numbers the source you want to use
	 * @param k the size of number you want to find
	 * @return a list with you want
	 */
	public static List<Integer> getMaxKNumber(int[] numbers, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		int length = numbers.length;
		if (k > length || k == 0) return result;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
		for (int i = 0; i < length; i++) {
			if (maxHeap.size() != k) {
				maxHeap.offer(numbers[i]);
			} else if (maxHeap.peek() < numbers[i]) {
				maxHeap.poll();
				maxHeap.offer(numbers[i]);
			}
		}
		for (Integer integer : maxHeap) {
			result.add(integer);
		}
		return result;

	}

}
