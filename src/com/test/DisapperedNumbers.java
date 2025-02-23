package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DisapperedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DisapperedNumbers disApprNums = new DisapperedNumbers();
			int[] nums = {4,3,2,7,8,2,3,1};
			disApprNums.findDisappearedNumbers(nums);
			
//			System.out.println(Arrays.toString(disApprNums.findDisapperedNums_v1(nums)));
			
//			Stream.of(disApprNums.findDisapperedNums(nums)).forEach(n->System.out.println(n+" "));
	}
	
	
	
	
	private List<Integer> findDisapperedNums(int[] nums) {
		List<Integer> result  = new ArrayList<Integer>();
		List<Integer> testResult  = Arrays.stream(nums).boxed().toList();
		for(int i=1;i<=nums.length;i++) {
			if(!testResult.contains(i))
				result.add(i);
		}
		return result;
	}
	
	
	private int[] findDisapperedNums_v1(int[] nums) {
		int k=0;
		int[] result = new int[nums.length] ;
		
		
		for(int i=1;i<=nums.length;i++) {
			boolean found = false;
			for(int j=0;j<nums.length;j++) {
				if(nums[j]==i) {
					found=true;
					break;
					}
			}
			if(!found) {
				result[k]=i;
				k++;
				
				}
				
		}
		return result;
	}
	
	/*
	 * For every number in nums, calculate its corresponding index: index = abs(num) - 1.
Negate the value at nums[index] to mark it as "visited" (only if it hasn't been negated already).
After processing, iterate through the array again. If a number at index i is positive, it means the number i + 1 is missing from the array.
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            System.out.println(index);
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }  
        return ans;
    }

}
