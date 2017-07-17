package com.srikanth.ds.linkedlist;

import java.util.Arrays;

public class Sort {
	
	
	public static int[] mergeSort(int[] array){
		if(array.length < 2){
			return array;
		}
		int midPoint = array.length/2;
		int[] leftArray = new int[midPoint];
		int[] rightArray = new int[array.length-midPoint];
		//copy elements in to leftArray
		for(int i=0;i<midPoint;i++){
			leftArray[i] = array[i];
		}		
		//copy elements in to rightArray
		for(int j=0;j<rightArray.length;j++){
			rightArray[j] = array[j+midPoint];
		}
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		return merge(leftArray,rightArray);
	}
	
	public static int[] mergeSortJava(int[] array) {
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
	
	public static int[] merge(int[] leftArray,int[] rightArray){		
		int leftCursor = 0;
		int rightCursor = 0;
		int resultCursor =0;
		int leftArraySize =leftArray.length;
		int rightArraySize = rightArray.length;
		int[] resultArray = new int[leftArraySize+rightArraySize];
		while(leftCursor < leftArraySize && rightCursor < rightArraySize){
			if(leftArray[leftCursor]<rightArray[rightCursor]){
				resultArray[resultCursor++] = leftArray[leftCursor++];
			}else{
				resultArray[resultCursor++] = rightArray[rightCursor++];
			}
		}
		
		while(leftCursor < leftArraySize){
			resultArray[resultCursor++] = leftArray[leftCursor++];
		}
		
		while(rightCursor < rightArraySize){
			resultArray[resultCursor++] = rightArray[rightCursor++];
		}
		return resultArray;
	}

}
