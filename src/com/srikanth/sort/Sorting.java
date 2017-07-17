package com.srikanth.sort;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
	public int[] mergeSort(int[] array){
		if(array.length<2){
			return array;
		}
		int midPoint = array.length/2;
		int[] leftArray = new int[midPoint];
		int[] rightArray = new int[array.length - midPoint];
		//copy elements into left array
		for(int i=0;i<midPoint;i++){
			leftArray[i] = array[i];
		}
		//copy elements into right array
		for(int j=0;j<array.length-midPoint;j++)
		{
			rightArray[j] = array[j+midPoint];
		}
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		return merge(leftArray,rightArray);
	}
	public int[] merge(int[] leftArray,int[] rightArray){
		int[] resultArray = new int[leftArray.length+rightArray.length];
		int leftCursor = 0;
		int rightCursor = 0;
		int resultCursor =0;
		while(leftCursor<leftArray.length && rightCursor<rightArray.length){
			if(leftArray[leftCursor]<rightArray[rightCursor]){
				resultArray[resultCursor++] = leftArray[leftCursor++];
			}else{
				resultArray[resultCursor++] = rightArray[rightCursor++];
			}
		}
		while(leftCursor<leftArray.length){
			resultArray[resultCursor++] = leftArray[leftCursor++];
		}
		while(rightCursor<rightArray.length){
			resultArray[resultCursor++] = rightArray[rightCursor++];
		}
		return resultArray;
	}
	
	
}
