package com.test;

public class TestTryWithResourceExampe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try (ResourcerAutoClose res =new ResourcerAutoClose()){
				res.doSomething();
			} catch (Exception e) {
				// TODO: handle exception
			}

	}

}
