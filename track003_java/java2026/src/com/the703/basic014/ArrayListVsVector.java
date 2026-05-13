package com.the703.basic014;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListVsVector { 
	public static void main(String[] args) throws InterruptedException { 
		// ArrayList : 비동기화  → 단일스레드환경에서 빠름
		// Vector    : 동기화   → 멀티스레드환경에서 안전, 성능은 떨어짐. 
		
		List<Integer>  arrayList = new ArrayList<>();
		List<Integer>  vector    = new Vector<>();
		
		Thread t1 = new Thread( ()->{
			for(int i=0; i<1000; i++) { 
				arrayList.add(i);  
				try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); } 
			}
		});
		Thread t2 = new Thread( ()->{
			for(int i=1000; i<2000; i++) { 
				arrayList.add(i); 
				try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); } 
			}
		});
		
		t1.start(); t2.start();
		
		t1.join();  t2.join(); 
		System.out.println("ArrayList크기 : " + arrayList.size());
		
		////////////////////////////////////////////////////////////////////////////
		Thread t3 = new Thread( ()->{
			for(int i=0; i<1000; i++) { 
				vector.add(i);  
				try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); } 
			}
		});
		Thread t4 = new Thread( ()->{
			for(int i=1000; i<2000; i++) { 
				vector.add(i); 
				try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); } 
			}
		});
		
		t3.start(); t4.start();
		
		t3.join();  t4.join(); 
		System.out.println("Vector크기 : " + vector.size());
		
		
		
	} 
}







