package com.ssh.user.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

	public void takeSeats(JoinPoint joinPoint){
		System.out.println("takeSeats.."+joinPoint.getSignature().getName());
	}
	
	public void clab(){
		System.out.println("very happy!");
	}
	
	public void drinkWater(){
		System.out.println("I need water.");
	}
	
	public void returnMoney(){
		System.out.println("disappointed..return my money");
	}
	
	public void noticeLogin(ProceedingJoinPoint joinPoint){
		System.out.println("this audience takeSeats");
		long start = System.currentTimeMillis();
		
		try {
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("login total Time:"+(start-end));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
