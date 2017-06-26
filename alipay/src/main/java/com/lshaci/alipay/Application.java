package com.lshaci.alipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("============= Dubbo Start On SpringBoot Success =============");
		synchronized (Application.class) {
			try {
				Application.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
