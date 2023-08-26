package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "UserMassage")
public class UserMassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;


    String name;
    String massage;

    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @JsonIgnore
    @ManyToOne(cascade ={CascadeType.MERGE } ,fetch = FetchType.EAGER )
    @JoinColumn(name = "chat_id")
    private Chats chats;


    public  UserMassage(){

    }

    public UserMassage(User user, String name, String massage, Chats chats) {
        this.user = user;
        this.massage = massage;
        this.name = name;
        this.chats = chats;
    }

    @Override
    public String toString() {
        return String.format("Id: %s massage: %s", id, massage);
    }
}
