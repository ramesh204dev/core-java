package com.test.v1;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LoggingKPI {
	String value() default "Method Execution Started ...";
}

class Student{
	
	@LoggingKPI
	public void checkStudent() {
		System.out.println("Student is checked");
	}
}

public class JavaAnnontations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student  = new Student();
		
			Method method;
			try {
				method = Student.class.getMethod("checkStudent");
				if(method.isAnnotationPresent(LoggingKPI.class)) {
					LoggingKPI logKPIAnnontation = method.getAnnotation(LoggingKPI.class);
					System.out.println(logKPIAnnontation.value());
					}
				
				try {
					method.invoke(student);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	}

}
