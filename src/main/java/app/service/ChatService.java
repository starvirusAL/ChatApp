package app.service;

import app.models.Chats;
import app.models.UserMassage;
import app.repo.ChatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepo repo;

    public void create(Chats chat){
        repo.save(chat);
    }



    public Chats getChatById(int id){
        return repo.getChatById(id);
    }

}
