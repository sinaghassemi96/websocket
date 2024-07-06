package com.example.websocket;

import com.example.websocket.entity.repo.ChatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class WebsocketApplication {

	private final ChatRepo chatRepo;


	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);
	}

//	@PostConstruct
//	private void createChat() {
//		Chat chat = new Chat();
//		chatRepo.save(chat);
//	}

}
