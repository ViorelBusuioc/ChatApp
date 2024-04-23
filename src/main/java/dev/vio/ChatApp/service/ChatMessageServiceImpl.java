package dev.vio.ChatApp.service;

import dev.vio.ChatApp.dao.ChatMessageRepository;
import dev.vio.ChatApp.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    private ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public List<ChatMessage> findAll() {
        return chatMessageRepository.findAll();
    }

    @Override
    public ChatMessage findById(int id) {

        Optional<ChatMessage> result = chatMessageRepository.findById(id);
        ChatMessage chatMessage = null;
        if(result.isPresent()) {
            chatMessage = result.get();
        } else {
            throw new RuntimeException("Did not find the message with id: " + id);
        }

        return chatMessage;
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public void deleteById(int id) {
        chatMessageRepository.deleteById(id);
    }
}
