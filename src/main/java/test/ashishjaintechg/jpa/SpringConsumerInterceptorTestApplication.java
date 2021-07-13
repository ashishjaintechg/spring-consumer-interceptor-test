package test.ashishjaintechg.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringConsumerInterceptorTestApplication {

	
	List<String> messages = new ArrayList<String>();
	
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}
	
	
	
	@KafkaListener(groupId = "java-1", topics="test", containerFactory ="kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerInterceptorTestApplication.class, args);
	}

}
