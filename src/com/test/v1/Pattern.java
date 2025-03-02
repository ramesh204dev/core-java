package com.test.v1;

public class Pattern {
	public static void main(String[] args) {
		
		printPattern1(6);
		System.out.println();
		printPattern2(6);
		System.out.println();
		
		printPattern3(6);
		System.out.println();
		
		printPatten4(6);
		
		System.out.println();
		
		printPattern5(6);
	}
	
	
	private static void printPattern1(int n) {
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	private static void printPattern2(int n) {
		for(int i=n;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
				System.out.println();
		}
	}
	
	private static void printPattern3(int n) {
		for(int i=0;i<n;i++) {
			
			for(int j=n-i;j>1;j--) {
				System.out.print(" ");
			}
			
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	private static void printPatten4(int n) {
		for(int i=n;i>0;i--) {
			
			for(int j=n-i;j>1;j--) {
				System.out.print(" ");
			}
			
			for(int j=i;j>0;j--) {
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}
	
	
	private static void printPattern5(int n) {
		for(int i=1;i<=n;i++) {
			
		for(int j=1;j<=2*(n-i);j++) {
			System.out.print(" ");
		}	
		
		for(int j=i;j>=1;j--) {
			System.out.print(j+" ");
		}
		
		
		for(int j=2;j<=i;j++) {
			System.out.print(j+" ");
		}
		
		System.out.println();
		}
	}
}
