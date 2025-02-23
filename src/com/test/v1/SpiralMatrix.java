package com.test.v1;

import java.util.Arrays;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,9},{10,11,12,13}};
		int rowBegin =0;
		int rowEnd = matrix.length-1;
		int colBegin =0;
		int colEnd = matrix[0].length-1;
		int[] result  = new int[matrix.length*matrix[0].length];
		int k=0;
		
		while(rowBegin<=rowEnd && colBegin<=colEnd) {
			
			//left to right
			for(int i=colBegin;i<=colEnd;i++) {
				result[k++] = matrix[rowBegin][i];
			}
			rowBegin++;
			
			//top to bottom
			for(int i=rowBegin;i<=rowEnd;i++) {
				result[k++] = matrix[i][colEnd];
			}
			colEnd--;
			
			//right to left
			if(rowBegin<=rowEnd) {
				for(int i=colEnd;i>=colBegin;i--) {
					result[k++] = matrix[rowEnd][i];
				}
				rowEnd--;
			}	
			
			//bottom to top
			if(colBegin<=colEnd) {
				for(int i=rowEnd;i>=rowBegin;i--) {
					result[k++] = matrix[i][colBegin];
				}
				colBegin++;
			}
		}
		
		System.out.println(Arrays.toString(result));
		int[][] matrix1 = {{1,2,3,4},{5,6,7,9},{10,11,12,13},{14,15,16,17}};
		System.out.println(Arrays.toString(createSprialFromMatrix(matrix)));
		
		System.out.println(Arrays.toString(createSprialFromMatrix(matrix1)));
	}
	/*
	 * his is a very simple and easy to understand solution. I traverse right and increment rowBegin, then traverse down and decrement colEnd, then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.

The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates. If anyone can do the same thing without that check, please let me know!
	 */
	private static int[] createSprialFromMatrix(int[][] matrix) {
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		int[] result = new int[matrix.length*matrix[0].length];
		int k =0;
		
		while(rowBegin<=rowEnd && colBegin<=colEnd) {
			//move to right
			for(int i=colBegin ; i<=colEnd;i++) {
				result[k++] = matrix[rowBegin][i];
			}
			rowBegin++;
			
			//move to bottom
			for(int i=rowBegin; i<=rowEnd;i++) {
				result[k++] = matrix[i][colEnd];
			}
			colEnd--;
			
			if(rowBegin<=rowEnd) {
			//move to left
			for(int i=colEnd;i>=colBegin;i--) {
				result[k++] = matrix[rowEnd][i];
			}
			rowEnd--;
			}
			
			//move to top
			if(colBegin<=colEnd) {
			for(int i=rowEnd;i>=rowBegin;i--) {
				result[k++] = matrix[i][colBegin];
			}
			colBegin++;
			}
		}
		
		return result;
	}
}
