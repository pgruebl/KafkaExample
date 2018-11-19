package de.nunki.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class KafkaProducerApplication {



	@RestController
	public static class MessageController {


		@Value("${app.topic}")
		private String topic;

		@Autowired
		private KafkaTemplate<String, String> kafkaTemplate;

		@GetMapping("/sendMessage")
		public String helloWorld(
				@RequestParam final String message) {
			kafkaTemplate.send(topic, message);
			return "Message sent\n";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}
}
