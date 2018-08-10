package com.sqq.test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流实现两线程间通讯
 * @author PC
 *
 */
public class MultiThreadPipeTest {

	public static void main(String[] args) {
		PipedOutputStream pipedOutputStream = new PipedOutputStream();
		PipedInputStream pipedInputStream = new PipedInputStream();
		try {
			pipedInputStream.connect(pipedOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new MyProducer(pipedOutputStream).start(); 
		new MyConsumer(pipedInputStream).start(); 
	}

}

/**
 * 生产者每5秒提供5个产品，放入管道
 * @author PC
 *
 */
class MyProducer extends Thread {
	private PipedOutputStream pipedOutputStream;
	
	private int index = 0;
	
	public MyProducer(PipedOutputStream pipedOutputStream) {
		super();
		this.pipedOutputStream = pipedOutputStream;
	}
	
	@Override
	public void run() {
		while(true) {
			for (int i=0; i<5; i++) {
				try {
					pipedOutputStream.write(index++);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}

/**
 * 消费者每0.5秒从管道中取1件产品，并打印剩余产品数量，并打印产品信息（以数字替代）
 * @author PC
 *
 */
class MyConsumer extends Thread  {
	PipedInputStream pipedInputStream;

	public MyConsumer(PipedInputStream pipedInputStream) {
		super();
		this.pipedInputStream = pipedInputStream;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				int count = pipedInputStream.available();
				if (count>0) {
					System.out.println("rest product amount:"+count);
					System.out.println("get product is :"+pipedInputStream.read());
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
}
