package com.test.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	

	     public static int numIslands(char[][] grid) {
		        int row= grid.length;
		        int col= grid[0].length;
		        int count =0;
		        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

		        for(int i=0;i<row;i++){
		        	
		            for(int j=0;j<col;j++){

		                if(grid[i][j]=='1'){
		                	
		                    count++;
		                    grid[i][j]='0';
		              
		                   Queue<int[]> queque = new LinkedList<int[]>();
		                   queque.offer(new int[] {i,j});
		                   
		                   while(!queque.isEmpty()) {
		                	   int[] pos = queque.poll();
		                	 for(int[] dir:directions) {
		                		 int x = dir[0]+pos[0];
		                		 int y = dir[1]+pos[1];
		                		 
		                		 if(x>=0 && x<row&& y>=0 && y<col && grid[x][y]=='1') {
		                			 queque.offer(new int[] {x,y});
		                			 
		                			 grid[x][y]='0';
		                			 }
		                		 
		                	 }  
		                   }
		                }
		            }
		        }
		        return count;
		    }
	
	    public static void main(String[] args) {
	    	
			char[][] grids = {
					{'1','1','0','0','0'},
					{'1','1','0','0','0'},
					{'0','0','1','0','0'},
					{'0','0','0','1','1'},
			};
			
//			System.out.println(numIslands(grids));
			
			System.out.println(calNumIslands(grids));
		}
	    
	    /*
	     * DFS approach with recursion
	     */
	    
	    public static int calNumIslands(char[][] grid) {
	    	
	    	int row = grid.length;
	    	int col = grid[0].length;
	    	int isLandsCount =0;
	    	
	    	for(int i=0;i<row;i++) {
	    		
	    		for(int j=0;j<col;j++) {
	    			
	    			if(grid[i][j]=='1') { //found '1' isLand
	    				
	    				isLandsCount++;
	    				dfs(grid, i, j);
	    				
	    			}
	    		}
	    	}
	    return isLandsCount;
	    }
	    
	    
	    private static void dfs(char[][] grid, int x,int y) {
	    	int row =grid.length;
	    	int col = grid[0].length;
	    	
	    	if(x<0||x>=row || y<0 || y>=col || grid[x][y]=='0')
	    		return;
	    	
	    	grid[x][y]='0'; //mark visited and explore to 4 directions paths
	    	
	    	dfs(grid, x+1, y);
			dfs(grid, x-1, y);
			dfs(grid, x, y+1);
			dfs(grid, x, y-1);
	    }
}
