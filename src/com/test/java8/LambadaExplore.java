package com.test.java8;

public class LambadaExplore {

    private String name = "Agent Smith";

    public void doLambda() {
        Doer doer = () -> {
            System.out.println(this.name);
        };
        doer.doAction();
    }

    public void doAnonymous() {
        Doer doer = new Doer() {
            @Override
            public void doAction() {
                System.out.println(LambadaExplore.this.name);  //To refer to the enclosing class instance, use OuterClassName.this.
            }
        };
        doer.doAction();
    }

    public void doAnnonymous(String str) {
    	String name = "Hello;";
    	
    	Doer doer = new Doer() {
			
			@Override
			public void doAction() {
			System.out.println("this.name "+name);
				
			}
		};
		
		doer.doAction();
    }
    
    /*
     * A lambda expression in Java is a concise way to represent
     *  anonymous functions (functions without a name). 
     *  It is primarily used to implement functional
     *   interfaces (interfaces with only one abstract method).

		Lambda expressions help write cleaner, 
		more readable, and concise code, especially for functional programming and stream API operations
     */
    public void doLambda(String s) {
    	Doer doer = () -> System.out.println("this.lambda.anonymous"+s); //lambda way of providing implementation
    	doer.doAction();
    }
    
    public static void main(String[] args) {
    	LambadaExplore lambada = new LambadaExplore();
        lambada.doLambda();
        lambada.doAnonymous();
        
        lambada.doAnnonymous("Ramesh");
    }
}

@FunctionalInterface
interface Doer {
    void doAction();
}
