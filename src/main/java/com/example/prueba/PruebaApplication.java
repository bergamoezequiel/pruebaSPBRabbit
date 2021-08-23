package com.example.prueba;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class PruebaApplication {
	private static final boolean NON_DURABLE = false;
    private static final String MY_QUEUE_NAME = "myQueue";

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
	
	@Bean
	public Queue myQueue() {
	    return new Queue("myQueue", false);
	}
	@Bean
	public Queue myQueue2() {
	    return new Queue("myQueue2", false);
	}
	@RabbitListener(queues = "myQueue2")
	public void listen(String in) {
	    System.out.println("Message read from myQueue : " + in);
	}
	
	
	
	

}
