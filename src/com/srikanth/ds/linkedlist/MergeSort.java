package com.srikanth.ds.linkedlist;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] array) {
		if (array.length < 2) {
			return array;
		}
		int left = 0;
		int right = array.length;
		int p = array.length / 2;
		int[] lArray = Arrays.copyOfRange(array, left, p);
		int[] rArray = Arrays.copyOfRange(array, p, right);
		// printArray(lArray); seems ok
		// printArray(rArray); seems ok
		lArray = mergeSort(lArray);
		rArray = mergeSort(rArray);
		return merge(lArray, rArray);
	}

	private static int[] merge(int[] lArray, int[] rArray) {
		/*
		 * System.out.println("Ive got"); printArray(lArray);
		 * printArray(rArray); seems ok
		 */
		int[] result = new int[lArray.length + rArray.length];
		int index = 0;
		int rightIndex = 0;
		int leftIndex = 0;
		while (leftIndex < lArray.length && rightIndex < rArray.length) { // TODO
			if (lArray[leftIndex] < rArray[rightIndex]) {
				result[index] = lArray[leftIndex];

				leftIndex++;
				index++;
				// } else if (lArray[leftIndex] >= rArray[rightIndex]) { // You
				// don't have to check it!!!
			} else {
				System.out.println("2 left index " + leftIndex + " index " + index);
				result[index] = rArray[rightIndex];
				rightIndex++;
				index++;
			}
		}
		while (leftIndex < (lArray.length)) { // TODO
			result[index] = lArray[leftIndex];
			index++;
			leftIndex++;
		}
		while (rightIndex < (rArray.length)) { // TODO
			result[index] = rArray[rightIndex];
			index++;
			rightIndex++;
		}
		System.out.println("Returning ");
		printArray(result);
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 4, 0, -1 , 9, 6, 4, 8, 79, 34, 98, 23, 99};
		printArray(arr);
		arr = mergeSort(arr);
		printArray(arr);
	}
}