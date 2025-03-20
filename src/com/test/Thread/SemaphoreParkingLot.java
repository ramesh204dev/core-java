package com.test.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class ParkingLot {
	private Semaphore semaphore;
	ParkingLot(int permits){
		semaphore = new Semaphore(permits, true); //FIFO fair order
	}
	
	public void parkCar(String carName) {
		try {
			System.out.println("Car "+carName+" is trying to park");
			semaphore.acquire();
			System.out.println(carName+" is parked");
			TimeUnit.SECONDS.sleep(5);
			System.out.println(carName+" is leaving");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
		
	}
	
}

/*
 * A Semaphore in Java is a synchronization mechanism that
 *  controls access to a shared resource using a set number of permits. 
 *  It is part of the java.util.concurrent package and is useful 
 *  for managing concurrent access to resources in multithreaded environments.


 */
public class SemaphoreParkingLot {
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot(3);  // 3 parking spots
		
		Runnable carTask = () -> parkingLot.parkCar(Thread.currentThread().getName());
		
		for(int i=0;i<=5;i++) {
			new Thread(carTask,"Car - "+i).start();;
		}
	}
}
