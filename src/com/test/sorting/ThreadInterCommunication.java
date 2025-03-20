package com.test.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhotoFrame{
	private int id;
	private String material,size,texture,color;
	public PhotoFrame(int id, String material, String size, String texture, String color) {
		super();
		this.id = id;
		this.material = material;
		this.size = size;
		this.texture = texture;
		this.color = color;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the texture
	 */
	public String getTexture() {
		return texture;
	}
	/**
	 * @param texture the texture to set
	 */
	public void setTexture(String texture) {
		this.texture = texture;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	};
	
	
}

class MaintainPhotoFrame{
	Map<String, List<PhotoFrame>> availableFrames = new HashMap<String, List<PhotoFrame>>();
	
	public boolean isAvailable(String type) {
		synchronized (availableFrames) {
		if(!availableFrames.isEmpty() && availableFrames.containsKey(type)) {
			System.out.println(Thread.currentThread().getName()+" : This photo Frame is availble in stock");
			
			return true;
		}
		
		System.out.println(Thread.currentThread().getName()+" : This photo Frame is out of stock");
		return false;
		}
	}
	
	
	public void buyStock(String type) {
		
		synchronized (availableFrames) {
			if(!availableFrames.isEmpty()&&availableFrames.containsKey(type)) {
				
				List<PhotoFrame> photoFrameList = availableFrames.remove(type);
				photoFrameList.remove(0);
				availableFrames.put(type, photoFrameList);
				System.out.println(Thread.currentThread().getName()+" "
						+ ": This photo Frame will be delivered to the given address");
				
			}
			
			System.out.println(Thread.currentThread().getName()+" : This photo Frame is out of stock");
			
		}
	
	}
	
	
	public void updateAvailablityToBuyer(String type) {
		synchronized (availableFrames) {
			
			while(availableFrames.isEmpty() && !availableFrames.containsKey(type)) {
				try {
					availableFrames.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				
			}
			//send Notification to Buyers
			System.out.println(Thread.currentThread().getName()+
					" Update Buyer  This photo Frame is now availble in stock");
			
		}
	}
	
	public void updateAvailbilityOnUI(String type) {
		synchronized (availableFrames) {
			while (availableFrames.isEmpty() && !availableFrames.containsKey(type)) {
				try {
					System.out.println(Thread.currentThread().getName()+" "
							+ ": This photo Frame is out of stock , waiting for stock updated");
					
					availableFrames.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
			//Enable Add to card button UI screen
			System.out.println(Thread.currentThread().getName()+" : This photo Frame is availble now in stock");
			
		}
	}
	
	//unlike wait() method notify() and notifyAll() method will not release the lock immediately
	// it will do all the task assigned and then release locks to JVM
	public void putStock(PhotoFrame photoFrame) {
		synchronized (availableFrames) {
			String type = "c"+photoFrame.getColor()+"-t"+photoFrame.getTexture();
			if(availableFrames.containsKey(type)) {
				List<PhotoFrame> photoFrameList = availableFrames.get(type);
				photoFrameList.add(photoFrame);
				availableFrames.put(type, photoFrameList);
			}else {
				List<PhotoFrame> photoFrameList = new ArrayList<PhotoFrame>();
				photoFrameList.add(photoFrame);
				availableFrames.put(type, photoFrameList);
			}
			
			availableFrames.notifyAll();
			System.out.println(Thread.currentThread().getName()+" : Added to stock ,mThis photo Frame is availble in stock"
					+ "Sending Notification to All");
			
		}
	}
	
}


public class ThreadInterCommunication {
	public static void main(String[] args) {
		MaintainPhotoFrame maintainPhotoFrame = new MaintainPhotoFrame();
		
		Thread uiThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String type = "cBrown-tCrack";
				maintainPhotoFrame.updateAvailbilityOnUI(type);
				
			}
		},"UiThread");
		uiThread.start();
		
		Thread buyerThread  = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String type = "cBrown-tCrack";
				if(maintainPhotoFrame.isAvailable(type)) {
					maintainPhotoFrame.buyStock(type);
				}else {
					maintainPhotoFrame.updateAvailablityToBuyer(type);
				}
				
			}
		},"BuyerThread");
		
		buyerThread.start();
		
		
		Thread sellerThread  = new Thread(new Runnable() {
			
			@Override
			public void run() {
				String type = "cBrown-tCrack";
				PhotoFrame photoFrame = new PhotoFrame(1, "Wooden", "4X6", "Crack", "Brown");
				maintainPhotoFrame.putStock(photoFrame);
				
			}
		},"SellerThread");
		
		sellerThread.start();
	}
	
}
