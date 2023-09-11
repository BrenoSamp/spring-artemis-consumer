package dev.br.breno.springartemisconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringArtemisConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringArtemisConsumerApplication.class, args);
	}

}
