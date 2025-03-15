package com.test.v2;

public class MatrixHelper {
	public static void main(String[] args) {
		
		char[][] charMatrx = { {'H','E','A','L','O'},
				{'A','B','C','D','E'}};
		String s = "ABCDGH";
		char[] chars = s.toCharArray();
		
		int rowBegin = 0;
		int colBegin = 0;
		int rowEnd = charMatrx.length;
		int colEnd = charMatrx[0].length;
		boolean found = true;
		
		
		
		while(rowBegin<rowEnd) {
			
			if(chars[0]==charMatrx[rowBegin][0]) {
				
				
				for(int j=0;j<colEnd;j++) {
					if (chars[j]!=charMatrx[rowBegin][j])
						found=false;
				}
			
				
				if(found) {
					System.out.println("Given input string "+s+" found in the matrix");
					break;
					}
			}
			
			rowBegin++;
		}
		
		
		if(!found) {
			System.out.println("Given input string "+s+" is not found in the matrix");
			}
		
		
		
		System.out.println(wordCheckInMatrix(charMatrx, "HEALO"));
	}
	
	
	
	private static boolean wordCheckInMatrix(char[][] board, String word) {
		//iterate through each cell of matrix
		int row = board.length;
		int col = board[0].length;
		
		for(int i=0;i<row;i++) {
			
			for(int j=0;j<col;j++) {
				
				if(board[i][j]==word.charAt(0)) {
					System.out.println(i+" "+j);
					if(isWordPresent(board,word,i,j,0))
						return true;
					}
			}
		}
		
		return false;
		
	}
	
	
	private static boolean isWordPresent(char[][] board,String word,int row,int col,int index) {
		
		if(index==word.length()-1)
			return true;
		
		System.out.println("char looking for "+word.charAt(index));
		
		if(row<0 || row>=board.length || col<0 || col>=board[0].length ||
				board[row][col]!=word.charAt(index))
		{
			System.out.println(word.charAt(index)+" "+index+" r"+row+" c"+col);
			return false;}
		char temp =board[row][col] ;
		board[row][col] = '*';
		
		System.out.println("char looking for "+word.charAt(index)+"found"+index+ ",r"+row+",c"+col+" "+board[row][col]);
		
		boolean ans = isWordPresent(board, word, row, col-1, index+1) ||  //left
					isWordPresent(board, word, row, col+1, index+1) ||   //right
					isWordPresent(board, word, row-1, col, index+1) ||  //up
					isWordPresent(board, word, row+1, col, index+1);   //down
		System.out.println(ans+" "+row+" "+col+" "+index);
		
		board[row][col] = temp;
		
		return ans;
	}
}
