package com.lshaci.alipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlipayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlipayApplication.class, args);
		System.out.println("============= Start Alipay SpringBoot Server Success =============");
		synchronized (AlipayApplication.class) {
			try {
				AlipayApplication.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
