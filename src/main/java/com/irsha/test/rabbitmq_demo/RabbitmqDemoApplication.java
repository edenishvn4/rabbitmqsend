package com.irsha.test.rabbitmq_demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqDemoApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RabbitmqDemoApplication.class, args);
		Send send = new Send();
		send.sendRabbitMQ();
	}

}
