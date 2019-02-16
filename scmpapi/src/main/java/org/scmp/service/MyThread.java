package org.scmp.service;

import org.springframework.beans.factory.annotation.Autowired;

public class MyThread extends Thread {

	@Autowired
	ScmpService scmpService;
	Long counter;

	public MyThread(Long x) {
		this.counter = x;
		scmpService=new ScmpService();
	}

	public void run() {
		try {
			//System.out.println("2000" + counter + "ID" + "        " + 2000 + counter);
			scmpService.addVersionNumber(Thread.currentThread().getName(), 2000 + counter);

		} catch (Exception e) {
			System.out.println("Exception is caught:" + e.getMessage());
		}
	}
	

}
