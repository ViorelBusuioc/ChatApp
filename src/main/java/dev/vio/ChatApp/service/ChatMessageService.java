package dev.vio.ChatApp.service;

import dev.vio.ChatApp.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    List<ChatMessage> findAll();

    ChatMessage findById(int id);

    ChatMessage save(ChatMessage chatMessage);

    void deleteById(int id);
}
