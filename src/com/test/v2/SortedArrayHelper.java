package com.test.v2;

import java.util.Arrays;

public class SortedArrayHelper {
	public static void main(String[] args) {
		int[] nums = { -4, -1, 0, 3, 9 };
		System.out.println(Arrays.toString(sortedSquares(nums)));
	}

	private static int[] sortedSquares(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int[] result = new int[nums.length];

		for (int i = nums.length - 1; i >= 0; i--) {

			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				result[i] = nums[left] * nums[left];
				left++;
			} else {
				result[i] = nums[right] * nums[right];
				right--;
			}
		}

		return result;

	}
}
