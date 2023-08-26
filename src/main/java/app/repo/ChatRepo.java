package app.repo;

import app.models.Chats;
import app.models.UserMassage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepo extends JpaRepository<Chats, Integer> {

    public Chats getChatById(int id);
}
