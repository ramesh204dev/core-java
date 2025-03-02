package com.test.v1;

public class MaximumProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  prices = {7,1,5,3,6,4};
		
		int[] testPrices1 = {7,6,4,3,1};
	
		
		System.out.println(bestTimeBuyAndSell(testPrices1));
		
		System.out.println(bestTimeBuyAndSellAlgo(prices));
		}
	
	
	private static int bestTimeBuyAndSell(int[] prices) {
		int maxProfit =0;
	   for(int i=0;i<prices.length;i++) {
			
			for(int j=i+1;j<prices.length;j++) {
				int profit = prices[j]-prices[i];
				if(profit>maxProfit)
					maxProfit = profit;
			}
		}
	return maxProfit; 
	}
	
	/*
	 * Time Complexity O(n)
	 * Space Complexity O(1)
	 */
	
	private static int bestTimeBuyAndSellAlgo(int[] prices) {
		int maxProfit =0;
		
		int buy = prices[0];
			for(int i=1;i<prices.length;i++) {
				if(prices[i]<buy)
					buy = prices[i];
				else if(prices[i]-buy>maxProfit)
					maxProfit =prices[i]-buy;
			}
		return maxProfit;
	}

}
