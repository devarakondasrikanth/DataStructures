package com.srikanth.ds.linkedlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.srikanth.sort.Sorting;

public class Test {

	private static final Log log = LogFactory.getLog(Test.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArray = new int[369];
		int[] testArrayResult = new int[369];
		int[] testArrayResultNew = new int[369];
		for(int i=0;i<testArray.length;i++)
		{
			testArray[i] = (int)(Math.random() * 101);
		}
		
		
		System.out.println("####################################");
		testArrayResult = Sort.mergeSort(testArray);
		
		for(int i=0;i<testArrayResult.length;i++)
		{
			System.out.println(testArrayResult[i]);
		}
		System.out.println("####################################");
		Sorting srt = new Sorting();
		
		testArrayResultNew = srt.mergeSort(testArray);
		for(int i=0;i<testArrayResultNew.length;i++)
		{
			System.out.println(testArrayResultNew[i]);
		}
		System.out.println("####################################");
		
		int[] a = {1,2,3,4,5,6,7,8,9,16};
		int[] b = {3,7,3,2,11,12,13,14,15,16,17,1,2,3,4,5,6,7,8,9,10};
		int aLength = a.length;
		int bLength = b.length;
		int[] c = new int[aLength+bLength];
			
		for(int i=0;i<aLength;i++){
			c[i] = a[i];
		}
		
		for(int j=0;j<bLength;j++){
			c[j+aLength]=b[j];
		}
		
		int[] resultArray = removeDuplicates(c);
		for(int z =0;z<resultArray.length;z++)
		{
			System.out.println(resultArray[z]);
		}
		System.out.println("####################################");
		
		int[] intersectionArray = intersection(a,b);
		for(int k =0;k<intersectionArray.length;k++)
		{
			System.out.println(intersectionArray[k]);
		}
		System.out.println("####################################");
		
		if(isNumber("12"))
			System.out.println("Entered input is number");
		else
			System.out.println("Entered input is not a number");
		
		StringBuffer str =new StringBuffer("welcome to Ansible Automation");		
		//System.out.println(str.reverse());		
        
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(i<str.length()){
        	if((str.charAt(i)!= ' ')&& str.charAt(i) !='\t'){
        		sb.append(str.charAt(i));
        	}
        	i++;
        }
        System.out.println(sb);
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char temp;
        int tempInt;
        i=0;
        while(i<str.length()){
        	temp = str.charAt(i);
        	if(map.containsKey(temp))
        	{
        		tempInt = map.get(temp);
        		map.remove(temp);
        		map.put(temp, ++tempInt);
        	}else{
        		map.put(temp, 1);
        	}
        	i++;
        }
        
        //printing the map
        for(char strKey:map.keySet()){
        	System.out.println(strKey+"---->"+map.get(strKey));
        }
        
        int[] z ={1,2,3,4,5,7,8,9,10};
        int zLength = z.length;
        int total = 0;
        for(int kz : z){
        	total = total+kz;
        }
        int actualTotal = z[zLength-1];
        actualTotal = (actualTotal*(actualTotal+1))/2;
        System.out.println("Missing number is "+ (actualTotal - total));
        
	}
	
	
	public static int[] removeDuplicates(int[] array){
		int arrayLength = array.length;
		if(arrayLength ==1){
			return array;
		}
		int midPoint = arrayLength/2;
		int[] left = new int[midPoint];
		int[] right = new int[arrayLength - midPoint];
		for(int lIndex =0;lIndex<midPoint;lIndex++){
			left[lIndex] = array[lIndex];
		}
		for(int rIndex =0;rIndex<arrayLength-midPoint;rIndex++){
			right[rIndex] = array[rIndex+midPoint];
		}
		left = removeDuplicates(left);
		right = removeDuplicates(right);
		return merge(left,right);
	}
	
	public static int[] merge(int[] left,int[] right){
		List<Integer> list = new ArrayList<Integer>();
		int lIndex =0;
		int rIndex =0;
		while(lIndex<left.length && rIndex<right.length){
			if(left[lIndex]<right[rIndex]){
				list.add(left[lIndex++]);
			}else if(left[lIndex] == right[rIndex]){
				list.add(left[lIndex++]);
				rIndex++;
			}else{
				list.add(right[rIndex++]);
			}
		}
		
		while(lIndex<left.length){
			list.add(left[lIndex++]);
		}
		while(rIndex<right.length){
			list.add(right[rIndex++]);
		}
		
		int[] result = new int[list.size()];
		int resultIndex =0;
		for(int i:list){
			result[resultIndex++] = i;
		}
		return result;
	}
	
	public static int[] intersection(int[] a,int[] b){
		int aLength = a.length;
		int bLength = b.length;
		int[] c = new int[aLength+bLength];
		
		for(int i=0;i<aLength;i++){
			c[i] = a[i];
		}
		
		for(int j=0;j<bLength;j++){
			c[j+aLength]=b[j];
		}
		
		return commonElements(c);
		
	}
	public static int[] commonElements(int[] array){
		int arrayLength = array.length;
		if(arrayLength ==1){
			return array;
		}
		int midPoint = arrayLength/2;
		int[] left = new int[midPoint];
		int[] right = new int[arrayLength - midPoint];
		for(int lIndex =0;lIndex<midPoint;lIndex++){
			left[lIndex] = array[lIndex];
		}
		for(int rIndex =0;rIndex<arrayLength-midPoint;rIndex++){
			right[rIndex] = array[rIndex+midPoint];
		}
		left = removeDuplicates(left);
		right = removeDuplicates(right);
		return mergeCommonElements(left,right);
	}
	
	public static int[] mergeCommonElements(int[] left,int[] right){
		List<Integer> list = new ArrayList<Integer>();
		int lIndex =0;
		int rIndex =0;
		while(lIndex<left.length && rIndex<right.length){
			if(left[lIndex]<right[rIndex]){
				lIndex++;
			}else if(left[lIndex] == right[rIndex]){
				list.add(left[lIndex++]);
				rIndex++;
			}else{
				rIndex++;
			}
		}
		
		while(lIndex<left.length){
			lIndex++;
		}
		while(rIndex<right.length){
			rIndex++;
		}
		
		int[] result = new int[list.size()];
		int resultIndex =0;
		for(int i:list){
			result[resultIndex++] = i;
		}
		return result;
	}
	
	public static boolean isNumber(String str){
		
		try{
			Integer.parseInt(str);
			return true;
		}catch(Exception e){
			log.info("Input is not a integer");
		}
		
		try{
			Double.parseDouble(str);
			return true;
		}catch(Exception e){
			log.info("Input is not a double");
		}
		
		try{
			Float.parseFloat(str);
			return true;
		}catch(Exception e){
			log.info("Input is not a Float");
		}
		
		try{
			Long.parseLong(str);
			return true;
		}catch(Exception e){
			log.info("Input is not a Long");
		}
		
		return false;
	}

}
