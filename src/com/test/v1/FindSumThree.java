package com.test.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindSumThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
		
		//int[][] ints 
//		findSumThree(nums). stream(). map(x -> x. stream(). mapToInt(Integer::System). toArray())
		List<List<Integer>> sumList  =  findSumThree(nums);
		  for (List<Integer> sublist : findThreeSumUsingHahsMap(nums)) {
	            for (Integer num : sublist) {
	                System.out.print(num + " ");
	            }
	            System.out.println(); // New line after each sublist
	        }
		  
		  HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
		  Arrays.sort(nums);
		  for(int i=0;i<nums.length;i++) {
			  hashMap.put(nums[i], i);
		  }
		  
		  System.out.println();
		  
		  System.out.println();
		  
		  
		   for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
	            System.out.println(entry.getKey() + " -> " + entry.getValue());
	        }
	
	}
	
	
	
	private static List<List<Integer>> findSumThree(int[] arr){
		List<List<Integer>> result  = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		Set<Integer> hashset  = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			hashset.add(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			int z = arr[i];
			for(int j=i+1;j<arr.length;j++) {
				List<Integer> target  = new ArrayList<Integer>();
				int y = arr[j];
				int x  = -(y+z);
					if(hashset.contains(x)) {
						target.add(x);
						target.add(y);
						target.add(z);
						result.add(target);
					}
				
			}
		}
		
		return result;
	}
	
	
	private static List<List<Integer>> findThreeSumBySorting(int[] nums){
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for(int i=0;i<nums.length;i++) {
			
			//skip for duplicates of i
			 if(i>0 && nums[i]==nums[i-1])
				 i++;
			 
			 int j = i+1;
			 int k = nums.length-1;
			 
			 while(j<k) {
				 int sum = nums[i]+nums[j]+nums[k];
				 
				 if(sum==0) {
					 result.add(Arrays.asList(nums[i],nums[j],nums[k]));
					 
					 //remove duplicates of j
					 if(j<k && nums[j]==nums[j+1])
						 j++;
					 
					 //remove duplicates of k
					 if(j<k && nums[k]==nums[k-1])
						 k--;
					 
					 //since we have j,k are part of triplet , j,k pointers move from both sides 
					 j++;
					 k--;
					 
				 }else if(sum>0) {
					//want smaller number 
					 k--;
				 }else {
					
					 j++;
				 }
				 
				 
				 
			 }
		}
		
		
		return result;
		 
	}
	
	
	
	/*
	 * to avoid duplicates we can use HashMap<Integer,Integer> 
	 * map.put(nums[i],i);
	 * 
	 * same number in the array being mapped to updated pointer of j
	 */
	private static List<List<Integer>> findThreeSumUsingHahsMap(int[] nums){
		List<List<Integer>> result  = new ArrayList<List<Integer>>();
		
		//sort the Array
			Arrays.sort(nums);
		
		//Edge Cases
		if(nums.length<3)
			return result;
		
		if(nums[0]>0)
			return result;
		
		//create hashmap for required element iteration 
		// avoid the duplicates by mapping nums of array as key and values being iterator
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			hashMap.put(nums[i], i);
		}
		
		for(int i=0;i<nums.length-2;i++) {
			
			for(int j=i+1;j<nums.length-1;j++) {
				
				int  k = -1 * ( nums[i]+nums[j] );
				
				if(hashMap.containsKey(k) && hashMap.get(k)>j) {
					result.add(Arrays.asList(nums[i],nums[j],k));
				}
				//update j to avoid duplicates
				j = hashMap.get(nums[j]);
			}
			
			//update i to avoid duplicates
			i = hashMap.get(nums[i]);
		}
		return result;
	}

}
