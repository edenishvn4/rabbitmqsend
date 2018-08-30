package com.irsha.test.rabbitmq_demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqDemoApplication{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RabbitmqDemoApplication.class, args);
		Send send = new Send();
		for(int i =0;i<100;i++){
		    if(i%2==0){
                String[] data={"error","Run. Run. Or it will explode. "+i};
                Thread.sleep(3000);
                send.sendRabbitMQ(data);
            }else{
                String[] data={"info","muke lu melecot "+i};
                Thread.sleep(3000);
                send.sendRabbitMQ(data);
            }

        }
	}

}
