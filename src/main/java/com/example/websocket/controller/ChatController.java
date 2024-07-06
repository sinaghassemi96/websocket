package com.example.websocket.controller;

import com.example.websocket.entity.Chat;
import com.example.websocket.entity.Message;
import com.example.websocket.entity.repo.ChatRepo;
import com.example.websocket.entity.repo.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ChatController {


    private final ChatRepo chatRepo;
    private final MessageRepo messageRepo;

    @MessageMapping("/chat/{chatId}")
    @SendTo("/topic/messages")
    public Message sendMessage(@Payload Message message, @DestinationVariable Long chatId) {
        Chat chat = chatRepo.findById(chatId).orElseThrow();
        message.setChat(chat);
        message.setTimestamp(LocalDateTime.now());
        messageRepo.save(message);
        return message;
    }



}
